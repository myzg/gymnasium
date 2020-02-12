package com.myzg.gymnasium.service;

import com.myzg.gymnasium.entity.Nation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 民族表 服务类
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
public interface INationService extends IService<Nation> {

    List<Nation> getAllNation ();

}
