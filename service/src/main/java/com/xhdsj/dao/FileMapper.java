package com.xhdsj.dao;

import java.util.List;
import com.xhdsj.model.File;
import com.xhdsj.model.FileExample;
import org.apache.ibatis.annotations.Param;

public interface FileMapper {
    long countByExample(FileExample example);

    int deleteByExample(FileExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(File record);

    int insertSelective(File record);

    List<File> selectByExample(FileExample example);

    File selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") File record, @Param("example") FileExample example);

    int updateByExample(@Param("record") File record, @Param("example") FileExample example);

    int updateByPrimaryKeySelective(File record);

    int updateByPrimaryKey(File record);
}