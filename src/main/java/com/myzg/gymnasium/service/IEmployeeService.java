package com.myzg.gymnasium.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myzg.gymnasium.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.myzg.gymnasium.responsebody.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 员工表 服务类
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
public interface IEmployeeService extends IService<Employee> {
    ResponseBody findEmployeeByFuzzyQuery(Map<String, Object> map);
    ResponseBody findEmployeeByFuzzyQueryForCount(Map<String, Object> map);
}
