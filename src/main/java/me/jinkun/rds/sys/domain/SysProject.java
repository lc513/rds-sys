package me.jinkun.rds.sys.domain;

import me.jinkun.rds.common.base.BaseForm;

public class SysProject extends BaseForm {
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }


}