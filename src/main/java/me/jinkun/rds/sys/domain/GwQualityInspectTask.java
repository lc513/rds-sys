package me.jinkun.rds.sys.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class GwQualityInspectTask {
    private Long id;

//    `s_id` BIGINT(19) DEFAULT NULL COMMENT '所属项目id',
//    `ct_id` BIGINT(19) DEFAULT NULL COMMENT '外键模板id',
//    `c_id` BIGINT(19) DEFAULT NULL COMMENT '所属部门id',
//    `u_id` BIGINT(19) DEFAULT NULL COMMENT '编制人id',
//    `inspector_id` BIGINT(19) DEFAULT NULL COMMENT '检查人id',
    private Long sId;

    private Long ctId;

    private Long cId;

    private Long uId;

    private boolean isGenerate;

    private Long inspectorId;

    private String name;

    private Long year;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    private Integer sort;

    private String remark;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;
    private GwSupplier gwSupplier;
    private GwCheckTemp gwCheckTemp;
    private GwCompany gwCompany;
    private SysUser compileUser;
    private SysUser inspectorUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }

    public Long getCtId() {
        return ctId;
    }

    public void setCtId(Long ctId) {
        this.ctId = ctId;
    }

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Long getInspectorId() {
        return inspectorId;
    }

    public void setInspectorId(Long inspectorId) {
        this.inspectorId = inspectorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

    public GwSupplier getGwSupplier() {
        return gwSupplier;
    }

    public void setGwSupplier(GwSupplier gwSupplier) {
        this.gwSupplier = gwSupplier;
    }

    public GwCheckTemp getGwCheckTemp() {
        return gwCheckTemp;
    }

    public void setGwCheckTemp(GwCheckTemp gwCheckTemp) {
        this.gwCheckTemp = gwCheckTemp;
    }

    public GwCompany getGwCompany() {
        return gwCompany;
    }

    public void setGwCompany(GwCompany gwCompany) {
        this.gwCompany = gwCompany;
    }

    public SysUser getCompileUser() {
        return compileUser;
    }

    public void setCompileUser(SysUser compileUser) {
        this.compileUser = compileUser;
    }

    public SysUser getInspectorUser() {
        return inspectorUser;
    }

    public void setInspectorUser(SysUser inspectorUser) {
        this.inspectorUser = inspectorUser;
    }

    public boolean isGenerate() {
        return isGenerate;
    }

    public void setGenerate(boolean generate) {
        isGenerate = generate;
    }
}