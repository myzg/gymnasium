package com.myzg.gymnasium.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myzg.gymnasium.entity.Mbrbasic;
import com.myzg.gymnasium.entity.Mbrbusiness;
import com.myzg.gymnasium.exception.ErrorEnum;
import com.myzg.gymnasium.exception.ProgramException;
import com.myzg.gymnasium.responsebody.ResponseBody;
import com.myzg.gymnasium.service.impl.MbrbasicServiceImpl;
import com.myzg.gymnasium.service.impl.MbrbusinessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 会员业务表 前端控制器
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@RestController
@RequestMapping("/mbrbusiness")
public class MbrbusinessController {

    @Autowired
    private MbrbusinessServiceImpl mbrbusinessService;

    @GetMapping(params = "id")
    public ResponseBody getIncomeById(@RequestParam Integer id) {
        return ResponseBody.OK(mbrbusinessService.getById(id));
    }

    @GetMapping(params = {"page","limit"})
    public ResponseBody getIncomePage(@RequestParam Integer page,@RequestParam Integer limit) {
        return ResponseBody.OK(mbrbusinessService.getBaseMapper().selectPage(new Page(page*limit-limit,limit),null).getRecords());
    }

    @PostMapping
    public ResponseBody saveIncomePage(Mbrbusiness mbrbusiness) {
        if(mbrbusinessService.save(mbrbusiness)){
            return ResponseBody.OK(mbrbusiness.getTId());
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

    @PutMapping
    public ResponseBody updateIncome(Mbrbusiness mbrbusiness) {
        if(mbrbusinessService.updateById(mbrbusiness)){
            return ResponseBody.OK(null);
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

    @DeleteMapping
    public ResponseBody deleteIncomeById(@RequestParam Integer id) {
        if(mbrbusinessService.removeById(id)){
            return ResponseBody.OK(null);
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

}

