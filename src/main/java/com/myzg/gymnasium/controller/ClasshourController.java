package com.myzg.gymnasium.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myzg.gymnasium.entity.Classhour;
import com.myzg.gymnasium.exception.ErrorEnum;
import com.myzg.gymnasium.exception.ProgramException;
import com.myzg.gymnasium.responsebody.ResponseBody;
import com.myzg.gymnasium.service.impl.ClasshourServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 教练课时表 前端控制器
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@RestController
@RequestMapping("/classhour")
public class ClasshourController {

    @Autowired
    private ClasshourServiceImpl classhourService;

    @GetMapping(params = "id")
    public ResponseBody getClasshourById(@RequestParam Integer id) {
        return ResponseBody.OK(classhourService.getById(id));
    }

    @GetMapping(params = {"page","limit"})
    public ResponseBody getClasshourPage(@RequestParam Integer page,@RequestParam Integer limit) {
        return ResponseBody.OK(classhourService.getBaseMapper().selectPage(new Page(page*limit-limit,limit), null).getRecords());
    }

    @PostMapping
    public ResponseBody saveClasshour(Classhour classhour) {
        if(classhourService.save(classhour)){
            return ResponseBody.OK(null);
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

    @PutMapping
    public ResponseBody updateClasshour(Classhour classhour) {
        if(classhourService.updateById(classhour)){
            return ResponseBody.OK(null);
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

    @DeleteMapping
    public ResponseBody deleteClasshour(@RequestParam Integer id) {
        if(classhourService.removeById(id)){
            return ResponseBody.OK(null);
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }



}

