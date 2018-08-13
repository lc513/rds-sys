package me.jinkun.rds.sys.web;

import me.jinkun.rds.sys.domain.GwSupplier;
import me.jinkun.rds.sys.service.GwSupplierService;
import me.jinkun.rds.sys.web.form.GwSupplierForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *  供应商信息（被检查的公司）
 */
@Controller
@RequestMapping("/Supplier")
public class GwSupplierController {
    @Autowired
    GwSupplierService gwSupplierService;

    @RequestMapping("/tree")
    @ResponseBody
    public List<GwSupplierForm> getList(){
        return gwSupplierService.getList();
    }
}
