package com.xhdsj.dao;

import java.util.List;
import com.xhdsj.model.Crawling;
import com.xhdsj.model.CrawlingExample;
import org.apache.ibatis.annotations.Param;

public interface CrawlingMapper {
    long countByExample(CrawlingExample example);

    int deleteByExample(CrawlingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Crawling record);

    int insertSelective(Crawling record);

    List<Crawling> selectByExample(CrawlingExample example);

    Crawling selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Crawling record, @Param("example") CrawlingExample example);

    int updateByExample(@Param("record") Crawling record, @Param("example") CrawlingExample example);

    int updateByPrimaryKeySelective(Crawling record);

    int updateByPrimaryKey(Crawling record);
}