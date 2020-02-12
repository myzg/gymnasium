package com.myzg.gymnasium.service.impl;

import com.myzg.gymnasium.entity.Employee;
import com.myzg.gymnasium.mapper.EmployeeMapper;
import com.myzg.gymnasium.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
