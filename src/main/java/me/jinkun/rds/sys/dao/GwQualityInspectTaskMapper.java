package me.jinkun.rds.sys.dao;

import java.util.List;
import me.jinkun.rds.sys.domain.GwQualityInspectTask;
import me.jinkun.rds.sys.domain.GwQualityInspectTaskExample;
import me.jinkun.rds.sys.web.form.GwQualityInspectTaskForm;
import org.apache.ibatis.annotations.Param;

public interface GwQualityInspectTaskMapper {
    long countByExample(GwQualityInspectTaskExample example);

    int deleteByExample(GwQualityInspectTaskExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwQualityInspectTask record);

    int insertSelective(GwQualityInspectTask record);

    List<GwQualityInspectTask> selectByExample(GwQualityInspectTaskExample example);

    GwQualityInspectTask selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GwQualityInspectTask record, @Param("example") GwQualityInspectTaskExample example);

    int updateByExample(@Param("record") GwQualityInspectTask record, @Param("example") GwQualityInspectTaskExample example);

    int updateByPrimaryKeySelective(GwQualityInspectTask record);

    int updateByPrimaryKey(GwQualityInspectTask record);

    List<GwQualityInspectTask> selectCarrySonByExample(GwQualityInspectTaskForm gwQualityInspectTaskForm);
}