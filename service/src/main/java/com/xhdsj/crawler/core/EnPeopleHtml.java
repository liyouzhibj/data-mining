package com.xhdsj.crawler.core;

import com.xhdsj.crawler.MyhttpClient.HttpClientHelper;
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
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 功能描述: 人民网
 *
 * @auther: njw
 * @date: 2018/4/17 
 */

public class EnPeopleHtml {

    static Logger logger =Logger.getLogger(EnPeopleHtml.class.getName());

    private static String url = "http://en.people.cn";


    public static void main(String[] args) {
        List<String> stringList = getFirstHtmlOne();
        getArticle(stringList);


    }

    public static  List<Article> getArticleList(){
        List<String>  stringList = getFirstHtml();
        return getArticle(stringList);
    }

    public static  List<Article> getArticleListEveryDay(){
        List<String>  stringList = getFirstHtmlOne();
        return getArticle(stringList);
    }

    public static List<String> getFirstHtmlOne(){
        String str =  HttpClientHelper.sendHttpGet("http://en.people.cn/");
        Document doc= Jsoup.parse(str); // 解析网页 得到文档对象
        Elements linkElements=doc.select("div.w980.nav b a"); //通过选择器查找所有链接DOM
        List<String> listNav = new ArrayList<String>();
        for(Element e:linkElements){
            if(!"Home".equals(e.text())&&!"Photo".equals(e.text())&&!"Video".equals(e.text())&&!"Travel".equals(e.text())){
                listNav.add(url+e.attr("href"));
            }
        }
        List<String> listPage = new ArrayList<String>();
        for(String ln : listNav){
            String strNav =  HttpClientHelper.sendHttpGet(ln);
            String firstPage = ln;
            List <String> listPage2 = new ArrayList<String>();
                if(strNav!=null){
                    Document docp = Jsoup.parse(strNav);
                    Elements elements = docp.select("div.d2_17.clear div.on1.clear h3 a");
                    for(Element e : elements) {
                        listPage2.add(e.attr("href"));
                    }
            }
            listPage.addAll(listPage2);
        }
        return listPage;
    }


    public static List<String> getFirstHtml(){
        String str =  HttpClientHelper.sendHttpGet("http://en.people.cn/index.html");
        Document doc= Jsoup.parse(str); // 解析网页 得到文档对象
        BloomFilter bloomFilter = new BloomFilter();
        Elements linkElements=doc.select("div.w980.nav b a"); //通过选择器查找所有链接DOM
        List<String> listNav = new ArrayList<String>();
        for(Element e:linkElements){
            if(!"Home".equals(e.text())&&!"Photo".equals(e.text())&&!"Video".equals(e.text())&&!"Travel".equals(e.text())){
                listNav.add(url+e.attr("href"));
            }
        }
        List<String> listPage = new ArrayList<String>();
        for(String ln : listNav){
            String strNav =  HttpClientHelper.sendHttpGet(ln);
            String firstPage = ln;
            int page = 1;
            List <String> listPage2 = new ArrayList<String>();
            while(true){

                firstPage = ln.replaceAll(".html","")+page+".html";
                String strp =  HttpClientHelper.sendHttpGet(firstPage);
                if(strp!=null){
                    Document docp = Jsoup.parse(strp);
                    Elements elements = docp.select("div.d2_17.clear div.on1.clear h3 a");
                    for(Element e : elements){
                       String hr =  e.attr("href");
                        if(!bloomFilter.contains(hr)) {
                            listPage2.add(hr);
                            bloomFilter.addValue(hr);
                        }
                    }
                    page++;
                }else {break;}
            }
            listPage.addAll(listPage2);
        }
        return listPage;
    }


    public static List<Article> getArticle(List<String> stringList){
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Article> listArticle = new ArrayList<Article>();
        for(String sl:stringList) {
            if (!executor.isShutdown()) {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        String strp = HttpClientHelper.sendHttpGet(url + sl);
                        if (strp == null) return;
                        Document docp = Jsoup.parse(strp);
                        Article article = new Article();
                        Element elements = docp.select("#p_title").first();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm, MMM d, yyyy", Locale.ENGLISH);
                        if (elements == null) {
                            if (docp.select("div.w980.wb_10.clear h1").first() != null) {
                                String title = docp.select("div.w980.wb_10.clear h1").first().text();
                                article.setTitle(title);
                                try {
                                    String dateString = docp.select("div.w980.wb_10.clear div").first().text();
                                    String[] strings = dateString.split("\\)");
                                    Date date = dateFormat.parse(strings[1].trim().replaceAll("    ", ""));
                                    article.setCreateTime(date);
                                    String content = docp.select("div.wb_12.clear p").text();
                                    if ("".equals(content)) {
                                        article.setContent(docp.select("div.page_pic div.pic")./*first().getElementsByAttributeValue("align","center").*/text());
                                    } else {
                                        article.setContent(content);
                                    }
                                    article.setPublishTime(new Date());
                                    article.setCrawlingTime(new Date());
                                    article.setDeleteFlag((short) 0);
                                    article.setCrawlingId((short) 1);
                                    article.setSource("en.people.cn");
                                    article.setCrawlingUrl(url + sl);
                                    listArticle.add(article);

                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                if (docp.select("div.d2p3_left.wb_left.fl h2").first() == null) return;
                                String title = docp.select("div.d2p3_left.wb_left.fl h2").first().text();
                                article.setTitle(title);
                                String dateString = docp.select("div.d2p3_left.wb_left.fl div.wb_1.clear").first().text();
                                String[] strings = dateString.split("\\)");
                                Date date = null;
                                try {
                                    date = dateFormat.parse(strings[1].trim().replaceAll("    ", ""));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                article.setCreateTime(date);
                                article.setContent(docp.select("div.d2p3_left.wb_left.fl p").text());
                                article.setPublishTime(new Date());
                                article.setCrawlingTime(new Date());
                                article.setDeleteFlag((short) 0);
                                article.setCrawlingId((short) 1);
                                article.setSource("en.people.cn");
                                article.setCrawlingUrl(url + sl);

                                listArticle.add(article);

                            }
                        } else {
                            if (docp.select("div.wb_1.clear").first() == null) return;
                            String dateString = docp.select("div.wb_1.clear").first().text();
                            String[] strings = dateString.split("\\)");
                            article.setTitle(elements.text());
                            try {
                                Date date = dateFormat.parse(strings[1].trim().replaceAll("    ", ""));
                                article.setCreateTime(date);
                                article.setContent(docp.select("#p_content").text());
                                article.setPublishTime(new Date());
                                article.setCrawlingTime(new Date());
                                article.setDeleteFlag((short) 0);
                                article.setCrawlingId((short) 1);
                                article.setSource("en.people.cn");
                                article.setCrawlingUrl(url + sl);

                                listArticle.add(article);

                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }
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
