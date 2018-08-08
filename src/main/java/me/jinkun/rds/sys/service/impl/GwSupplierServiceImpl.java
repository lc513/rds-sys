package me.jinkun.rds.sys.service.impl;

import me.jinkun.rds.sys.dao.GwSupplierMapper;
import me.jinkun.rds.sys.domain.GwSupplier;
import me.jinkun.rds.sys.service.GwSupplierService;
import me.jinkun.rds.sys.web.form.GwSupplierForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Controller
public class GwSupplierServiceImpl implements GwSupplierService {
    @Autowired
    GwSupplierMapper gwSupplierMapper;

    @Override
    public List<GwSupplierForm> getList() {
        List<GwSupplierForm> gwSupplierForms = new ArrayList<GwSupplierForm>();
        List<GwSupplier> gwSuppliers = gwSupplierMapper.selectByExample(null);
        for (int i=0;i<gwSuppliers.size();i++){
            gwSuppliers.get(i).setText(gwSuppliers.get(i).getName());
        }
        GwSupplierForm gwSupplierForm = new GwSupplierForm();
        gwSupplierForm.setId(0l);
        gwSupplierForm.setState("open");
        gwSupplierForm.setText("东吴物业");
        gwSupplierForm.setChildren(gwSuppliers);
        gwSupplierForms.add(gwSupplierForm);
        return gwSupplierForms;
    }
}
