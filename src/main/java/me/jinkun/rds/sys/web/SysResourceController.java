package me.jinkun.rds.sys.web;

import com.google.gson.Gson;
import me.jinkun.rds.common.base.EUDataGridResult;
import me.jinkun.rds.sys.service.SysResourceService;
import me.jinkun.rds.sys.service.SysRoleResourceService;
import me.jinkun.rds.sys.web.form.SysResourceForm;
import me.jinkun.rds.sys.web.form.SysRoleResourceForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description: HelloWorld！ <br/>
 * @Autor: Created by jinkun on 2016/12/4.
 */
@Controller
public class SysResourceController {

    @Autowired
    SysResourceService sysResourceService;
    @Autowired
    SysRoleResourceService sysRoleResourceService;

    @RequestMapping(value = "/sys/resources/ui/{ui}", method = RequestMethod.GET)
    public String ui(@PathVariable("ui") String ui) {
        return "sys/sys-resource/sys-resource-" + ui;
    }

    @RequestMapping(value = "/sys/resources", method = RequestMethod.POST)
    @ResponseBody
    public Object save(SysResourceForm form) {
        return sysResourceService.saveOrUpdate(form);
    }

    @RequestMapping(value = "/sys/resources/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        return sysResourceService.deleteByIds(ids);
    }

    @RequestMapping(value = "/sys/resourcesbyRole/{roleId}", method = RequestMethod.GET)
    @ResponseBody
    public Object list(@PathVariable String roleId,SysResourceForm form) {
        SysRoleResourceForm sysRoleResourceForm = new SysRoleResourceForm();
        sysRoleResourceForm.setRoleId(Long.parseLong(roleId));
        List<SysRoleResourceForm> list = sysRoleResourceService.list2(sysRoleResourceForm);
        String data = new Gson().toJson(list);
        System.out.println("data :    " + data);

        EUDataGridResult euDataGridResult = sysResourceService.listPage(form);
        List<SysResourceForm> sysResourceForms = (List<SysResourceForm>) euDataGridResult.getRows();
        for (int i = 0; i < sysResourceForms.size(); i++) {
            Long id = sysResourceForms.get(i).getId();
            for (int j = 0; j < list.size(); j++) {
                Long resourceId = list.get(j).getResourceId();
                if (id .equals(resourceId) ) {
                    sysResourceForms.get(i).setHasJurisdiction(true);
                }
            }
        }
        euDataGridResult.setRows(sysResourceForms);
        return euDataGridResult;
    }

    @RequestMapping(value = "/sys/resources/tree", method = RequestMethod.GET)
    @ResponseBody
    public Object tree(SysResourceForm form) {
        return sysResourceService.tree(form);
    }

    @RequestMapping(value = "/sys/resources/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object get(@PathVariable("id") Long id) {
        return sysResourceService.get(id);
    }
}
