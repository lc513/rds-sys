package me.jinkun.rds.sys.dao;

import java.util.List;
import me.jinkun.rds.sys.domain.GwCheckTemp;
import me.jinkun.rds.sys.domain.GwCheckTempExample;
import org.apache.ibatis.annotations.Param;

public interface GwCheckTempMapper {
    long countByExample(GwCheckTempExample example);

    int deleteByExample(GwCheckTempExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwCheckTemp record);

    int insertSelective(GwCheckTemp record);

    List<GwCheckTemp> selectByExample(GwCheckTempExample example);

    GwCheckTemp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GwCheckTemp record, @Param("example") GwCheckTempExample example);

    int updateByExample(@Param("record") GwCheckTemp record, @Param("example") GwCheckTempExample example);

    int updateByPrimaryKeySelective(GwCheckTemp record);

    int updateByPrimaryKey(GwCheckTemp record);
}