package me.jinkun.rds.sys.web.form;

import me.jinkun.rds.sys.domain.GwQualityInspectTask;
import me.jinkun.rds.sys.domain.GwQualityInspectTaskDetail;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class GwQualityInspectTaskForm extends GwQualityInspectTask {

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date nowTime;

    public Date getNowTime() {
        return nowTime;
    }

    public void setNowTime(Date nowTime) {
        this.nowTime = nowTime;
    }

    private List<GwQualityInspectTaskDetailForm> gwQualityInspectTaskDetailForms;

    public List<GwQualityInspectTaskDetailForm> getGwQualityInspectTaskDetailForms() {
        return gwQualityInspectTaskDetailForms;
    }

    public void setGwQualityInspectTaskDetailForms(List<GwQualityInspectTaskDetailForm> gwQualityInspectTaskDetailForms) {
        this.gwQualityInspectTaskDetailForms = gwQualityInspectTaskDetailForms;
    }
}
