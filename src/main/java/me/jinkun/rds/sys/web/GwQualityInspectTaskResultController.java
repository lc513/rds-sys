package me.jinkun.rds.sys.web;

import me.jinkun.rds.sys.service.GwQualityInspectTaskResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.management.snmp.AdaptorBootstrap;

@Controller
@RequestMapping("/GwQualityInspectTaskResult")
public class GwQualityInspectTaskResultController {

    @Autowired
    GwQualityInspectTaskResultService gwQualityInspectTaskResultService;

    /**
     * 根据计划的详情id获取计划的检查标准
     * @param qitdId
     * @return
     */
    @RequestMapping("/list/{qitdId}")
    @ResponseBody
    public Object list(@PathVariable long qitdId){
        return gwQualityInspectTaskResultService.selectList(qitdId);
    }
}
