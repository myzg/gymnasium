package com.myzg.gymnasium.mapper;

import com.myzg.gymnasium.entity.Mbrbasic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * <p>
 * 会员基础信息表 Mapper 接口
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@Mapper
public interface MbrbasicMapper extends BaseMapper<Mbrbasic> {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SQLException.class})
    Mbrbasic findMbrBasicById(Integer id);

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SQLException.class})
    List<Mbrbasic> findMbrBasicPage(Integer page, Integer limit);

}
