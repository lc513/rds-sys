package me.jinkun.rds.sys.service.impl;

import me.jinkun.rds.common.base.Tree;
import me.jinkun.rds.sys.dao.GwCheckTempMapper;
import me.jinkun.rds.sys.domain.GwCheckTemp;
import me.jinkun.rds.sys.service.GwCheckTempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GwCheckTempServiceImpl implements GwCheckTempService {
    @Autowired
    GwCheckTempMapper gwCheckTempMapper;
    @Override
    public List<Tree> tree() {
        List<GwCheckTemp> gwCheckTemps = gwCheckTempMapper.selectByExample(null);
        List<Tree> trees = orgListToTreeList(gwCheckTemps);
        return trees;
    }
    private List<Tree> orgListToTreeList(List<GwCheckTemp> gwCheckTemps) {
        List<Tree> treeList = new ArrayList<Tree>();
        if (gwCheckTemps != null && gwCheckTemps.size() > 0) {
            for (GwCheckTemp checkTemp : gwCheckTemps) {
                treeList.add(orgToTree(checkTemp));
            }
        }
        return treeList;
    }
    private Tree orgToTree(GwCheckTemp checkTemp) {
        Tree tree = new Tree();
        tree.setId(checkTemp.getId());
        tree.setText(checkTemp.getName());
        return tree;
    }
}
