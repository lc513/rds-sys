package me.jinkun.rds.sys.web.form;

import me.jinkun.rds.sys.domain.GwQualityInspectTaskDetail;
import me.jinkun.rds.sys.domain.GwQualityInspectTaskResult;

import java.util.List;

public class GwQualityInspectTaskDetailForm extends GwQualityInspectTaskDetail {

    private List<GwQualityInspectTaskResultForm> gwQualityInspectTaskResultForms;

    public List<GwQualityInspectTaskResultForm> getGwQualityInspectTaskResultForms() {
        return gwQualityInspectTaskResultForms;
    }

    public void setGwQualityInspectTaskResultForms(List<GwQualityInspectTaskResultForm> gwQualityInspectTaskResultForms) {
        this.gwQualityInspectTaskResultForms = gwQualityInspectTaskResultForms;
    }
}
