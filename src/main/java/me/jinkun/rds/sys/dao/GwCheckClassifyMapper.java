package me.jinkun.rds.sys.dao;

import java.util.List;
import me.jinkun.rds.sys.domain.GwCheckClassify;
import me.jinkun.rds.sys.domain.GwCheckClassifyExample;
import org.apache.ibatis.annotations.Param;

public interface GwCheckClassifyMapper {
    long countByExample(GwCheckClassifyExample example);

    int deleteByExample(GwCheckClassifyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwCheckClassify record);

    int insertSelective(GwCheckClassify record);

    List<GwCheckClassify> selectByExample(GwCheckClassifyExample example);

    GwCheckClassify selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GwCheckClassify record, @Param("example") GwCheckClassifyExample example);

    int updateByExample(@Param("record") GwCheckClassify record, @Param("example") GwCheckClassifyExample example);

    int updateByPrimaryKeySelective(GwCheckClassify record);

    int updateByPrimaryKey(GwCheckClassify record);
}