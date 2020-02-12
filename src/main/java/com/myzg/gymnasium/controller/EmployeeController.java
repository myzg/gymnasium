package com.myzg.gymnasium.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myzg.gymnasium.entity.Employee;
import com.myzg.gymnasium.exception.ErrorEnum;
import com.myzg.gymnasium.exception.ProgramException;
import com.myzg.gymnasium.responsebody.ResponseBody;
import com.myzg.gymnasium.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping
    public ResponseBody getTotalForEmployee() {
        return ResponseBody.OK(employeeService.getBaseMapper().selectCount(null));
    }

    @GetMapping(params = "id")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseBody getEmployeeById(@RequestParam Integer id) {
        return ResponseBody.OK(employeeService.getById(id));
    }

    @GetMapping(params = {"page","limit"})
    public ResponseBody getEmployeePage(@RequestParam Integer page,@RequestParam Integer limit) {
        return ResponseBody.OK(employeeService.getBaseMapper().selectPage(new Page<Employee>(page,limit), null).getRecords());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_BOSS')")
    public ResponseBody saveEmployee(@RequestBody Employee employee) {
        if(employeeService.save(employee)) {
            return ResponseBody.OK(employee.getOId());
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

    @DeleteMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_BOSS')")
    public ResponseBody deleteEmployeeById(Integer id) {
        if(employeeService.removeById(id)){
            return ResponseBody.OK(null);
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_BOSS')")
    public ResponseBody updateEmployee(@RequestBody Employee employee) {
        if(employeeService.updateById(employee)) {
            return ResponseBody.OK(null);
        }
        throw new ProgramException(ErrorEnum.SQL_FAILURE);
    }


}

