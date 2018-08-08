package me.jinkun.rds.sys.service.impl;

import me.jinkun.rds.common.base.Tree;
import me.jinkun.rds.sys.dao.GwCompanyMapper;
import me.jinkun.rds.sys.domain.GwCheckTemp;
import me.jinkun.rds.sys.domain.GwCompany;
import me.jinkun.rds.sys.service.GwCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GwCompanyServiceImpl implements GwCompanyService {
    @Autowired
    GwCompanyMapper gwCompanyMapper;

    @Override
    public List<Tree> tree() {
        List<GwCompany> gwCompanies = gwCompanyMapper.selectByExample(null);
        List<Tree> trees = orgListToTreeList(gwCompanies);
        return trees;
    }
    private List<Tree> orgListToTreeList(List<GwCompany> gwCompanies) {
        List<Tree> treeList = new ArrayList<Tree>();
        if (gwCompanies != null && gwCompanies.size() > 0) {
            for (GwCompany company : gwCompanies) {
                treeList.add(orgToTree(company));
            }
        }
        return treeList;
    }
    private Tree orgToTree(GwCompany company) {
        Tree tree = new Tree();
        tree.setId(company.getId());
        tree.setText(company.getName());
        return tree;
    }
}
