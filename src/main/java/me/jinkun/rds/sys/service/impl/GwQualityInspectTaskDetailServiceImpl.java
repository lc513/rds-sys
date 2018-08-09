package me.jinkun.rds.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.jinkun.rds.common.base.BaseResult;
import me.jinkun.rds.common.base.EUDataGridResult;
import me.jinkun.rds.common.utils.DateUtil;
import me.jinkun.rds.common.utils.UtilDate;
import me.jinkun.rds.sys.dao.*;
import me.jinkun.rds.sys.domain.*;
import me.jinkun.rds.sys.service.GwQualityInspectTaskDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class GwQualityInspectTaskDetailServiceImpl implements GwQualityInspectTaskDetailService {
    //计划
    @Autowired
    GwQualityInspectTaskMapper gwQualityInspectTaskMapper;
    //1.模板
    @Autowired
    GwCheckTempMapper gwCheckTempMapper;
    //2.线路
    @Autowired
    GwCheckRouteMapper gwCheckRouteMapper;
    //3.管理
    @Autowired
    GwCheckManagerMapper gwCheckManagerMapper;
    //4.内容
    @Autowired
    GwCheckContentMapper gwCheckContentMapper;
    //频次类型
    @Autowired
    GwFrequencyTypeMapper gwFrequencyTypeMapper;
    //岗位自检 计划详情
    @Autowired
    GwQualityInspectTaskDetailMapper gwQualityInspectTaskDetailMapper;
    //岗位自检 检查内容及反馈
    @Autowired
    GwQualityInspectTaskResultMapper gwQualityInspectTaskResultMapper;
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
//            PageHelper.offsetPage(offset,limit);
            PageHelper.startPage(offset, limit);
            PageInfo<GwQualityInspectTaskDetail> info = new PageInfo<GwQualityInspectTaskDetail>(gwQualityInspectTaskDetailMapper.selectByExample(gwQualityInspectTaskDetailExample));
            euDataGridResult = new EUDataGridResult(count,info.getList());
        }catch (Exception e){

        }
        return euDataGridResult;
    }

    @Override
    public BaseResult insertGenerate(Long taskId) {
        try{
            if (taskId==null||taskId==0l){
                return BaseResult.fail("任务id没有传值");
            }
            GwQualityInspectTask gwQualityInspectTask = gwQualityInspectTaskMapper.selectByPrimaryKey(taskId);
            boolean generate = gwQualityInspectTask.isGenerate();
            if (generate){
                return BaseResult.fail("失败，原因：已经按批次生成过了");
            }
            ArrayList<HashMap<String, Object>> allTasks = new ArrayList();
            //按批次生成
            Date startTime = gwQualityInspectTask.getStartTime();
            Date endTime = gwQualityInspectTask.getEndTime();
            Long ctId = gwQualityInspectTask.getCtId();
            GwCheckTemp checkTemp = gwCheckTempMapper.selectByPrimaryKey(taskId);
            String ctName = checkTemp.getName();
            GwCheckRouteExample gwCheckRouteExample = new GwCheckRouteExample();
            GwCheckRouteExample.Criteria criteria = gwCheckRouteExample.createCriteria();
            criteria.andCtIdEqualTo(ctId);
            List<GwCheckRoute> gwCheckRoutes = gwCheckRouteMapper.selectByExample(gwCheckRouteExample);
            for (int i = 0; i < gwCheckRoutes.size(); i++){
                GwCheckRoute gwCheckRoute = gwCheckRoutes.get(i);
                Long crId = gwCheckRoute.getId();
                String crName = gwCheckRoute.getName();
                GwCheckManagerExample gwCheckManagerExample = new GwCheckManagerExample();
                GwCheckManagerExample.Criteria cmCriteria = gwCheckManagerExample.createCriteria();
                cmCriteria.andCrIdEqualTo(crId);
                ArrayList<GwCheckManager> gwCheckManagers = (ArrayList<GwCheckManager>) gwCheckManagerMapper.selectByExample(gwCheckManagerExample);
                for (int j =0;j<gwCheckManagers.size();j++){
                    GwCheckManager gwCheckManager = gwCheckManagers.get(j);
                    Long cmId = gwCheckManager.getId();
                    String cmName = gwCheckManager.getName();
                    gwCheckManager.setCheckProject(ctName+"->"+crName+"->"+cmName);
                    GwCheckContentExample gwCheckContentExample = new GwCheckContentExample();
                    GwCheckContentExample.Criteria ccCriteria = gwCheckContentExample.createCriteria();
                    ccCriteria.andCmIdEqualTo(cmId);
                    List<GwCheckContent> gwCheckContents = gwCheckContentMapper.selectByExample(gwCheckContentExample);
                    int allScore=0;
                    for(int z = 0; z<gwCheckContents.size();z++){
                        int score = gwCheckContents.get(z).getScore();
                        allScore = allScore +score;
                    }
                    gwCheckManager.setScore("0/"+allScore);
                    HashMap<String,Object> task = new HashMap();
                    task.put("gwCheckManager",gwCheckManager);
                    task.put("gwCheckContents",gwCheckContents);
                    allTasks.add(task);
                }
            }
            List<GwFrequencyType> gwFrequencyTypes = gwFrequencyTypeMapper.selectByExample(null);
            HashMap<Long, String> frequencyTypes = new HashMap<Long, String>();
            for(int i = 0 ; i<gwFrequencyTypes.size();i++){
                frequencyTypes.put(gwFrequencyTypes.get(i).getId(),gwFrequencyTypes.get(i).getName());
            }
            for (int i = 0; i < allTasks.size(); i++){
                Date startDate = startTime;
                Date endDate = endTime;
                HashMap<String, Object> task = allTasks.get(i);
                GwCheckManager gwCheckManager  = (GwCheckManager) task.get("gwCheckManager");
                ArrayList<GwCheckContent> gwCheckContents = (ArrayList<GwCheckContent>) task.get("gwCheckContents");
                GwQualityInspectTaskDetail gwQualityInspectTaskDetail = new GwQualityInspectTaskDetail();
//               gwQualityInspectTaskDetail.setId();
                gwQualityInspectTaskDetail.setQitId(taskId);
                gwQualityInspectTaskDetail.setCheckProject(gwCheckManager.getCheckProject());
                gwQualityInspectTaskDetail.setCheckPoint(gwCheckManager.getName());
                //               gwQualityInspectTaskDetail.setQualified();//是否合格
                gwQualityInspectTaskDetail.setScore(gwCheckManager.getScore());
               gwQualityInspectTaskDetail.setCheckTime(new Date());
//               gwQualityInspectTaskDetail.setCheckUser();
//               gwQualityInspectTaskDetail.setIsChecked();
//               gwQualityInspectTaskDetail.setSort();
//               gwQualityInspectTaskDetail.setEnclosure();//附件个数
//               gwQualityInspectTaskDetail.setRemark();
                /**
                 * 根据频次和总的开始结束时间来生成详情。
                 */
                long frequencyType = gwCheckManager.getFrequencyType();
                Integer frequency1 = gwCheckManager.getFrequency1();
                Integer frequency2 = gwCheckManager.getFrequency2();
                gwQualityInspectTaskDetail.setFrequency(frequency1+frequencyTypes.get(frequencyType)+frequency2+"次");
                int differentDays = DateUtil.differentDays(startDate, endDate);
                double unit = 1;//默认是天
                if (frequencyType==1) {
                    unit = 1;
                }else if (frequencyType ==2){
                    unit = 3.5;
                }else if (frequencyType ==3){
                    unit = 7;
                }else if (frequencyType ==4){
                    unit = 14;
                }else if (frequencyType ==5){
                    unit = 15;
                }else if (frequencyType ==6){
                    unit = 30;
                }else if (frequencyType ==7){
                    unit = 120;
                }else if (frequencyType ==2){
                    unit = 180;
                }else if (frequencyType ==2){
                    unit = 360;
                }
                double dayByone = frequency1 * unit / frequency2;//一次多少天
                double douCount = differentDays / dayByone;//需要多少次
                int intCount = (int) douCount;
                if (douCount>intCount) intCount+=1;
                for (int x = 0; x<intCount;x++){
                    gwQualityInspectTaskDetail.setTaskStime(startDate);
                    startDate = DateUtil.addDateDay(startDate, dayByone);//下一个开始时间就是上一个结束时间
                    if (DateUtil.compareDate(endDate,startDate)){
                        gwQualityInspectTaskDetail.setTaskEtime(endDate);
                    }else {
                        gwQualityInspectTaskDetail.setTaskEtime(startDate);
                    }
                    gwQualityInspectTaskDetail.setId(null);
                    gwQualityInspectTaskDetailMapper.insertSelective(gwQualityInspectTaskDetail);
                    Long id = gwQualityInspectTaskDetail.getId();
                    for (int j = 0; j < gwCheckContents.size() ;j++){
                        GwCheckContent gwCheckContent = gwCheckContents.get(j);
//                    int score = gwCheckContent.getScore();
                        GwQualityInspectTaskResult gwQualityInspectTaskResult = new GwQualityInspectTaskResult();
                        gwQualityInspectTaskResult.setQitdId(id);
                        gwQualityInspectTaskResult.setCheckContent(gwCheckContent.getContent());
//                    gwQualityInspectTaskResult.setIsQualified();
//                    gwQualityInspectTaskResult.setScore();
//                    gwQualityInspectTaskResult.setCheckTime();
//                    gwQualityInspectTaskResult.setCheckSituation();
//                    gwQualityInspectTaskResult.setEnclosure();
//                    gwQualityInspectTaskResult.setRemark();
                        gwQualityInspectTaskResultMapper.insertSelective(gwQualityInspectTaskResult);
                    }
                }
                }

            GwQualityInspectTask qit = new GwQualityInspectTask();
            qit.setId(taskId);
            qit.setGenerate(true);
            gwQualityInspectTaskMapper.updateByPrimaryKeySelective(qit);
            return BaseResult.ok(BaseResult.CODE_OK_MESSAGE);
        }catch (Exception e){
            e.printStackTrace();
            return BaseResult.fail("失败",e);
        }
    }
}
