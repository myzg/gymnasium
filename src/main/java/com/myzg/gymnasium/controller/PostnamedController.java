package com.myzg.gymnasium.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myzg.gymnasium.entity.Performance;
import com.myzg.gymnasium.entity.Postnamed;
import com.myzg.gymnasium.exception.ErrorEnum;
import com.myzg.gymnasium.exception.ProgramException;
import com.myzg.gymnasium.responsebody.ResponseBody;
import com.myzg.gymnasium.service.impl.PerformanceServiceImpl;
import com.myzg.gymnasium.service.impl.PostnamedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 职称表 前端控制器
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@RestController
@RequestMapping("/postnamed")
public class PostnamedController {

    @Autowired
    private PostnamedServiceImpl postnamedService;

    @GetMapping
    public ResponseBody getAllPostname() {
        return ResponseBody.OK(postnamedService.getAllPostname());
    }

    @GetMapping(params = "id")
    public ResponseBody getIncomeById(@RequestParam Integer id) {
        return ResponseBody.OK(postnamedService.getById(id));
    }

    @GetMapping(params = {"page","limit"})
    public ResponseBody getIncomePage(@RequestParam Integer page,@RequestParam Integer limit) {
        return ResponseBody.OK(postnamedService.getBaseMapper().selectPage(new Page(page*limit-limit,limit),null).getRecords());
    }

    @PostMapping
    public ResponseBody saveIncomePage(Postnamed postnamed) {
        if(postnamedService.save(postnamed)){
            return ResponseBody.OK(postnamed.getTId());
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

    @PutMapping
    public ResponseBody updateIncome(Postnamed postnamed) {
        if(postnamedService.updateById(postnamed)){
            return ResponseBody.OK(null);
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

    @DeleteMapping
    public ResponseBody deleteIncomeById(@RequestParam Integer id) {
        if(postnamedService.removeById(id)){
            return ResponseBody.OK(null);
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

}

