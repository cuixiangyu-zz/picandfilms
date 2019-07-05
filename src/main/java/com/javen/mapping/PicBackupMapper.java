package com.javen.mapping;

import com.javen.model.PicBackup;
import com.javen.model.PicBackupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("PicBackupMapper")
public interface PicBackupMapper {
    int countByExample(PicBackupExample example);

    int deleteByExample(PicBackupExample example);

    int deleteByPrimaryKey(String id);

    int insert(PicBackup record);

    int insertSelective(PicBackup record);

    List<PicBackup> selectByExample(PicBackupExample example);

    PicBackup selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PicBackup record, @Param("example") PicBackupExample example);

    int updateByExample(@Param("record") PicBackup record, @Param("example") PicBackupExample example);

    int updateByPrimaryKeySelective(PicBackup record);

    int updateByPrimaryKey(PicBackup record);
}