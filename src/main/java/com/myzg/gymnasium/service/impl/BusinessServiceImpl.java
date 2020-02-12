package com.myzg.gymnasium.service.impl;

import com.myzg.gymnasium.entity.Business;
import com.myzg.gymnasium.mapper.BusinessMapper;
import com.myzg.gymnasium.service.IBusinessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业务类型表 服务实现类
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements IBusinessService {

}
