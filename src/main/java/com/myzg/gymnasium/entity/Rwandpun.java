package com.myzg.gymnasium.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 员工奖罚表
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "rwandpun")
public class Rwandpun implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 表自增ID
     */
    @TableId(value = "t_id", type = IdType.AUTO)
    private Integer tId;

    /**
     * 员工ID
     */
    private Integer oId;

    /**
     * 奖罚原因
     */
    private String reson;

    /**
     * 奖罚时间
     */
    private LocalDateTime time;

    /**
     * 奖罚分值
     */
    private Integer point;

    /**
     * 奖罚类别
     */
    private String type;

    /**
     * 备注
     */
    private String remark;


}
