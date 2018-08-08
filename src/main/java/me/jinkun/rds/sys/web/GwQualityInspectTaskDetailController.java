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
     * @param offset
     * @param limit
     * @return
     */
    @RequestMapping("/list/{taskId}")
    @ResponseBody
    public Object list(@PathVariable Long taskId, @RequestParam(defaultValue = "1") int offset, @RequestParam(defaultValue = "10") int limit){
        return gwQualityInspectTaskDetailService.list(taskId,offset,limit);
    }

    /**
     * 自动生成
     * @param taskId 计划id
     * @return
     */
    @RequestMapping("/generate")
    @ResponseBody
    public Object generate(@ModelAttribute Long taskId){

        return gwQualityInspectTaskDetailService.generate(taskId);
    }
}
