package com.myzg.gymnasium.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myzg.gymnasium.entity.Business;
import com.myzg.gymnasium.exception.ErrorEnum;
import com.myzg.gymnasium.exception.ProgramException;
import com.myzg.gymnasium.responsebody.ResponseBody;
import com.myzg.gymnasium.service.impl.BusinessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 业务类型表 前端控制器
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessServiceImpl businessService;

    @GetMapping(params = "id")
    public ResponseBody getBusinessById(@RequestParam Integer id) {
        return ResponseBody.OK(businessService.getById(id));
    }

    @GetMapping(params = {"page","limit"})
    public ResponseBody getBusinessPage(@RequestParam Integer page, @RequestParam Integer limit) {
        return ResponseBody.OK(businessService.getBaseMapper().selectPage(new Page(page*limit-limit,limit), null).getRecords());
    }

    @PostMapping
    public ResponseBody saveBusiness(Business business) {
        if(businessService.save(business)){
            return ResponseBody.OK(business.getTId());
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

    @PutMapping
    public ResponseBody updateBusiness(Business business) {
        if(businessService.updateById(business)){
            return ResponseBody.OK(null);
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

    @DeleteMapping
    public ResponseBody deleteBusinessById(@RequestParam Integer id) {
        if(businessService.removeById(id)){
            return ResponseBody.OK(null);
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

}

