package me.jinkun.rds.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.jinkun.rds.common.base.BaseResult;
import me.jinkun.rds.common.base.EUDataGridResult;
import me.jinkun.rds.sys.dao.GwQualityInspectTaskDetailMapper;
import me.jinkun.rds.sys.dao.GwQualityInspectTaskMapper;
import me.jinkun.rds.sys.domain.GwQualityInspectTask;
import me.jinkun.rds.sys.domain.GwQualityInspectTaskDetail;
import me.jinkun.rds.sys.domain.GwQualityInspectTaskDetailExample;
import me.jinkun.rds.sys.service.GwQualityInspectTaskDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class GwQualityInspectTaskDetailServiceImpl implements GwQualityInspectTaskDetailService {

    @Autowired
    GwQualityInspectTaskDetailMapper gwQualityInspectTaskDetailMapper;

    @Autowired
    GwQualityInspectTaskMapper gwQualityInspectTaskMapper;
    @Override
    public BaseResult list(Long taskId, int offset, int limit) {
        long count = 0;EUDataGridResult euDataGridResult =new EUDataGridResult(0,new ArrayList<GwQualityInspectTaskDetail>());
        try{
            if (taskId==null||taskId==0){
                return euDataGridResult;
            }
            GwQualityInspectTaskDetailExample gwQualityInspectTaskDetailExample = new GwQualityInspectTaskDetailExample();
            GwQualityInspectTaskDetailExample.Criteria criteria = gwQualityInspectTaskDetailExample.createCriteria();
            criteria.andQitIdEqualTo(taskId);
            count = gwQualityInspectTaskDetailMapper.countByExample(gwQualityInspectTaskDetailExample);
            PageHelper.offsetPage(offset,limit,"taskStime");
            PageInfo<GwQualityInspectTaskDetail> info = new PageInfo<GwQualityInspectTaskDetail>(gwQualityInspectTaskDetailMapper.selectByExample(gwQualityInspectTaskDetailExample));
            euDataGridResult = new EUDataGridResult(count,info.getList());
        }catch (Exception e){

        }
        return euDataGridResult;
    }

    @Override
    public BaseResult generate(Long taskId) {
        try{
            if (taskId==null||taskId==0l){
                return BaseResult.fail("任务id没有传值");
            }
            GwQualityInspectTask gwQualityInspectTask = gwQualityInspectTaskMapper.selectByPrimaryKey(taskId);
            boolean generate = gwQualityInspectTask.isGenerate();
            if (generate){
                return BaseResult.fail("失败，原因：已经按批次生成过了");
            }
            //按批次生成

        }catch (Exception e){
            return BaseResult.fail("失败",e);
        }
        return BaseResult.fail("失败");
    }
}
