package com.xhdsj.crawler.core;

import com.xhdsj.crawler.MyhttpClient.HttpClientHelper;
import com.xhdsj.model.Article;
import com.xhdsj.service.ArticleService;
import com.xhdsj.service.impl.ArticleServiceImpl;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 功能描述: 中国日报
 *
 * @auther: njw
 * @date: 2018/4/18
 */


public class ChinaDailyHtml {


    static Logger logger =Logger.getLogger(ChinaDailyHtml.class.getName());

    static ArticleService articleService = new ArticleServiceImpl();

    public static void main(String[] args) {
        List<String> list = getFirstHtml();

        getArticle(list);
        //调用service层的方法
        int count = articleService.insertByBatchChina();
        System.out.println("爬取的数据================" +count);

    }


    public static  List<Article> getArticleList(){
        List<String>  stringList = getFirstHtml();
        return getArticle(stringList);
    }

    public static  List<Article> getArticleListEveryDay(){
        List<String>  stringList = getFirstHtmlOne();
        return getArticle(stringList);
    }



    public static List<String> getFirstHtml(){
        BloomFilter bloomFilter = new BloomFilter();
        ExecutorService executor = Executors.newCachedThreadPool();
        String str =  HttpClientHelper.sendHttpGet("http://www.chinadaily.com.cn/china");
        // 解析网页,得到文档对象
        Document doc= Jsoup.parse(str);
        // 通过选择器查找所有链接DOM
        Elements linkElements=doc.select("div.topNav ul.dropdown li a");
        List<String> listNav = new ArrayList<String>();

        List<String> listArticle = new ArrayList<String>();

        for(Element l:linkElements){
            String l1 = l.attr("href");
            if(!IsUrl(l1))continue;
            String str1 =  HttpClientHelper.sendHttpGet(l1);
            // 解析网页,得到文档对象
            Document doc1= Jsoup.parse(str1);
            Elements elements = doc1.select(".topNav2_art ul li a");
            if(elements.size()==0||elements==null)continue;
            for(Element e:elements){
                String url = e.attr("href");
                String str2 =  HttpClientHelper.sendHttpGet(url);
                // 解析网页,得到文档对象
                Document doc2 = Jsoup.parse(str2);
                Elements elements2 = doc2.select("div.lft_art.lf");
                if(elements2.size()==0||elements2==null)continue;
                listNav.add(url);
            }
        }

        for(String l:listNav){
            if (!executor.isShutdown()) {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        String str1 =  HttpClientHelper.sendHttpGet(l);
                        // 解析网页,得到文档对象
                        Document doc1 = Jsoup.parse(str1);
                        Elements elements = doc1.select("#div_currpage a");
                        Elements elements1 =  doc1.select(".tw2 a");
                        for (Element e:elements1){
                            String articleUrl = e.attr("href");
                            if(!bloomFilter.contains(articleUrl)) {
                                listArticle.add(articleUrl);
                                bloomFilter.addValue(articleUrl);
                            }

                        }
                        if(elements.size()==0){
                            System.out.println(l);
                            return;
                        }
                        Element e = elements.get(elements.size()-1);
                        String url = e.attr("href");
                        String strlast =  HttpClientHelper.sendHttpGet(url);
                        // 解析网页,得到文档对象
                        Document doclast = Jsoup.parse(strlast);
                        int page = Integer.parseInt(doclast.select("#div_currpage span").text());
                        for(int i = 1;i<=page;i++){
                            String pageUrl = l+"/page_"+i+".html";
                            String str2 =  HttpClientHelper.sendHttpGet(pageUrl);
                            // 解析网页,得到文档对象
                            Document doc2 = Jsoup.parse(str2);
                            Elements elements2 = doc2.select("div.lft_art.lf div.mb10.tw3_01_2 span.tw3_01_2_t h4 a");
                            for(Element el2:elements2){
                                String articleUrl = el2.attr("href");
                                if(!bloomFilter.contains(articleUrl)) {
                                    listArticle.add(articleUrl);
                                    bloomFilter.addValue(articleUrl);
                                }
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
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return listArticle;
    }


    public static List<String> getFirstHtmlOne(){
        BloomFilter bloomFilter = new BloomFilter();
        ExecutorService executor = Executors.newCachedThreadPool();
        String str =  HttpClientHelper.sendHttpGet("http://www.chinadaily.com.cn/");
        // 解析网页,得到文档对象
        Document doc= Jsoup.parse(str);
        // 通过选择器查找所有链接DOM
        Elements linkElements=doc.select("div.topNav ul.dropdown li a");
        List<String> listNav = new ArrayList<String>();

        List<String> listArticle = new ArrayList<String>();

        for(Element l:linkElements){
            String l1 = l.attr("href");
            if(!IsUrl(l1))continue;
            String str1 =  HttpClientHelper.sendHttpGet(l1);
            // 解析网页,得到文档对象
            Document doc1= Jsoup.parse(str1);
            Elements elements = doc1.select(".topNav2_art ul li a");
            if(elements.size()==0||elements==null)continue;
            for(Element e:elements){
                String url = e.attr("href");
                String str2 =  HttpClientHelper.sendHttpGet(url);
                // 解析网页,得到文档对象
                Document doc2 = Jsoup.parse(str2);
                Elements elements2 = doc2.select("div.lft_art.lf");
                if(elements2.size()==0||elements2==null)continue;
                listNav.add(url);
            }
        }

        for(String l:listNav){
            if (!executor.isShutdown()) {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        String str1 =  HttpClientHelper.sendHttpGet(l);
                        // 解析网页,得到文档对象
                        Document doc1 = Jsoup.parse(str1);
                        Elements elements = doc1.select("#div_currpage a");
                        Elements elements1 =  doc1.select(".tw2 a");
                        for (Element e:elements1){
                            String articleUrl = e.attr("href");
                            if(!bloomFilter.contains(articleUrl)) {
                                listArticle.add(articleUrl);
                                bloomFilter.addValue(articleUrl);
                            }
                        }
                        if(elements.size()==0){
                            System.out.println(l);
                            return;
                        }

                        for(int i = 1;i<=1;i++){
                            String pageUrl = l+"/page_"+i+".html";
                            String str2 =  HttpClientHelper.sendHttpGet(pageUrl);
                            // 解析网页,得到文档对象
                            Document doc2 = Jsoup.parse(str2);
                            Elements elements2 = doc2.select("div.lft_art.lf div.mb10.tw3_01_2 span.tw3_01_2_t h4 a");
                            for(Element el2:elements2){
                                String articleUrl = el2.attr("href");
                                if(!bloomFilter.contains(articleUrl)) {
                                    listArticle.add(articleUrl);
                                    bloomFilter.addValue(articleUrl);
                                }
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
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return listArticle;
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
                        String title = docp.select(".lft_art h1").text();
                        if("".equals(title))  title = docp.select(".ce_art h1").text();
                        String content = docp.select("#Content").text();
                        if(content.length()>30000)return;
                        String dateStr = docp.select(".main_art div.info span.info_l").text();
                        if("".equals(dateStr))  dateStr = docp.select(".ce_art h1").text();
                        String string = "[0-9]{4}[-][0-9]{1,2}[-][0-9]{1,2}[ ][0-9]{1,2}[:][0-9]{1,2}";
                        Pattern pattern = Pattern.compile(string);
                        Matcher matcher = pattern.matcher(dateStr);
                        if(matcher.find()){
                            dateStr = matcher.group(0);
                        }
                        String str = dateStr.toString();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        Date date = null;
                        try {
                            if("".equals(dateStr)){
                                System.out.println(sl);
                                return;
                            }
                            date = dateFormat.parse(str);
                        } catch (ParseException e1) {
                            System.out.println(sl);
                            e1.printStackTrace();
                        }
                        article.setTitle(title);
                        article.setCreateTime(date);
                        article.setContent(content);
                        article.setPublishTime(new Date());
                        article.setCrawlingTime(new Date());
                        article.setDeleteFlag((short) 0);
                        article.setCrawlingId((short) 3);
                        article.setSource("China Daily");
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




    public static boolean IsUrl(String str) {
        String regex = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
        return match(regex, str);
    }


    private static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }



}
