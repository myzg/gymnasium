package com.myzg.gymnasium.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myzg.gymnasium.entity.Branch;
import com.myzg.gymnasium.exception.ErrorEnum;
import com.myzg.gymnasium.exception.ProgramException;
import com.myzg.gymnasium.responsebody.ResponseBody;
import com.myzg.gymnasium.service.impl.BranchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private BranchServiceImpl branchService;

    @GetMapping
    public ResponseBody getAllBranch (){
        return ResponseBody.OK(branchService.findBranAll());
    }

    @GetMapping(params = "id")
    public ResponseBody findBranchById(@RequestParam Integer id) {
        return ResponseBody.OK(branchService.getById(id));
    }

    @GetMapping(params = {"page","limit"})
    public ResponseBody findBranchByPage(@RequestParam Integer page, @RequestParam Integer limit) {
        return ResponseBody.OK(branchService.getBaseMapper().selectPage(new Page(page*limit-limit,limit),null).getRecords());
    }

    @PostMapping
    public ResponseBody saveBranch(Branch branch) {
        if(branchService.save(branch)) {
            return ResponseBody.OK(branch.getTId());
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

    @DeleteMapping
    public ResponseBody DeleteBranch(@RequestParam Integer id) {
        if(branchService.removeById(id)){
            return ResponseBody.OK(null);
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

    @PutMapping
    public ResponseBody updateBranch(Branch branch) {
        if(branchService.updateById(branch)) {
            return ResponseBody.OK(null);
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

}

