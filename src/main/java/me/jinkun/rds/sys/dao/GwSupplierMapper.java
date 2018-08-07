package me.jinkun.rds.sys.dao;

import java.util.List;
import me.jinkun.rds.sys.domain.GwSupplier;
import me.jinkun.rds.sys.domain.GwSupplierExample;
import org.apache.ibatis.annotations.Param;

public interface GwSupplierMapper {
    long countByExample(GwSupplierExample example);

    int deleteByExample(GwSupplierExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwSupplier record);

    int insertSelective(GwSupplier record);

    List<GwSupplier> selectByExample(GwSupplierExample example);

    GwSupplier selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GwSupplier record, @Param("example") GwSupplierExample example);

    int updateByExample(@Param("record") GwSupplier record, @Param("example") GwSupplierExample example);

    int updateByPrimaryKeySelective(GwSupplier record);

    int updateByPrimaryKey(GwSupplier record);
}