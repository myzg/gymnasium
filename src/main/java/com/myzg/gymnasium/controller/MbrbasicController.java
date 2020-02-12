package com.myzg.gymnasium.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myzg.gymnasium.entity.Income;
import com.myzg.gymnasium.entity.Mbrbasic;
import com.myzg.gymnasium.exception.ErrorEnum;
import com.myzg.gymnasium.exception.ProgramException;
import com.myzg.gymnasium.responsebody.ResponseBody;
import com.myzg.gymnasium.service.impl.IncomeServiceImpl;
import com.myzg.gymnasium.service.impl.MbrbasicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 会员基础信息表 前端控制器
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@RestController
@RequestMapping("/mbrbasic")
public class MbrbasicController {

    @Autowired
    private MbrbasicServiceImpl mbrbasicService;

    @GetMapping(params = "id")
    public ResponseBody getIncomeById(@RequestParam Integer id) {
        return ResponseBody.OK(mbrbasicService.getById(id));
    }

    @GetMapping(params = {"page","limit"})
    public ResponseBody getIncomePage(@RequestParam Integer page,@RequestParam Integer limit) {
        return ResponseBody.OK(mbrbasicService.getBaseMapper().selectPage(new Page<Mbrbasic>(page*limit-limit,limit), null));
    }

    @PostMapping
    public ResponseBody saveIncomePage(Mbrbasic mbrbasic) {
        if(mbrbasicService.save(mbrbasic)){
            return ResponseBody.OK(mbrbasic.getId());
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

    @PutMapping
    public ResponseBody updateIncome(Mbrbasic mbrbasic) {
        if(mbrbasicService.updateById(mbrbasic)){
            return ResponseBody.OK(null);
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

    @DeleteMapping
    public ResponseBody deleteIncomeById(@RequestParam Integer id) {
        if(mbrbasicService.removeById(id)){
            return ResponseBody.OK(null);
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

}

