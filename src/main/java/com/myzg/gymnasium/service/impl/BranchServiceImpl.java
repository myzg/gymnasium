package com.myzg.gymnasium.service.impl;

import com.myzg.gymnasium.entity.Branch;
import com.myzg.gymnasium.mapper.BranchMapper;
import com.myzg.gymnasium.service.IBranchService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@Service
public class BranchServiceImpl extends ServiceImpl<BranchMapper, Branch> implements IBranchService {


    @Override
    public List<Branch> findBranAll() {
        return getBaseMapper().getAllBranch();
    }
}
