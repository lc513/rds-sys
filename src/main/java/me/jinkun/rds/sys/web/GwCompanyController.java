package me.jinkun.rds.sys.web;

import me.jinkun.rds.common.base.Tree;
import me.jinkun.rds.sys.service.GwCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 */
@Controller
@RequestMapping("/Company")
public class GwCompanyController {
    @Autowired
    GwCompanyService gwCompanyService;

    @RequestMapping("/tree")
    @ResponseBody
    public List<Tree> tree(){
        return gwCompanyService.tree();
    }
}
