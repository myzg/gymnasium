package com.myzg.gymnasium.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myzg.gymnasium.entity.Employee;
import com.myzg.gymnasium.exception.ErrorEnum;
import com.myzg.gymnasium.exception.ProgramException;
import com.myzg.gymnasium.mapper.EmployeeMapper;
import com.myzg.gymnasium.responsebody.ResponseBody;
import com.myzg.gymnasium.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@Service
@Slf4j
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {
    @Override
    public ResponseBody findEmployeeByFuzzyQuery(Map<String, Object> map) {
        int page = -1;
        int limit = -1;
        try {
            page =  Integer.parseInt(map.get("page").toString());
            limit = Integer.parseInt(map.get("limit").toString());
        }catch(Exception e) {
            log.error("转换异常[{}]", e.getMessage());
            throw new ProgramException(ErrorEnum.ILLEGAL_ARGS);
        }
        return ResponseBody.OK(getBaseMapper().findEmployeeByFuzzyQuery(new Page<Employee>(page,limit),map).getRecords());
    }

    @Override
    public ResponseBody findEmployeeByFuzzyQueryForCount(Map<String, Object> map) {
        return ResponseBody.OK(getBaseMapper().findEmployeeByFuzzyQueryForCount(map));
    }
}
