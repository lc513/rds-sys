package me.jinkun.rds.sys.dao;

import java.util.List;
import me.jinkun.rds.sys.domain.SysJournal;
import me.jinkun.rds.sys.domain.SysJournalExample;
import org.apache.ibatis.annotations.Param;

public interface SysJournalMapper {
    long countByExample(SysJournalExample example);

    int deleteByExample(SysJournalExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysJournal record);

    int insertSelective(SysJournal record);

    List<SysJournal> selectByExample(SysJournalExample example);

    List<SysJournal> selectJournalAndProjectByExample(SysJournalExample example);

    SysJournal selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysJournal record, @Param("example") SysJournalExample example);

    int updateByExample(@Param("record") SysJournal record, @Param("example") SysJournalExample example);

    int updateByPrimaryKeySelective(SysJournal record);

    int updateByPrimaryKey(SysJournal record);
}