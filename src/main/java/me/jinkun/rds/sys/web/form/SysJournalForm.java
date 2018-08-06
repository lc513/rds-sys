package me.jinkun.rds.sys.web.form;

import me.jinkun.rds.sys.domain.SysJournal;

import java.util.Date;

public class SysJournalForm extends SysJournal {
    Date startTime;
    Date endTime;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
