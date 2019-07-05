package com.javen.mapping;

import com.javen.model.JapanvideoBaseinfo;
import com.javen.model.JapanvideoBaseinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository("JapanvideoBaseinfoMapper")
public interface JapanvideoBaseinfoMapper {
    int countByExample(JapanvideoBaseinfoExample example);

    int deleteByExample(JapanvideoBaseinfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(JapanvideoBaseinfo record);

    int insertSelective(JapanvideoBaseinfo record);

    List<JapanvideoBaseinfo> selectByExample(JapanvideoBaseinfoExample example);

    JapanvideoBaseinfo selectByPrimaryKey(String id);
    
    List<String> selectdistinctartist(JapanvideoBaseinfoExample example);
    
    int updateByExampleSelective(@Param("record") JapanvideoBaseinfo record, @Param("example") JapanvideoBaseinfoExample example);

    int updateByExample(@Param("record") JapanvideoBaseinfo record, @Param("example") JapanvideoBaseinfoExample example);

    int updateByPrimaryKeySelective(JapanvideoBaseinfo record);

    int updateByPrimaryKey(JapanvideoBaseinfo record);
}