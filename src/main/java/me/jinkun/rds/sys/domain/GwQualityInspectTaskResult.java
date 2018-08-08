package me.jinkun.rds.sys.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class GwQualityInspectTaskResult {
    private Long id;

    private Long qitdId;

    private String checkContent;

    private Boolean isQualified;

    private Integer score;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date checkTime;

    private String checkSituation;

    private String enclosure;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQitdId() {
        return qitdId;
    }

    public void setQitdId(Long qitdId) {
        this.qitdId = qitdId;
    }

    public String getCheckContent() {
        return checkContent;
    }

    public void setCheckContent(String checkContent) {
        this.checkContent = checkContent == null ? null : checkContent.trim();
    }

    public Boolean getIsQualified() {
        return isQualified;
    }

    public void setIsQualified(Boolean isQualified) {
        this.isQualified = isQualified;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getCheckSituation() {
        return checkSituation;
    }

    public void setCheckSituation(String checkSituation) {
        this.checkSituation = checkSituation == null ? null : checkSituation.trim();
    }

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure == null ? null : enclosure.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}