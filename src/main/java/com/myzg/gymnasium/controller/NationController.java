package com.myzg.gymnasium.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myzg.gymnasium.entity.Mbrbusiness;
import com.myzg.gymnasium.entity.Nation;
import com.myzg.gymnasium.exception.ErrorEnum;
import com.myzg.gymnasium.exception.ProgramException;
import com.myzg.gymnasium.responsebody.ResponseBody;
import com.myzg.gymnasium.service.impl.MbrbusinessServiceImpl;
import com.myzg.gymnasium.service.impl.NationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 民族表 前端控制器
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@RestController
@RequestMapping("/nation")
public class NationController {

    @Autowired
    private NationServiceImpl nationService;

    @GetMapping(params = "id")
    public ResponseBody getIncomeById(@RequestParam Integer id) {
        return ResponseBody.OK(nationService.getById(id));
    }

    @GetMapping(params = {"page","limit"})
    public ResponseBody getIncomePage(@RequestParam Integer page,@RequestParam Integer limit) {
        return ResponseBody.OK(nationService.getBaseMapper().selectPage(new Page(page*limit-limit,limit),null).getRecords());
    }

    @PostMapping
    public ResponseBody saveIncomePage(Nation nation) {
        if(nationService.save(nation)){
            return ResponseBody.OK(nation.getNId());
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

    @PutMapping
    public ResponseBody updateIncome(Nation nation) {
        if(nationService.updateById(nation)){
            return ResponseBody.OK(null);
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

    @DeleteMapping
    public ResponseBody deleteIncomeById(@RequestParam Integer id) {
        if(nationService.removeById(id)){
            return ResponseBody.OK(null);
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

    @GetMapping
    public ResponseBody getAllNation() {
        return ResponseBody.OK(nationService.getBaseMapper().getAllNation());
    }

}

