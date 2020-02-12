package com.myzg.gymnasium.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myzg.gymnasium.entity.Expenditure;
import com.myzg.gymnasium.exception.ErrorEnum;
import com.myzg.gymnasium.exception.ProgramException;
import com.myzg.gymnasium.responsebody.ResponseBody;
import com.myzg.gymnasium.service.impl.ExpenditureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 支出表 前端控制器
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@RestController
@RequestMapping("/expenditure")
public class ExpenditureController {

    @Autowired
    private ExpenditureServiceImpl expenditureService;

    @GetMapping(params = "id")
    public ResponseBody getExpenditure(@RequestParam Integer id) {
        return ResponseBody.OK(expenditureService.getById(id));
    }

    @GetMapping(params = {"page","limit"})
    public ResponseBody getExpenditurePage(@RequestParam Integer page,@RequestParam Integer limit) {
        return ResponseBody.OK(expenditureService.getBaseMapper().selectPage(new Page(page*limit-limit,limit),null).getRecords());
    }

    @PostMapping
    public ResponseBody saveExpenditure(Expenditure expenditure) {
        if(expenditureService.save(expenditure)){
            return ResponseBody.OK(expenditure.getTId());
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

    @PutMapping
    public ResponseBody updateExpenditure(Expenditure expenditure) {
        if(expenditureService.updateById(expenditure)){
            return ResponseBody.OK(null);
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

    @DeleteMapping
    public ResponseBody deleteExpenditure(@RequestParam Integer id) {
        if(expenditureService.removeById(id)){
            return ResponseBody.OK(null);
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }


}

