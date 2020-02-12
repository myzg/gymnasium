package com.myzg.gymnasium.service.impl;

import com.myzg.gymnasium.entity.Nation;
import com.myzg.gymnasium.mapper.NationMapper;
import com.myzg.gymnasium.service.INationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 民族表 服务实现类
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@Service
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements INationService {

    @Override
    public List<Nation> getAllNation() {
        return getBaseMapper().getAllNation();
    }
}
