package com.myzg.gymnasium.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myzg.gymnasium.entity.Exerciserecord;
import com.myzg.gymnasium.exception.ErrorEnum;
import com.myzg.gymnasium.exception.ProgramException;
import com.myzg.gymnasium.responsebody.ResponseBody;
import com.myzg.gymnasium.service.impl.ExerciserecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 会员锻炼表 前端控制器
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@RestController
@RequestMapping("/exerciserecord")
public class ExerciserecordController {

    @Autowired
    private ExerciserecordServiceImpl exerciserecordService;

    @GetMapping(params = "id")
    public ResponseBody getRecord(@RequestParam Integer id) {
        return ResponseBody.OK(exerciserecordService.getById(id));
    }

    @GetMapping(params = {"page","limit"})
    public ResponseBody getRecordPage(@RequestParam Integer page, @RequestParam Integer limit) {
        return ResponseBody.OK(exerciserecordService.getBaseMapper().selectPage(new Page(page*limit-limit,limit),null).getRecords());
    }

    @PostMapping
    public ResponseBody saveRecord(Exerciserecord exerciserecord) {
        if(exerciserecordService.save(exerciserecord)){
            return ResponseBody.OK(exerciserecord.getTId());
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

    @DeleteMapping
    public ResponseBody deleteRecordById(@RequestParam Integer id) {
        if(exerciserecordService.removeById(id)){
            return ResponseBody.OK(null);
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

    @PutMapping
    public ResponseBody updateRecord(Exerciserecord exerciserecord) {
        if(exerciserecordService.updateById(exerciserecord)){
            return ResponseBody.OK(null);
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

}

