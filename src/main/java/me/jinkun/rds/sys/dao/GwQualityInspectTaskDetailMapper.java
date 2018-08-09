package me.jinkun.rds.sys.dao;

import java.util.List;
import me.jinkun.rds.sys.domain.GwQualityInspectTaskDetail;
import me.jinkun.rds.sys.domain.GwQualityInspectTaskDetailExample;
import org.apache.ibatis.annotations.Param;

public interface GwQualityInspectTaskDetailMapper {
    long countByExample(GwQualityInspectTaskDetailExample example);

    int deleteByExample(GwQualityInspectTaskDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwQualityInspectTaskDetail record);

    long insertSelective(GwQualityInspectTaskDetail record);

    List<GwQualityInspectTaskDetail> selectByExample(GwQualityInspectTaskDetailExample example);

    GwQualityInspectTaskDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GwQualityInspectTaskDetail record, @Param("example") GwQualityInspectTaskDetailExample example);

    int updateByExample(@Param("record") GwQualityInspectTaskDetail record, @Param("example") GwQualityInspectTaskDetailExample example);

    int updateByPrimaryKeySelective(GwQualityInspectTaskDetail record);

    int updateByPrimaryKey(GwQualityInspectTaskDetail record);
}