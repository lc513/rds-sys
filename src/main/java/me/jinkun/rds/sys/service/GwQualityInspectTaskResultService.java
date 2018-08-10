package me.jinkun.rds.sys.service;

import me.jinkun.rds.sys.domain.GwQualityInspectTaskResult;

import java.util.List;

public interface GwQualityInspectTaskResultService {
    List<GwQualityInspectTaskResult> selectList(long qitdId);
}
