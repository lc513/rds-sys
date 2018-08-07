package me.jinkun.rds.sys.service;

import me.jinkun.rds.common.base.BaseResult;
import me.jinkun.rds.common.base.Tree;

import java.util.List;

public interface SysProjectService {
    BaseResult getList();

    List<Tree> tree();
}
