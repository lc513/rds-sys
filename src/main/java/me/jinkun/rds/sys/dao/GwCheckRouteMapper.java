package me.jinkun.rds.sys.dao;

import java.util.List;
import me.jinkun.rds.sys.domain.GwCheckRoute;
import me.jinkun.rds.sys.domain.GwCheckRouteExample;
import org.apache.ibatis.annotations.Param;

public interface GwCheckRouteMapper {
    long countByExample(GwCheckRouteExample example);

    int deleteByExample(GwCheckRouteExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwCheckRoute record);

    int insertSelective(GwCheckRoute record);

    List<GwCheckRoute> selectByExample(GwCheckRouteExample example);

    GwCheckRoute selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GwCheckRoute record, @Param("example") GwCheckRouteExample example);

    int updateByExample(@Param("record") GwCheckRoute record, @Param("example") GwCheckRouteExample example);

    int updateByPrimaryKeySelective(GwCheckRoute record);

    int updateByPrimaryKey(GwCheckRoute record);
}