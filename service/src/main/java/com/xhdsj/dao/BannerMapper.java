package com.xhdsj.dao;

import java.util.List;
import com.xhdsj.model.Banner;
import com.xhdsj.model.BannerExample;
import org.apache.ibatis.annotations.Param;

public interface BannerMapper {
    long countByExample(BannerExample example);

    int deleteByExample(BannerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Banner record);

    int insertSelective(Banner record);

    List<Banner> selectByExample(BannerExample example);

    Banner selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Banner record, @Param("example") BannerExample example);

    int updateByExample(@Param("record") Banner record, @Param("example") BannerExample example);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);
}