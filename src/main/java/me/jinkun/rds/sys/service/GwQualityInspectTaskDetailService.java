package me.jinkun.rds.sys.service;

import me.jinkun.rds.common.base.BaseResult;

public interface GwQualityInspectTaskDetailService {
    BaseResult list(Long taskId, int offset, int limit);

    BaseResult generate(Long taskId);
}
