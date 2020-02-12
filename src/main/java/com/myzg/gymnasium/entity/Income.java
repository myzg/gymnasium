package com.myzg.gymnasium.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.myzg.gymnasium.config.validate.Write;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 收入表
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "income")
public class Income implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 表自增ID
     */
    @Min(value = 1,groups = Write.class)
    @TableId(value = "t_id",type = IdType.AUTO)
    private Integer tId;

    /**
     * 业务类型ID
     */
    @Min(value = 1,groups = Write.class)
    private Integer typeId;

    /**
     * 收款人
     */
    @NotBlank(groups = Write.class)
    private String receiver;

    /**
     * 金额
     */
    @DecimalMin(value = "0",groups = Write.class)
    private BigDecimal money;

    /**
     * 支付者姓名
     */
    @NotBlank(groups = Write.class)
    private String payer;

    /**
     * 支付时间
     */
    @NotNull(groups = Write.class)
    private LocalDateTime payTime;

    /**
     * 支付类型
     */
    @NotBlank(groups = Write.class)
    private String payType;

    /**
     * 办理人员ID
     */
    @Min(value = 1, groups = Write.class)
    private Integer officeId;

    /**
     * 业务办理人员所属部门
     */
    @Min(value = 1,groups = Write.class)
    private Integer officeBranch;


}
