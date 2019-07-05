package com.javen.mapping;

import com.javen.model.JapanvideoCategory;
import com.javen.model.JapanvideoCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository("JapanvideoCategoryMapper")
public interface JapanvideoCategoryMapper {
    int countByExample(JapanvideoCategoryExample example);

    int deleteByExample(JapanvideoCategoryExample example);

    int deleteByPrimaryKey(String id);

    int insert(JapanvideoCategory record);

    int insertSelective(JapanvideoCategory record);

    List<JapanvideoCategory> selectByExample(JapanvideoCategoryExample example);

    JapanvideoCategory selectByPrimaryKey(String id);
    List<String> select(String sql);
    int updateByExampleSelective(@Param("record") JapanvideoCategory record, @Param("example") JapanvideoCategoryExample example);

    int updateByExample(@Param("record") JapanvideoCategory record, @Param("example") JapanvideoCategoryExample example);

    int updateByPrimaryKeySelective(JapanvideoCategory record);

    int updateByPrimaryKey(JapanvideoCategory record);
}