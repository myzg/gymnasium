package com.myzg.gymnasium.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myzg.gymnasium.entity.Nation;
import com.myzg.gymnasium.entity.Operator;
import com.myzg.gymnasium.exception.ErrorEnum;
import com.myzg.gymnasium.exception.ProgramException;
import com.myzg.gymnasium.responsebody.ResponseBody;
import com.myzg.gymnasium.service.impl.NationServiceImpl;
import com.myzg.gymnasium.service.impl.OperatorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 操作员表 前端控制器
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@RestController
@RequestMapping("/operator")
public class OperatorController {

    @Autowired
    private OperatorServiceImpl operatorService;

    @GetMapping(params = "id")
    public ResponseBody getIncomeById(@RequestParam Integer id) {
        return ResponseBody.OK(operatorService.getById(id));
    }

    @GetMapping(params = {"page","limit"})
    public ResponseBody getIncomePage(@RequestParam Integer page,@RequestParam Integer limit) {
        return ResponseBody.OK(operatorService.getBaseMapper().selectPage(new Page(page*limit-limit,limit),null).getRecords());
    }

    @PostMapping
    public ResponseBody saveIncomePage(Operator operator) {
        if(operatorService.save(operator)){
            return ResponseBody.OK(operator.getTId());
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

    @PutMapping
    public ResponseBody updateIncome(Operator operator) {
        if(operatorService.updateById(operator)){
            return ResponseBody.OK(null);
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

    @DeleteMapping
    public ResponseBody deleteIncomeById(@RequestParam Integer id) {
        if(operatorService.removeById(id)){
            return ResponseBody.OK(null);
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

}

