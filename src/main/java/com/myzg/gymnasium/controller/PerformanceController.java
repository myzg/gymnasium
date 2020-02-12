package com.myzg.gymnasium.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myzg.gymnasium.entity.Operator;
import com.myzg.gymnasium.entity.Performance;
import com.myzg.gymnasium.exception.ErrorEnum;
import com.myzg.gymnasium.exception.ProgramException;
import com.myzg.gymnasium.responsebody.ResponseBody;
import com.myzg.gymnasium.service.impl.OperatorServiceImpl;
import com.myzg.gymnasium.service.impl.PerformanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 业绩表 前端控制器
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@RestController
@RequestMapping("/performance")
public class PerformanceController {

    @Autowired
    private PerformanceServiceImpl performanceService;

    @GetMapping(params = "id")
    public ResponseBody getIncomeById(@RequestParam Integer id) {
        return ResponseBody.OK(performanceService.getById(id));
    }

    @GetMapping(params = {"page","limit"})
    public ResponseBody getIncomePage(@RequestParam Integer page,@RequestParam Integer limit) {
        return ResponseBody.OK(performanceService.getBaseMapper().selectPage(new Page(page*limit-limit,limit),null).getRecords());
    }

    @PostMapping
    public ResponseBody saveIncomePage(Performance performance) {
        if(performanceService.save(performance)){
            return ResponseBody.OK(performance.getTId());
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

    @PutMapping
    public ResponseBody updateIncome(Performance performance) {
        if(performanceService.updateById(performance)){
            return ResponseBody.OK(null);
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

    @DeleteMapping
    public ResponseBody deleteIncomeById(@RequestParam Integer id) {
        if(performanceService.removeById(id)){
            return ResponseBody.OK(null);
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

}

