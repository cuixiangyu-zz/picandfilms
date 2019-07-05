package com.javen.mapping;

import com.javen.model.PicArtist;
import com.javen.model.PicArtistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;
@Repository
public interface PicArtistMapper {
    int countByExample(PicArtistExample example);

    int deleteByExample(PicArtistExample example);

    int deleteByPrimaryKey(String id);

    int insert(PicArtist record);

    int insertSelective(PicArtist record);

    List<PicArtist> selectByExample(PicArtistExample example);
    List<String> select(String sql);
    PicArtist selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PicArtist record, @Param("example") PicArtistExample example);

    int updateByExample(@Param("record") PicArtist record, @Param("example") PicArtistExample example);

    int updateByPrimaryKeySelective(PicArtist record);

    int updateByPrimaryKey(PicArtist record);
}