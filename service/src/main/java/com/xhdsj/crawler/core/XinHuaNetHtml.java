package com.xhdsj.crawler.core;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSpan;
import com.xhdsj.crawler.MyhttpClient.HttpClientHelper;
import com.xhdsj.crawler.htmlUnit.HtmlUnitHelper;
import com.xhdsj.model.Article;
import com.xhdsj.service.util.BloomFilter;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 功能描述: 新华网
 *
 * @auther: njw
 * @date: 2018/4/17
 */

public class XinHuaNetHtml {

    static Logger logger =Logger.getLogger(XinHuaNetHtml.class.getName());


    public static void main(String[] args) {
    //    getFirstHtmlOne(0,7);
       List<String> listUrl = getFirstHtmlEveryOne();
      /*  List<String> listUrl = new ArrayList<>();
        listUrl.add("http://www.xinhuanet.com/english/2017-12/02/c_136795893.htm");*/
       getArticle(listUrl);

    }


    public static  List<Article> getArticleList(){
        List<String>  stringList = getFirstHtmlOne();
        return getArticle(stringList);
    }

    public static  List<Article> getArticleListEveryDay(){
        List<String>  stringList = getFirstHtmlEveryOne();
        return getArticle(stringList);
    }

    public static List<String> getFirstHtmlOne() {
        ExecutorService executor = Executors.newCachedThreadPool();
        String str = HttpClientHelper.sendHttpGet("http://www.xinhuanet.com/english/");
        Document doc = Jsoup.parse(str); // 解析网页 得到文档对象
        List<String> list = new ArrayList<String>();
        BloomFilter bloomFilter = new BloomFilter();
        Elements linkElements = doc.select("div.nav #nav li:not(.bor,.on) a"); //通过选择器查找所有链接DOM
        List<String> listUrl = new ArrayList<String>();
        int sum = 0;
        for(Element el : linkElements){
           String url =  el.attr("href");
           if("http://forum.home.news.cn/english/".equals(url))continue;
           list.add(url);
        //   if(list.size()==2)break;
        }
        for(String l:list){
            WebClient webClient = HtmlUnitHelper.getConnection(null);
            HtmlPage page = null;
            //获取页面
            try {
                page =  HtmlUnitHelper.sendGetRequest(webClient,l);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            if(page==null) continue;
            Document doc1 = Jsoup.parse(page.asXml());
            Elements linkElements1 = doc1.select("div.navigate ul.inline li a"); //通过选择器查找所有链接DOM
            if(linkElements1.size()==0)continue;
            for(Element e : linkElements1){
                if (!executor.isShutdown()) {
                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    executor.execute(new Runnable() {
                        @Override
                        public void run() {
                try {
                    int max;
                    {
                    HtmlPage  page1 = HtmlUnitHelper.sendGetRequest(webClient,e.attr("href"));
                    if(page1==null) return;
                    Document doc2 = Jsoup.parse(page1.asXml());
                    Elements linkElements2 = doc2.select("#showData0 li h3 a"); //通
                    for(Element e2:linkElements2){
                        String url = e2.attr("href");
                        if(!bloomFilter.contains(url)) {
                            listUrl.add(url);
                            bloomFilter.addValue(url);
                        }
                    }
                    List<HtmlSpan>  htmlSpanList =  page1.getByXPath("//div[@id='wPaginate8']/div/span[@class='_wPaginate_link _wPaginate_link_last']");
                    if(htmlSpanList.size()==0)return;
                    HtmlSpan span = htmlSpanList.get(0);
                    HtmlPage page2 = span.click();
                    HtmlSpan span2 =(HtmlSpan)page2.getByXPath("//div[@id='wPaginate8']/div/span[@class='_wPaginate_link _wPaginate_link_active']").get(0);
                    max = Integer.parseInt(span2.asText());
                    }
                    HtmlPage  page3 = HtmlUnitHelper.sendGetRequest(webClient,e.attr("href"));
                    for(int i=0;i<max;i++){
                        List<HtmlSpan>  htmlSpanList1 = page3.getByXPath("//div[@id='wPaginate8']/div/span[@class='_wPaginate_link _wPaginate_link_next']");
                        if(htmlSpanList1.size()==0){
                            System.out.println(e.attr("href"));
                            continue;
                        }
                        HtmlSpan span3 = htmlSpanList1.get(0);
                        page3 = span3.click();
                        Document doc3 = Jsoup.parse(page3.asXml());
                        Elements linkElements3 = doc3.select("#showData0 li h3 a"); //通
                        for(Element e3:linkElements3){
                            String url = e3.attr("href");
                            if(!bloomFilter.contains(url)) {
                                listUrl.add(url);
                                bloomFilter.addValue(url);
                            }
                        }
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                }
        });
    }

            }

        }
        executor.shutdown();
        while(true){
            if(executor.isTerminated()){
                break;
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return  listUrl;
    }





    public static List<String> getFirstHtmlEveryOne() {
        ExecutorService executor = Executors.newCachedThreadPool();
        String str = HttpClientHelper.sendHttpGet("http://www.xinhuanet.com/english/");
        Document doc = Jsoup.parse(str); // 解析网页 得到文档对象
        List<String> list = new ArrayList<String>();
        BloomFilter bloomFilter = new BloomFilter();
        Elements linkElements = doc.select("div.nav #nav li:not(.bor,.on) a"); //通过选择器查找所有链接DOM
        List<String> listUrl = new ArrayList<String>();
        for(Element el : linkElements){
            String url =  el.attr("href");
            if("http://forum.home.news.cn/english/".equals(url))continue;
            list.add(url);
            //   if(list.size()==2)break;
        }
        for(String l:list){
            WebClient webClient = HtmlUnitHelper.getConnection(null);
            HtmlPage page = null;
            //获取页面
            try {
                page =  HtmlUnitHelper.sendGetRequest(webClient,l);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            if(page==null) continue;
            Document doc1 = Jsoup.parse(page.asXml());
            Elements linkElements1 = doc1.select("div.navigate ul.inline li a"); //通过选择器查找所有链接DOM
            if(linkElements1.size()==0)continue;
            for(Element e : linkElements1){
                if (!executor.isShutdown()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    executor.execute(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                int max;
                                {
                                    HtmlPage  page1 = HtmlUnitHelper.sendGetRequest(webClient,e.attr("href"));
                                    if(page1==null) return;
                                    Document doc2 = Jsoup.parse(page1.asXml());
                                    Elements linkElements2 = doc2.select("#showData0 li h3 a"); //通
                                    for(Element e2:linkElements2){
                                        String url = e2.attr("href");
                                        if(!bloomFilter.contains(url)) {
                                            listUrl.add(url);
                                            bloomFilter.addValue(url);
                                        }
                                    }
                                  /*  List<HtmlSpan>  htmlSpanList =  page1.getByXPath("//div[@id='wPaginate8']/div/span[@class='_wPaginate_link _wPaginate_link_last']");
                                    if(htmlSpanList.size()==0)return;
                                    HtmlSpan span = htmlSpanList.get(0);
                                    HtmlPage page2 = span.click();
                                    HtmlSpan span2 =(HtmlSpan)page2.getByXPath("//div[@id='wPaginate8']/div/span[@class='_wPaginate_link _wPaginate_link_active']").get(0);
                                    max = Integer.parseInt(span2.asText());*/
                                }
                                HtmlPage  page3 = HtmlUnitHelper.sendGetRequest(webClient,e.attr("href"));
                                for(int i=0;i<1;i++){
                                    List<HtmlSpan>  htmlSpanList1 = page3.getByXPath("//div[@id='wPaginate8']/div/span[@class='_wPaginate_link _wPaginate_link_next']");
                                    if(htmlSpanList1.size()==0){
                                        System.out.println(e.attr("href"));
                                        continue;
                                    }
                                    HtmlSpan span3 = htmlSpanList1.get(0);
                                    page3 = span3.click();
                                    Document doc3 = Jsoup.parse(page3.asXml());
                                    Elements linkElements3 = doc3.select("#showData0 li h3 a"); //通
                                    for(Element e3:linkElements3){
                                        String url = e3.attr("href");
                                        if(!bloomFilter.contains(url)) {
                                            listUrl.add(url);
                                            bloomFilter.addValue(url);
                                        }
                                    }
                                }
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        }
                    });
                }

            }

        }
        executor.shutdown();
        while(true){
            if(executor.isTerminated()){
                break;
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return  listUrl;
    }





    public static List<Article> getArticle(List<String> stringList){
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(100);
        List<Article> listArticle = new ArrayList<Article>();
        for(String sl:stringList) {
            while(true) {
                if (executor.getActiveCount() != 100) {
                    break;
                }
            }
            if (!executor.isShutdown()) {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        String strp = HttpClientHelper.sendHttpGet(sl);
                        if (strp == null) return;
                        Document docp = Jsoup.parse(strp);
                        Article article = new Article();
                        Element e = docp.select("h1.Btitle").first();
                        if(e==null){
                            e = docp.select("#id").first();
                            if(e==null) {
                                e = docp.select("#bltitle").first();
                                if(e==null){
                                    e = docp.select("#Title").first();
                                    if(e==null){
                                        e = docp.select("td.hei22").first();
                                        if(e==null){
                                            e = docp.select("#whtitle").first();
                                            if(e==null){
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if(e.text()==null||"".equals(e.text()))return;
                        article.setTitle(e.text());
                        String dateStr = null;
                        Element edate = docp.select("i.time").first();
                        if(edate==null){
                            edate=docp.select("td.sj").first();
                            if(edate!=null){
                                dateStr = edate.ownText().trim().replaceAll("   ","").replaceAll("   ","");
                            }else{
                                dateStr = docp.select("#pubtime").first().text().trim().replaceAll("   ","");
                            }
                        }else {
                            dateStr = edate.text().trim().replaceAll("   ","");
                        }

                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date date = null;
                        try {
                            if("".equals(dateStr))return;
                            date = dateFormat.parse(dateStr);
                        } catch (ParseException e1) {
                            System.out.println(sl);
                            e1.printStackTrace();
                        }
                        article.setCreateTime(date);
                        Elements e1 = docp.select("div.content p");
                        if(e1==null){
                            e1 = docp.select("#Content");
                            if(e1==null) {
                                e1 = docp.select("#content");
                                if(e1==null){
                                    return;
                                }
                            }
                        }
                        String content = e1.text();
                        article.setSource("Xinhua");
                        article.setContent(content);
                        article.setPublishTime(new Date());
                        article.setCrawlingTime(new Date());
                        article.setDeleteFlag((short) 0);
                        article.setCrawlingId((short) 2);
                        article.setCrawlingUrl(sl);
                        listArticle.add(article);
                    }
                });
            }
        }
        executor.shutdown();
        while(true){
            if(executor.isTerminated()){
                break;
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  listArticle;
    }

}
