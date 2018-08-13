package me.jinkun.rds.sys.web;

import me.jinkun.rds.common.base.Tree;
import me.jinkun.rds.sys.service.GwCheckTempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 检查模板 4个级别 检查模板
 */
@Controller
@RequestMapping("/GwCheckTemp")
public class GwCheckTempController {
    @Autowired
    GwCheckTempService gwCheckTempService;

    @RequestMapping("/tree")
    @ResponseBody
    public List<Tree> tree(){
        return gwCheckTempService.tree();
    }

}
