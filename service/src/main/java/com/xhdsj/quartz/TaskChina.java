package com.xhdsj.quartz;


import com.xhdsj.crawler.core.ChinaDailyHtml;
import com.xhdsj.dao.ArticleMapper;
import com.xhdsj.dao.CrawlingMapper;
import com.xhdsj.model.Article;
import com.xhdsj.model.Crawling;
import com.xhdsj.service.MyListener;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: 中国日报定时任务基类
 *          每晚会爬取网站的前几页数据
 *
 * @auther: njw
 * @date: 2018/4/17
 */

@Component
public class TaskChina {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private CrawlingMapper crawlingMapper;

    Logger logger = Logger.getLogger(TaskDemo.class);
    @Scheduled(cron = "0 0 21 * * ?") //
    void doSomethingWith(){
        logger.info("定时任务开始......");
        long begin = System.currentTimeMillis();
        Crawling crawling2 = crawlingMapper.selectByPrimaryKey(3);
        if(crawling2.getCrawlingFlag()==1) {
            List<Article> list = ChinaDailyHtml.getArticleListEveryDay();
            List<Article> list1 = new ArrayList<>();

            if (list.isEmpty() || list == null){
                return;
            }

            for(Article l:list){
                boolean b =  MyListener.bloomFilter.contains(l.getCrawlingUrl());
                if(!b){
                    list1.add(l);
                }
            }

            if (list1 == null ||list1.isEmpty()){
                return;
            }
            articleMapper.insertByBatch(list1);
            for(Article l1 : list1) {
                MyListener.bloomFilter.addValue(l1.getCrawlingUrl());
            }
        }
        long end = System.currentTimeMillis();
        logger.info("定时任务结束，共耗时：[" + (end-begin) / 1000 + "]秒");
    }
}