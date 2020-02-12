package com.myzg.gymnasium.service;

import com.myzg.gymnasium.entity.Branch;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
public interface IBranchService extends IService<Branch> {

    public List<Branch> findBranAll();

}
