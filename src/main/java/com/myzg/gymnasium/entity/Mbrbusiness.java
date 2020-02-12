package com.myzg.gymnasium.entity;

import java.math.BigDecimal;
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
 * 会员业务表
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "mbrbusiness")
public class Mbrbusiness implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 表自增ID
     */
    @TableId(value = "t_id", type = IdType.AUTO)
    private Integer tId;

    /**
     * 会员ID
     */
    private Integer uId;

    /**
     * 业务ID
     */
    private Integer businessId;

    /**
     * 业务开始时间
     */
    private LocalDateTime startTime;

    /**
     * 业务结束时间
     */
    private LocalDateTime endTime;

    /**
     * 订单编号
     */
    private String identUnmber;

    /**
     * 支付金额
     */
    private BigDecimal pay;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
