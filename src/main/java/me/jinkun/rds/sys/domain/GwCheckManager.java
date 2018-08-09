package me.jinkun.rds.sys.domain;

import java.util.Date;

public class GwCheckManager {
    private Long id;

    private Long crId;

    private String name;

    private Boolean check;

    private Integer sort;

    private Integer frequency1;

    private Long frequencyType;

    private Integer frequency2;

    private String remark;

    private Date createTime;

    private String checkProject;
    private String score;//  0/15

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCrId() {
        return crId;
    }

    public void setCrId(Long crId) {
        this.crId = crId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getFrequency1() {
        return frequency1;
    }

    public void setFrequency1(Integer frequency1) {
        this.frequency1 = frequency1;
    }

    public Long getFrequencyType() {
        return frequencyType;
    }

    public void setFrequencyType(Long frequencyType) {
        this.frequencyType = frequencyType;
    }

    public Integer getFrequency2() {
        return frequency2;
    }

    public void setFrequency2(Integer frequency2) {
        this.frequency2 = frequency2;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCheckProject() {
        return checkProject;
    }

    public void setCheckProject(String checkProject) {
        this.checkProject = checkProject;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}