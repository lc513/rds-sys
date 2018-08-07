package me.jinkun.rds.sys.dao;

import java.util.List;
import me.jinkun.rds.sys.domain.GwCheckContent;
import me.jinkun.rds.sys.domain.GwCheckContentExample;
import org.apache.ibatis.annotations.Param;

public interface GwCheckContentMapper {
    long countByExample(GwCheckContentExample example);

    int deleteByExample(GwCheckContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwCheckContent record);

    int insertSelective(GwCheckContent record);

    List<GwCheckContent> selectByExample(GwCheckContentExample example);

    GwCheckContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GwCheckContent record, @Param("example") GwCheckContentExample example);

    int updateByExample(@Param("record") GwCheckContent record, @Param("example") GwCheckContentExample example);

    int updateByPrimaryKeySelective(GwCheckContent record);

    int updateByPrimaryKey(GwCheckContent record);
}