package com.xhdsj.service;

import com.xhdsj.model.Article;

import java.util.List;

/**
 * 功能描述: 爬取文章的接口
 *
 * @auther: njw
 * @date: 2018/4/19
 */

public interface ArticleService {


    Article selectByPrimaryKey(Integer id);

    int insertByBatch();

    int insertByBatchXinHua(List<Article> list);

    List<Article> selectArticlePage(String text, int page, int pageSize);

    long selectArticleCount(String text);

    int insertByBatchChina();
}
