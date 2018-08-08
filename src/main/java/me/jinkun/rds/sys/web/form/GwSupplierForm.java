package me.jinkun.rds.sys.web.form;

import me.jinkun.rds.sys.domain.GwSupplier;

import java.util.List;

public class GwSupplierForm {
    private String text;
    private String state;
    private Long id;
    private List<GwSupplier> children;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<GwSupplier> getChildren() {
        return children;
    }

    public void setChildren(List<GwSupplier> children) {
        this.children = children;
    }
}
