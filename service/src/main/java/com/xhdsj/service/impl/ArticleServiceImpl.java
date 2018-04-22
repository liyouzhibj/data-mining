
package com.xhdsj.service.impl;

import com.xhdsj.crawler.core.ChinaDailyHtml;
import com.xhdsj.crawler.core.EnPeopleHtml;
import com.xhdsj.dao.ArticleMapper;
import com.xhdsj.dao.CrawlingMapper;
import com.xhdsj.model.Article;
import com.xhdsj.model.ArticleExample;
import com.xhdsj.model.Crawling;
import com.xhdsj.model.sup.Code;
import com.xhdsj.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 功能描述: 爬取文章实现类
 *
 * @auther: njw
 * @date: 2018/4/19
 */

@Service
public class ArticleServiceImpl implements ArticleService {


    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private CrawlingMapper crawlingMapper;


    /**
     * 功能描述: 添加人名网的业务层
     *
     * @auther: njw
     * @date: 2018/4/18
     */

    @Override
    @Transactional
    public int insertByBatch() {
        List<Article> list = EnPeopleHtml.getArticleList();
        if(list.isEmpty() || list==null)return 0;
        int count = articleMapper.insertByBatch(list);
        Crawling crawling = crawlingMapper.selectByPrimaryKey(1);
        crawling.setCrawlingFlag((short)1);
        crawlingMapper.updateByPrimaryKey(crawling);
        return count;
    }

    /**
     * 功能描述: 添加新华网的业务层
     *
     * @auther: njw
     * @date: 2018/4/18
     */

    @Override
    @Transactional
    public int insertByBatchXinHua(List<Article> list) {

        if(list.isEmpty() || list==null) return 0;
        int count =articleMapper.insertByBatch(list);
        Crawling crawling = crawlingMapper.selectByPrimaryKey(2);
        crawling.setCrawlingFlag((short)1);
        crawlingMapper.updateByPrimaryKey(crawling);
        return count;
    }


     /**
      * 功能描述: 添加中国日报的业务层
      *
      * @auther: njw
      * @date: 2018/4/18
      */
     @Override
     public int insertByBatchChina() {
         List<Article> list = ChinaDailyHtml.getArticleList();
         if(list.isEmpty() || list==null) return 0;
         int count = articleMapper.insertByBatch(list);
         Crawling crawling = crawlingMapper.selectByPrimaryKey(3);
         crawling.setCrawlingFlag((short)1);
         crawlingMapper.updateByPrimaryKey(crawling);
         return count;
     }


    /**
     * 功能描述: 分页显示文章的业务层
     *
     * @auther: njw
     * @date: 2018/4/18
     */

    @Override
    public List<Article> selectArticlePage(String text, int page, int pageSize) {
        ArticleExample articleExample = new ArticleExample();
        articleExample.setStartRow((page-1)*pageSize);
        articleExample.setPageSize(pageSize);
        articleExample.setMytext(text);
        articleExample.setDistinct(true);
        List<Article> list = articleMapper.selectByExample(articleExample);
        return list;

    }

    /**
     * 功能描述: 根据内容查询文章的业务层
     *
     * @auther: njw
     * @date: 2018/4/18
     */

    @Override
    public long selectArticleCount(String text) {
        ArticleExample articleExample = new ArticleExample();
        articleExample.setMytext(text);
        long l = articleMapper.countByExample(articleExample);
        return l;
    }

    /**
     * 功能描述: 根据id查询文章的业务层
     *
     * @auther: njw
     * @date: 2018/4/18
     */

    @Override
    public Article selectByPrimaryKey(Integer id) {
        Article article = new Article();
        if(id==null || id<0){
            article.setCode(Code.fail("id不正确"));
            return article;
        }
        return articleMapper.selectByPrimaryKey(id);
    }


}

