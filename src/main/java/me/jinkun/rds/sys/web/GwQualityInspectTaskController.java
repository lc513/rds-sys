package me.jinkun.rds.sys.web;

import com.google.gson.Gson;
import me.jinkun.rds.common.base.BaseResult;
import me.jinkun.rds.sys.domain.GwQualityInspectTask;
import me.jinkun.rds.sys.service.GwQualityInspectTaskService;
import me.jinkun.rds.sys.web.form.GwQualityInspectTaskForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@Controller
@RequestMapping("/QualityInspectTask")
public class GwQualityInspectTaskController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    GwQualityInspectTaskService gwQualityInspectTaskService;

    @RequestMapping("/ui/{path}")
    public String ui(@PathVariable String path){
        return "/gw/gw-quality-inspect-task/gw-quality-inspect-task-"+path;
    }

    /**
     * 查看计划
     * @param gwQualityInspectTaskForm
     * @param offset
     * @param limit
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object getGwQualityInspectTaskList(GwQualityInspectTaskForm gwQualityInspectTaskForm,@RequestParam(defaultValue = "1") int offset, @RequestParam(defaultValue = "10") int limit){
        return gwQualityInspectTaskService.getGwQualityInspectTaskList(gwQualityInspectTaskForm,offset,limit);
    }

    /**
     * 添加计划
     * @param gwQualityInspectTaskForm
     * @return
     */
    @RequestMapping(value = "/addTask",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult addTask(GwQualityInspectTaskForm gwQualityInspectTaskForm){
        return gwQualityInspectTaskService.addTask(gwQualityInspectTaskForm);
    }


    /**
     * 岗位自检任务下载
     * @param authorization
     * @return
     */
    @RequestMapping(value = "/QualityInspectTaskDownLoad",method = RequestMethod.GET)
    public Object QualityInspectTaskDownLoad(@RequestHeader("Authorization") String authorization){
        return gwQualityInspectTaskService.selectQualityInspectTaskDownLoad(authorization);
    }
}
