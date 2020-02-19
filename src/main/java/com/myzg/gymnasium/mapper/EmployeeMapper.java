package com.myzg.gymnasium.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myzg.gymnasium.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 员工表 Mapper 接口
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

    @Transactional(readOnly = true, rollbackFor = {SQLException.class}, propagation = Propagation.REQUIRED)
    Employee findEmployeeById(Integer id);

    @Transactional(readOnly = true, rollbackFor = {SQLException.class}, propagation = Propagation.REQUIRED)
    List<Employee> findEmployeeByPage(Integer page, Integer limit);

    @Transactional(readOnly = true, rollbackFor = {SQLException.class}, propagation = Propagation.REQUIRED)
    IPage<Employee> findEmployeeByFuzzyQuery(Page<Employee> page, @Param("requestParams") Map<String, Object> map);

    @Transactional(readOnly = true, rollbackFor = {SQLException.class}, propagation = Propagation.REQUIRED)
    int findEmployeeByFuzzyQueryForCount(@Param("requestParams") Map<String, Object> map);

}
