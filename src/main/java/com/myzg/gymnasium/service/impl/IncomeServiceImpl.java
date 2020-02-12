package com.myzg.gymnasium.service.impl;

import com.myzg.gymnasium.entity.Income;
import com.myzg.gymnasium.mapper.IncomeMapper;
import com.myzg.gymnasium.service.IIncomeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 收入表 服务实现类
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@Service
public class IncomeServiceImpl extends ServiceImpl<IncomeMapper, Income> implements IIncomeService {

}
