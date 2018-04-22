package com.xhdsj.dao;

import com.xhdsj.model.Article;
import com.xhdsj.model.ArticleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 功能描述: 数据层接口
 *
 * @auther: njw
 * @date: 2018/4/19
 */

public interface ArticleMapper {
    long countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExampleWithBLOBs(ArticleExample example);

    List<Article> selectByExample(ArticleExample example);

    Article selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);

    int insertByBatch(List<Article> attachmentTables);
}