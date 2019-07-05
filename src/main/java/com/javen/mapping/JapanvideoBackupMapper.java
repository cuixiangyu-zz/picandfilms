package com.javen.mapping;

import com.javen.model.JapanvideoBackup;
import com.javen.model.JapanvideoBackupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("JapanvideoBackupMapper")
public interface JapanvideoBackupMapper {
    int countByExample(JapanvideoBackupExample example);

    int deleteByExample(JapanvideoBackupExample example);

    int deleteByPrimaryKey(String id);

    int insert(JapanvideoBackup record);

    int insertSelective(JapanvideoBackup record);

    List<JapanvideoBackup> selectByExample(JapanvideoBackupExample example);

    JapanvideoBackup selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") JapanvideoBackup record, @Param("example") JapanvideoBackupExample example);

    int updateByExample(@Param("record") JapanvideoBackup record, @Param("example") JapanvideoBackupExample example);

    int updateByPrimaryKeySelective(JapanvideoBackup record);

    int updateByPrimaryKey(JapanvideoBackup record);
}