package com.xhdsj.service;

import com.xhdsj.crawler.core.XinHuaNetHtml;
import com.xhdsj.dao.ArticleMapper;
import com.xhdsj.dao.CrawlingMapper;
import com.xhdsj.model.Article;
import com.xhdsj.model.ArticleExample;
import com.xhdsj.model.Crawling;
import com.xhdsj.service.util.BloomFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述: 初始化监听类基类
 *          1、初始化先去监听爬过这个网站没，有则调过；
 *          2、没有则爬取；
 *
 * @auther: njw
 * @date: 2018/4/17 
 */

@Service
public class MyListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private CrawlingMapper crawlingMapper;

    public static BloomFilter bloomFilter = new BloomFilter();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if(contextRefreshedEvent.getApplicationContext().getParent() == null){
            Crawling crawling = crawlingMapper.selectByPrimaryKey(1);
            Crawling crawling2 = crawlingMapper.selectByPrimaryKey(2);
            Crawling crawling3 = crawlingMapper.selectByPrimaryKey(3);
            if(crawling.getCrawlingFlag()==0) {
                articleService.insertByBatch();
            }
            if(crawling2.getCrawlingFlag()==0) {
                List<Article> list = XinHuaNetHtml.getArticleList();
                articleService.insertByBatchXinHua(list);
            }
            if(crawling3.getCrawlingFlag()==0) {
                articleService.insertByBatchChina();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ArticleExample articleExample = new ArticleExample();
            List<Article> list = articleMapper.selectByExample(articleExample);
            for(Article l : list){
                bloomFilter.addValue(l.getCrawlingUrl());
            }
        }
    }
}