package com.myzg.gymnasium.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.myzg.gymnasium.config.validate.Write;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 支出表
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "expenditure")
public class Expenditure implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 表自增ID
     */
    @TableId(value = "t_id", type = IdType.AUTO)
    @Min(value = 1,groups = Write.class)
    private Integer tId;

    /**
     * 支付类型
     */
    @NotBlank(groups = Write.class)
    private String payType;

    /**
     * 付款人
     */
    @NotBlank(groups = Write.class)
    private String payer;

    /**
     * 金额
     */
    @DecimalMin(value = "0",groups = Write.class)
    private BigDecimal money;

    /**
     * 支付时间
     */
    @NotNull(groups = Write.class)
    private LocalDateTime payTime;

    /**
     * 支付原因
     */

    private String payReason;

    /**
     * 备注
     */
    private String remark;


}
