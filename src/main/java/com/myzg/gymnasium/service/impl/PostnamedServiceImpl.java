package com.myzg.gymnasium.service.impl;

import com.myzg.gymnasium.entity.Postnamed;
import com.myzg.gymnasium.mapper.PostnamedMapper;
import com.myzg.gymnasium.service.IPostnamedService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 职称表 服务实现类
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@Service
public class PostnamedServiceImpl extends ServiceImpl<PostnamedMapper, Postnamed> implements IPostnamedService {

    @Override
    public List<Postnamed> getAllPostname() {
        return getBaseMapper().getAllPostname();
    }
}
