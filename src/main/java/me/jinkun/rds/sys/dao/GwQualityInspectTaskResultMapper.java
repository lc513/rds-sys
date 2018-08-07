package me.jinkun.rds.sys.dao;

import java.util.List;
import me.jinkun.rds.sys.domain.GwQualityInspectTaskResult;
import me.jinkun.rds.sys.domain.GwQualityInspectTaskResultExample;
import org.apache.ibatis.annotations.Param;

public interface GwQualityInspectTaskResultMapper {
    long countByExample(GwQualityInspectTaskResultExample example);

    int deleteByExample(GwQualityInspectTaskResultExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwQualityInspectTaskResult record);

    int insertSelective(GwQualityInspectTaskResult record);

    List<GwQualityInspectTaskResult> selectByExample(GwQualityInspectTaskResultExample example);

    GwQualityInspectTaskResult selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GwQualityInspectTaskResult record, @Param("example") GwQualityInspectTaskResultExample example);

    int updateByExample(@Param("record") GwQualityInspectTaskResult record, @Param("example") GwQualityInspectTaskResultExample example);

    int updateByPrimaryKeySelective(GwQualityInspectTaskResult record);

    int updateByPrimaryKey(GwQualityInspectTaskResult record);
}