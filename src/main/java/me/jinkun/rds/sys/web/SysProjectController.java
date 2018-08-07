package me.jinkun.rds.sys.web;

import me.jinkun.rds.common.base.BaseResult;
import me.jinkun.rds.common.base.Tree;
import me.jinkun.rds.sys.domain.SysProject;
import me.jinkun.rds.sys.service.SysProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/project")
public class SysProjectController {

    @Autowired
    SysProjectService sysProjectService;
    @ResponseBody
    @RequestMapping("/list")
    public BaseResult getList(){
        return sysProjectService.getList();
    }

    @RequestMapping("/tree")
    @ResponseBody
    public List<Tree> tree(){
        return sysProjectService.tree();
    }
}
