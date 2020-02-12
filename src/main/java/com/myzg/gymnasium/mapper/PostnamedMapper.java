package com.myzg.gymnasium.mapper;

import com.myzg.gymnasium.entity.Postnamed;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * <p>
 * 职称表 Mapper 接口
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@Mapper
public interface PostnamedMapper extends BaseMapper<Postnamed> {

    @Transactional(readOnly = true, rollbackFor = {SQLException.class}, propagation = Propagation.REQUIRED)
    Postnamed getPostnamedById(Integer id);

    @Transactional(readOnly = true, rollbackFor = {SQLException.class}, propagation = Propagation.REQUIRED)
    List<Postnamed> getAllPostname();

}
