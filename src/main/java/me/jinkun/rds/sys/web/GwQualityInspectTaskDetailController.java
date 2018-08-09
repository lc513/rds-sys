package me.jinkun.rds.sys.web;

import me.jinkun.rds.sys.service.GwQualityInspectTaskDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/QualityInspectTaskDetail")
public class GwQualityInspectTaskDetailController {
    @Autowired
    GwQualityInspectTaskDetailService gwQualityInspectTaskDetailService;

    /**
     * 获取计划详情
     * @param taskId
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list/{taskId}")
    @ResponseBody
    public Object list(@PathVariable Long taskId, @RequestParam int page, @RequestParam int rows){
        System.out.println(page+"---"+rows);
        return gwQualityInspectTaskDetailService.list(taskId,page,rows);
    }

    /**
     * 自动生成
     * @param taskId 计划id
     * @return
     */
    @RequestMapping("/generate")
    @ResponseBody
    public Object generate(@RequestParam Long taskId){

        return gwQualityInspectTaskDetailService.insertGenerate(taskId);
    }
}
