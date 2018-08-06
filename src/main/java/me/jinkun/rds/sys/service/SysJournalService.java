package me.jinkun.rds.sys.service;

import me.jinkun.rds.common.base.BaseResult;
import me.jinkun.rds.sys.domain.SysJournal;
import me.jinkun.rds.sys.web.form.SysJournalForm;

import java.util.List;

public interface SysJournalService {
    BaseResult getJournal(SysJournalForm sysJournal, int offset, int limit);

    BaseResult addJournal(SysJournal sysJournal);

    BaseResult deleteJournal(SysJournal sysJournal);

    BaseResult updateJournal(SysJournal sysJournal);
}
