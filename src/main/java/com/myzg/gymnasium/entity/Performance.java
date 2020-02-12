package com.myzg.gymnasium.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 业绩表
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "performance")
public class Performance implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 表自增ID
     */
    @TableId(value = "t_id", type = IdType.AUTO)
    private Integer tId;

    /**
     * 业务成交日期
     */
    private LocalDate date;

    /**
     * 业务办理员ID
     */
    private Integer oId;

    /**
     * 业务类型ID
     */
    private Integer busId;

    /**
     * 办理部门ID
     */
    private Integer branchId;

    /**
     * 职称ID
     */
    private Integer postId;

    /**
     * 金额
     */
    private BigDecimal money;

    /**
     * 办理人数
     */
    private Integer count;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 单据编号
     */
    private String docNumber;

    /**
     * 办理客户姓名
     */
    private String customerName;

    /**
     * 客户电话
     */
    private String customerPhone;

    /**
     * 备注
     */
    private String remark;


}
