package me.jinkun.rds.sys.service.impl;

import me.jinkun.rds.sys.dao.GwQualityInspectTaskResultMapper;
import me.jinkun.rds.sys.domain.GwQualityInspectTaskDetail;
import me.jinkun.rds.sys.domain.GwQualityInspectTaskResult;
import me.jinkun.rds.sys.domain.GwQualityInspectTaskResultExample;
import me.jinkun.rds.sys.service.GwQualityInspectTaskResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GwQualityInspectTaskResultServiceImpl implements GwQualityInspectTaskResultService {

    @Autowired
    GwQualityInspectTaskResultMapper mapper;

    @Override
    public List<GwQualityInspectTaskResult> selectList(long qitdId) {
        GwQualityInspectTaskResultExample gwQualityInspectTaskResultExample = new GwQualityInspectTaskResultExample();
        GwQualityInspectTaskResultExample.Criteria criteria = gwQualityInspectTaskResultExample.createCriteria();
        criteria.andQitdIdEqualTo(qitdId);
        List<GwQualityInspectTaskResult> gwQualityInspectTaskResults = mapper.selectByExample(gwQualityInspectTaskResultExample);
        return gwQualityInspectTaskResults;
    }
}
