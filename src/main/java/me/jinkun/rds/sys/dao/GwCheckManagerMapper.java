package me.jinkun.rds.sys.dao;

import java.util.List;
import me.jinkun.rds.sys.domain.GwCheckManager;
import me.jinkun.rds.sys.domain.GwCheckManagerExample;
import org.apache.ibatis.annotations.Param;

public interface GwCheckManagerMapper {
    long countByExample(GwCheckManagerExample example);

    int deleteByExample(GwCheckManagerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwCheckManager record);

    int insertSelective(GwCheckManager record);

    List<GwCheckManager> selectByExample(GwCheckManagerExample example);

    GwCheckManager selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GwCheckManager record, @Param("example") GwCheckManagerExample example);

    int updateByExample(@Param("record") GwCheckManager record, @Param("example") GwCheckManagerExample example);

    int updateByPrimaryKeySelective(GwCheckManager record);

    int updateByPrimaryKey(GwCheckManager record);
}