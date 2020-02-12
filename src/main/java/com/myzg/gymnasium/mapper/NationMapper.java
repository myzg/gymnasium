package com.myzg.gymnasium.mapper;

import com.myzg.gymnasium.entity.Nation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * <p>
 * 民族表 Mapper 接口
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@Mapper
public interface NationMapper extends BaseMapper<Nation> {
    @Transactional(readOnly = true, rollbackFor = {SQLException.class}, propagation = Propagation.REQUIRED)
    Nation getNationById(Integer id);

    @Transactional(readOnly = true, rollbackFor = {SQLException.class}, propagation = Propagation.REQUIRED)
    List<Nation> getAllNation();


}
