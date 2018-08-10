package me.jinkun.rds.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import me.jinkun.rds.common.base.BaseResult;
import me.jinkun.rds.common.base.EUDataGridResult;
import me.jinkun.rds.common.shiro.ShiroUser;
import me.jinkun.rds.sys.dao.GwQualityInspectTaskMapper;
import me.jinkun.rds.sys.dao.SysUserMapper;
import me.jinkun.rds.sys.domain.*;
import me.jinkun.rds.sys.service.GwQualityInspectTaskService;
import me.jinkun.rds.sys.web.form.GwQualityInspectTaskForm;
import org.apache.http.util.TextUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GwQualityInspectTaskServiceImpl implements GwQualityInspectTaskService {
    @Autowired
    GwQualityInspectTaskMapper mapper;
    @Autowired
    SysUserMapper sysUserMapper;

    Logger logger = LoggerFactory.getLogger(GwQualityInspectTaskServiceImpl.this.getClass());

    @Override
    public EUDataGridResult getGwQualityInspectTaskList(GwQualityInspectTaskForm gwQualityInspectTaskForm, int offset, int limit) {
        EUDataGridResult result = null;
        long count = 0;
        try {
            gwQualityInspectTaskForm.setsId(1l);//1代表是阳澄湖游客中心的
            Subject subject = SecurityUtils.getSubject();
            ShiroUser shiroUser = (ShiroUser) subject.getPrincipal();
            Long id = shiroUser.getId();
            GwQualityInspectTaskExample gwQualityInspectTaskExample = new GwQualityInspectTaskExample();
            GwQualityInspectTaskExample.Criteria criteria = gwQualityInspectTaskExample.createCriteria();
            if (gwQualityInspectTaskForm.getStartTime() != null && gwQualityInspectTaskForm.getEndTime() != null) {
                criteria.andCreateTimeBetween(gwQualityInspectTaskForm.getStartTime(), gwQualityInspectTaskForm.getEndTime());
            }
            Long sId = gwQualityInspectTaskForm.getsId();
            if (sId != null) {
                criteria.andSIdEqualTo(sId);
            } else {
                //sid（供应商信息（被检查的公司））不传直接返回0条
                return new EUDataGridResult(count, new ArrayList<GwQualityInspectTask>());
            }
            count = mapper.countByExample(gwQualityInspectTaskExample);
            PageHelper.offsetPage(offset, limit);
            PageInfo<GwQualityInspectTask> info = new PageInfo<GwQualityInspectTask>(mapper.selectCarrySonByExample(gwQualityInspectTaskForm));
            logger.error(new Gson().toJson(info.getList()));
            result = new EUDataGridResult(count, info.getList());
        } catch (Exception e) {
            e.printStackTrace();
            result = new EUDataGridResult(count, new ArrayList<GwQualityInspectTask>());

        }
        return result;
    }

    @Override
    public BaseResult addTask(GwQualityInspectTaskForm gwQualityInspectTaskForm) {
        try {
            String name = gwQualityInspectTaskForm.getName();
            Long ctId = gwQualityInspectTaskForm.getCtId();
            Long year = gwQualityInspectTaskForm.getYear();
            Date startTime = gwQualityInspectTaskForm.getStartTime();
            Date endTime = gwQualityInspectTaskForm.getEndTime();
            Long cid = gwQualityInspectTaskForm.getcId();
            Long uid = gwQualityInspectTaskForm.getuId();
            Long sId = gwQualityInspectTaskForm.getsId();
            Long inspectorId = gwQualityInspectTaskForm.getInspectorId();
            if (TextUtils.isEmpty(name)) {
                return BaseResult.fail("计划名称为填写");
            }
            if (ctId == null || ctId == 0l) {
                return BaseResult.fail("检查模板未选择");
            }
            if (year == null || year == 0l) {
                return BaseResult.fail("检查年份未选择");
            }
            if (startTime == null || endTime == null) {
                return BaseResult.fail("起止时间未选择");
            }
            if (cid == null || cid == 0l) {
                return BaseResult.fail("所属部门未选择");
            }
            if (sId == null || sId == 0l) {
                return BaseResult.fail("受检项目未指定");
            }
            if (inspectorId == null || inspectorId == 0l) {
                return BaseResult.fail("检查人员未指定");
            }
            gwQualityInspectTaskForm.setCreateTime(new Date());
            gwQualityInspectTaskForm.setSort((int) mapper.countByExample(null));
            mapper.insert(gwQualityInspectTaskForm);
            return BaseResult.ok(BaseResult.CODE_OK_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.fail("请求错误", e);
        }
    }


    @Override
    public BaseResult selectQualityInspectTaskDownLoad(String authorization) {
        SysUser sysUser;
        try {
            String[] user = authorization.split(":");
            SysUserExample sysUserExample = new SysUserExample();
            SysUserExample.Criteria criteria = sysUserExample.createCriteria();
            criteria.andLoginNameEqualTo(user[0]);
            criteria.andPasswordEqualTo(user[1]) ;
            List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
            if (sysUsers.size()<=0){
                return BaseResult.fail("账号或密码错误");
            }
            sysUser = sysUsers.get(0);
        } catch (Exception e) {
                return BaseResult.fail("用户信息错误",e);
        }

        try{
            Long uId = sysUser.getId();
            GwQualityInspectTaskForm gwQualityInspectTaskForm = new GwQualityInspectTaskForm();
            gwQualityInspectTaskForm.setInspectorId(uId);
            gwQualityInspectTaskForm.setNowTime(new Date());
            List<GwQualityInspectTaskForm> gwQualityInspectTaskForms = mapper.selectDownByUser(gwQualityInspectTaskForm);
            return BaseResult.ok("获取成功",gwQualityInspectTaskForms);
        }catch (Exception e){
            e.printStackTrace();
            return BaseResult.fail("失败",e);
        }

    }

}
