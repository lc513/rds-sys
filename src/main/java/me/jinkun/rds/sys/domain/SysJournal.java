package me.jinkun.rds.sys.domain;

import me.jinkun.rds.common.base.BaseForm;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SysJournal extends BaseForm {
    private Long id;

    private Long pId;

    private Long uId;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date jDate;

    private Integer workDuration;

    private String workDesc;

    private Integer overTime;

    private String overDesc;

    private Integer examine;
    private SysProject sysProject;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Date getjDate() {
        return jDate;
    }

    public void setjDate(Date jDate) {
        this.jDate = jDate;
    }

    public Integer getWorkDuration() {
        return workDuration;
    }

    public void setWorkDuration(Integer workDuration) {
        this.workDuration = workDuration;
    }

    public String getWorkDesc() {
        return workDesc;
    }

    public void setWorkDesc(String workDesc) {
        this.workDesc = workDesc == null ? null : workDesc.trim();
    }

    public Integer getOverTime() {
        return overTime;
    }

    public void setOverTime(Integer overTime) {
        this.overTime = overTime;
    }

    public String getOverDesc() {
        return overDesc;
    }

    public void setOverDesc(String overDesc) {
        this.overDesc = overDesc == null ? null : overDesc.trim();
    }

    public Integer getExamine() {
        return examine;
    }

    public void setExamine(Integer examine) {
        this.examine = examine;
    }

    public SysProject getSysProject() {
        return sysProject;
    }

    public void setSysProject(SysProject sysProject) {
        this.sysProject = sysProject;
    }
}