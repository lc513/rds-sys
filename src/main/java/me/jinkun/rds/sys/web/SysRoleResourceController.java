package me.jinkun.rds.sys.web;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import me.jinkun.rds.common.base.BaseResult;
import me.jinkun.rds.sys.service.SysRoleResourceService;
import me.jinkun.rds.sys.web.form.JurisdictionBean;
import me.jinkun.rds.sys.web.form.SysRoleResourceForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: HelloWorld！ <br/>
 * @Autor: Created by jinkun on 2016/12/4.
 */
@Controller
public class SysRoleResourceController {

    @Autowired
    SysRoleResourceService sysRoleResourceService;

    @RequestMapping(value = "/sys/role/resources/ui/{ui}", method = RequestMethod.GET)
    public String ui(@PathVariable("ui") String ui) {
        return "sys/sys-role-resource/sys-role-resource-" + ui;
    }

//    @RequestMapping(value = "/sys/role/resources", method = RequestMethod.POST)
//    @ResponseBody
//    public Object save(SysRoleResourceForm form) {
//        return sysRoleResourceService.saveOrUpdate(form);
//    }

    @RequestMapping(value = "/sys/role/resources/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        return sysRoleResourceService.deleteByIds(ids);
    }

    @RequestMapping(value = "/sys/role/resources", method = RequestMethod.GET)
    @ResponseBody
    public Object list(SysRoleResourceForm form) {
        return sysRoleResourceService.listPage(form);
    }
    @RequestMapping(value = "/sys/role/resources", method = RequestMethod.POST )// ,produces="text/html;charset=UTF-8"
    @ResponseBody
    public Object list(@RequestBody() String data, HttpServletRequest servletRequest){
            Gson gson = new Gson();
            ArrayList<SysRoleResourceForm> list = new ArrayList();
            JurisdictionBean jurisdictionBean = gson.fromJson(data,JurisdictionBean.class);
            long roleId = jurisdictionBean.getRoleId();
            List<JurisdictionBean.SelsBean> jurisdictionBeans =jurisdictionBean.getSels();
            for (int i = 0; i < jurisdictionBeans.size(); i++) {
                long id  = jurisdictionBeans.get(i).getId();
                list.add(new SysRoleResourceForm(roleId,id));
                List<JurisdictionBean.SelsBean.ChildrenBeanX> childrenBeanX = jurisdictionBeans.get(i).getChildren();
                if (childrenBeanX!=null){
                    for (int j = 0; j < childrenBeanX.size(); j++) {
                        long ID = childrenBeanX.get(j).getId();
                        SysRoleResourceForm sysRoleResourceForm = new SysRoleResourceForm(roleId, ID);
                        list.add(sysRoleResourceForm);
                    }
                }
            }

            return sysRoleResourceService.saveOrUpdate(roleId,list);

    }


    @RequestMapping(value = "/sys/role/resources/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object get(@PathVariable("id") Long id) {
        return sysRoleResourceService.get(id);
    }
}
