package me.jinkun.rds.sys.service;

import me.jinkun.rds.common.base.BaseResult;
import me.jinkun.rds.common.base.EUDataGridResult;
import me.jinkun.rds.sys.web.form.GwQualityInspectTaskForm;

public interface GwQualityInspectTaskService {
    EUDataGridResult getGwQualityInspectTaskList(GwQualityInspectTaskForm gwQualityInspectTaskForm, int offset, int limit);

    BaseResult addTask(GwQualityInspectTaskForm gwQualityInspectTaskForm);

    BaseResult selectQualityInspectTaskDownLoad(String authorization);
}
