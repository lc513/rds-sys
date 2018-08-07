package me.jinkun.rds.sys.dao;

import java.util.List;
import me.jinkun.rds.sys.domain.GwCompany;
import me.jinkun.rds.sys.domain.GwCompanyExample;
import org.apache.ibatis.annotations.Param;

public interface GwCompanyMapper {
    long countByExample(GwCompanyExample example);

    int deleteByExample(GwCompanyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwCompany record);

    int insertSelective(GwCompany record);

    List<GwCompany> selectByExample(GwCompanyExample example);

    GwCompany selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GwCompany record, @Param("example") GwCompanyExample example);

    int updateByExample(@Param("record") GwCompany record, @Param("example") GwCompanyExample example);

    int updateByPrimaryKeySelective(GwCompany record);

    int updateByPrimaryKey(GwCompany record);
}