package com.javen.mapping;

import com.javen.model.JapanvideoArtist;
import com.javen.model.JapanvideoArtistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository("JapanvideoArtistMapper")
public interface JapanvideoArtistMapper {
    int countByExample(JapanvideoArtistExample example);

    int deleteByExample(JapanvideoArtistExample example);

    int deleteByPrimaryKey(String id);

    int insert(JapanvideoArtist record);

    int insertSelective(JapanvideoArtist record);

    List<JapanvideoArtist> selectByExample(JapanvideoArtistExample example);

    JapanvideoArtist selectByPrimaryKey(String id);
    List<String> select(String sql);
    int updateByExampleSelective(@Param("record") JapanvideoArtist record, @Param("example") JapanvideoArtistExample example);

    int updateByExample(@Param("record") JapanvideoArtist record, @Param("example") JapanvideoArtistExample example);

    int updateByPrimaryKeySelective(JapanvideoArtist record);

    int updateByPrimaryKey(JapanvideoArtist record);
}