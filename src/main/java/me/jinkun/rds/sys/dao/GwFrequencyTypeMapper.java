package me.jinkun.rds.sys.dao;

import java.util.List;
import me.jinkun.rds.sys.domain.GwFrequencyType;
import me.jinkun.rds.sys.domain.GwFrequencyTypeExample;
import org.apache.ibatis.annotations.Param;

public interface GwFrequencyTypeMapper {
    long countByExample(GwFrequencyTypeExample example);

    int deleteByExample(GwFrequencyTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwFrequencyType record);

    int insertSelective(GwFrequencyType record);

    List<GwFrequencyType> selectByExample(GwFrequencyTypeExample example);

    GwFrequencyType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GwFrequencyType record, @Param("example") GwFrequencyTypeExample example);

    int updateByExample(@Param("record") GwFrequencyType record, @Param("example") GwFrequencyTypeExample example);

    int updateByPrimaryKeySelective(GwFrequencyType record);

    int updateByPrimaryKey(GwFrequencyType record);
}