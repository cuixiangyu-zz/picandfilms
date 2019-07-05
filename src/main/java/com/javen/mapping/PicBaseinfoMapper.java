package com.javen.mapping;

import com.javen.model.PicBaseinfo;
import com.javen.model.PicBaseinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Repository("PicBaseinfoMapper")
public interface PicBaseinfoMapper {
    int countByExample(PicBaseinfoExample example);

    int deleteByExample(PicBaseinfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(PicBaseinfo record);

    int insertSelective(PicBaseinfo record);

    List<PicBaseinfo> selectByExample(PicBaseinfoExample example);

    List<String> select(String sql);

    PicBaseinfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PicBaseinfo record, @Param("example") PicBaseinfoExample example);

    int updateByExample(@Param("record") PicBaseinfo record, @Param("example") PicBaseinfoExample example);

    int updateByPrimaryKeySelective(PicBaseinfo record);

    int updateByPrimaryKey(PicBaseinfo record);
}