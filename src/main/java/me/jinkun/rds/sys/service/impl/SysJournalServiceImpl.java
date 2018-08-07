package me.jinkun.rds.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import me.jinkun.rds.common.base.BaseResult;
import me.jinkun.rds.common.base.EUDataGridResult;
import me.jinkun.rds.common.shiro.ShiroUser;
import me.jinkun.rds.common.utils.DateUtil;
import me.jinkun.rds.sys.convert.SysUserConvert;
import me.jinkun.rds.sys.dao.SysJournalMapper;
import me.jinkun.rds.sys.domain.SysJournal;
import me.jinkun.rds.sys.domain.SysJournalExample;
import me.jinkun.rds.sys.domain.SysProject;
import me.jinkun.rds.sys.domain.SysUser;
import me.jinkun.rds.sys.service.SysJournalService;
import me.jinkun.rds.sys.web.form.SysJournalForm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SysJournalServiceImpl implements SysJournalService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    SysJournalMapper sysJournalMapper;

    @Override
    public BaseResult getJournal(SysJournalForm sysJournal, int offset, int limit) {

        long count = 0;
        EUDataGridResult result = null;
        try {
            Subject subject = SecurityUtils.getSubject();
            ShiroUser principal = (ShiroUser) subject.getPrincipal();
            Long userId = principal.getId();
            SysJournalExample sysJournalExample = new SysJournalExample();
            SysJournalExample.Criteria criteria = sysJournalExample.createCriteria();
            criteria.andUIdEqualTo(userId);
            if (sysJournal.getStartTime() != null && sysJournal.getEndTime() != null) {
                criteria.andJDateBetween(sysJournal.getStartTime(), sysJournal.getEndTime());
            }
            count = sysJournalMapper.countByExample(sysJournalExample);
            PageHelper.offsetPage(offset, limit, "jDate");

            PageInfo<SysJournal> sysJournalPageInfo = new PageInfo<SysJournal>(sysJournalMapper.selectJournalAndProjectByExample(sysJournalExample));
            logger.error("---------"+new Gson().toJson(sysJournalPageInfo));
            result = new EUDataGridResult(count, sysJournalPageInfo.getList());
            return result;
        } catch (Exception e) {
            count = 0;
            //返回结果
            result = new EUDataGridResult(count, new ArrayList<SysJournal>());
            return result;
        }

    }

    @Override
    public BaseResult addJournal(SysJournalForm sysJournal) {

        try {
            Date date = sysJournal.getjDate();
            if (date ==null){
                return BaseResult.fail("日期没有选择");
            }
            //获取登录用户ID
            Subject subject = SecurityUtils.getSubject();
            ShiroUser principal = (ShiroUser) subject.getPrincipal();
            Long userId = principal.getId();
            sysJournal.setId(null);
            sysJournal.setuId(userId);
            SysJournalExample sysJournalExample = new SysJournalExample();
            SysJournalExample.Criteria criteria = sysJournalExample.createCriteria();
            criteria.andUIdEqualTo(userId);
            Date daybyDAY = DateUtil.getDaybyDAY(date, 0);
            criteria.andJDateBetween(DateUtil.getDaybyDAY(date,0), DateUtil.getDaybyDAY(date,1));
            List<SysJournal> sysJournals = sysJournalMapper.selectByExample(sysJournalExample);
            if (sysJournals.size() == 0) {
                sysJournalMapper.insertSelective(sysJournal);
                return BaseResult.ok(BaseResult.CODE_OK_MESSAGE, null);
            } else {
                return BaseResult.fail("当日日志已经添加");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.fail(BaseResult.CODE_FAIL_MESSAGE, e);
        }
    }

    @Override
    public BaseResult updateJournal(SysJournalForm sysJournal) {
        try {
            Date date = sysJournal.getjDate();
            if (date ==null){
                return BaseResult.fail("日期没有选择");
            }
            //获取登录用户ID
            Subject subject = SecurityUtils.getSubject();
            ShiroUser principal = (ShiroUser) subject.getPrincipal();
            Long userId = principal.getId();
            sysJournal.setuId(userId);
            Long id = sysJournal.getId();
            if (id == 0) {
                return BaseResult.fail("上参数异常");
            }
            SysJournalExample sysJournalExample = new SysJournalExample();
            SysJournalExample.Criteria criteria = sysJournalExample.createCriteria();
            criteria.andUIdEqualTo(userId);
            criteria.andIdEqualTo(id);
            List<SysJournal> sysJournals = sysJournalMapper.selectByExample(sysJournalExample);
            if (sysJournals.size() == 0) {
                return BaseResult.fail("当日日志不存在");
            } else {
                int examine = sysJournals.get(0).getExamine();
                if (1 == examine) {
                    return BaseResult.fail("已经审核的日志无法修改");
                }
                sysJournalMapper.updateByPrimaryKeySelective(sysJournal);
                return BaseResult.ok(BaseResult.CODE_OK_MESSAGE, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.fail(BaseResult.CODE_FAIL_MESSAGE, e);
        }
    }

    @Override
    public BaseResult deleteJournal(SysJournalForm sysJournal) {

        try {
            Long id = sysJournal.getId();
            if (id == 0) {
                return BaseResult.fail("上传参数异常");
            }
            //获取登录用户ID
            Subject subject = SecurityUtils.getSubject();
            ShiroUser principal = (ShiroUser) subject.getPrincipal();
            Long userId = principal.getId();
            SysJournalExample sysJournalExample = new SysJournalExample();
            SysJournalExample.Criteria criteria = sysJournalExample.createCriteria();
            criteria.andIdEqualTo(id);
            List<SysJournal> sysJournals = sysJournalMapper.selectByExample(sysJournalExample);
            if (sysJournals.size() == 0) {
                return BaseResult.fail("添加日志失败");
            } else {
                Integer examine = sysJournals.get(0).getExamine();
                if (examine == 1) {
                    return BaseResult.fail("已经审核的日志无法修改");
                }
                sysJournalMapper.deleteByPrimaryKey(id);
                return BaseResult.ok(BaseResult.CODE_OK_MESSAGE, null);
            }
        } catch (Exception e) {
            return BaseResult.fail(BaseResult.CODE_FAIL_MESSAGE, e);
        }
    }


}
