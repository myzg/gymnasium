package com.myzg.gymnasium.service;

import com.myzg.gymnasium.entity.Postnamed;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 职称表 服务类
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
public interface IPostnamedService extends IService<Postnamed> {

    public List<Postnamed> getAllPostname();

}
