package com.xhdsj.controller;

import com.xhdsj.model.Article;
import com.xhdsj.model.sup.Code;
import com.xhdsj.model.sup.ModelView;
import com.xhdsj.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 功能描述: 文章的Controller
 *
 * @auther: njw
 * @date: 2018/4/17
 */

@Controller
@RequestMapping("/Article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 功能描述: 分页显示文章信息
     *
     * @auther: njw
     * @date: 2018/4/18
     */

    @RequestMapping("/selectArticlePage")
    @ResponseBody
    public ModelView selectArticlePage(String text,int page,int pageSize){
        ModelView modelView = new ModelView();
        if(page<=0){
            modelView.setCode(Code.fail("页数不存在"));
            return modelView;
        }
        if(pageSize<=0){
            modelView.setCode(Code.fail("每页数量不正确"));
            return modelView;
        }
        List<Article> articleList = articleService.selectArticlePage(text,page,pageSize);
        modelView.setCode(Code.success());
        modelView.setList(articleList);
        return modelView;
    }

    /**
     * 功能描述: 根据内容查询文章
     *
     * @auther: njw
     * @date: 2018/4/18
     */

    @RequestMapping("/selectArticleCount")
    @ResponseBody
    public ModelView selectArticleCount(String text){
        ModelView modelView = new ModelView();
        long  l = articleService.selectArticleCount(text);
        modelView.setCode(Code.success());
        modelView.setNum(l);
        return modelView;
    }

    /**
     * 功能描述: 根据id查询文章
     *
     * @auther: njw
     * @date: 2018/4/18
     */

    @RequestMapping("/selectArticleById")
    @ResponseBody
    public Article selectArticleById(Integer id){
        Article article = new Article();
        if(id ==null || id<=0){
            article.setCode(Code.fail());
        }else{
            article.setCode(Code.success());
        }
       article = articleService.selectByPrimaryKey(id);

        return article;
    }




}
