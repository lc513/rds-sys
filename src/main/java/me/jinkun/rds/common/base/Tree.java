package me.jinkun.rds.common.base;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Description: HelloWorld！ <br/>
 * Autor: Created by jinkun on 2016/12/31.
 */
public class Tree implements Serializable {
    private Long id;
    private String text;
    private int seq;
    private String state = "open";// open,closed
    private boolean checked = false;
    private List<Tree> children;
    private String iconCls;
    private Long pid;
    private Integer isLeaf;
    private Object attributes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
    }

    public Object getAttributes() {
        return attributes;
    }

    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tree tree = (Tree) o;
        return seq == tree.seq &&
                checked == tree.checked &&
                Objects.equals(id, tree.id) &&
                Objects.equals(text, tree.text) &&
                Objects.equals(state, tree.state) &&
                Objects.equals(children, tree.children) &&
                Objects.equals(iconCls, tree.iconCls) &&
                Objects.equals(pid, tree.pid) &&
                Objects.equals(isLeaf, tree.isLeaf) &&
                Objects.equals(attributes, tree.attributes);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, text, seq, state, checked, children, iconCls, pid, isLeaf, attributes);
    }
}
