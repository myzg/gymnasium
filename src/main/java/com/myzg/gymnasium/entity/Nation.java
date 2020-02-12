package com.myzg.gymnasium.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 民族表
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "nation")
public class Nation implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 名族ID
     */
    @TableId(value = "n_id", type = IdType.AUTO)
    private Integer nId;

    /**
     * 名称
     */
    private String named;


}
