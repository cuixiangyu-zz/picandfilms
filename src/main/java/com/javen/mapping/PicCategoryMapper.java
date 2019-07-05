package com.javen.mapping;

import com.javen.model.PicCategory;
import com.javen.model.PicCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PicCategoryMapper {
    int countByExample(PicCategoryExample example);

    int deleteByExample(PicCategoryExample example);

    int deleteByPrimaryKey(String id);

    int insert(PicCategory record);

    int insertSelective(PicCategory record);

    List<PicCategory> selectByExample(PicCategoryExample example);
    List<String> select(String sql);
    PicCategory selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PicCategory record, @Param("example") PicCategoryExample example);

    int updateByExample(@Param("record") PicCategory record, @Param("example") PicCategoryExample example);

    int updateByPrimaryKeySelective(PicCategory record);

    int updateByPrimaryKey(PicCategory record);
}