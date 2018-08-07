package me.jinkun.rds.sys.service.impl;

import me.jinkun.rds.common.base.BaseResult;
import me.jinkun.rds.common.base.Tree;
import me.jinkun.rds.sys.dao.SysProjectMapper;
import me.jinkun.rds.sys.domain.SysOrg;
import me.jinkun.rds.sys.domain.SysProject;
import me.jinkun.rds.sys.service.SysProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysProjectServiceImpl implements SysProjectService {

    @Autowired
    SysProjectMapper sysProjectMapper;

    @Override
    public BaseResult getList() {
        try{

            List<SysProject> sysProjects = sysProjectMapper.selectByExample(null);
            return BaseResult.ok(BaseResult.CODE_OK_MESSAGE,sysProjects);
        }catch (Exception e){
            e.printStackTrace();
            return BaseResult.fail(BaseResult.CODE_FAIL_MESSAGE,e);
        }
    }

    @Override
    public List<Tree> tree() {
        List<SysProject> sysProjects = sysProjectMapper.selectByExample(null);
        List<Tree> trees = orgListToTreeList(sysProjects);
        return trees;
    }
    private List<Tree> orgListToTreeList(List<SysProject> orgList) {
        List<Tree> treeList = new ArrayList<Tree>();
        if (orgList != null && orgList.size() > 0) {
            for (SysProject org : orgList) {
                treeList.add(orgToTree(org));
            }
        }
        return treeList;
    }
    private Tree orgToTree(SysProject sysProject) {
        Tree tree = new Tree();
        tree.setId(sysProject.getId());
        tree.setText(sysProject.getName());
        return tree;
    }


}
