package com.myzg.gymnasium.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.myzg.gymnasium.config.validate.Write;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.*;

/**
 * <p>
 * 业务类型表
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "business")
public class Business implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 业务ID
     */
    @TableId(value = "t_id", type = IdType.AUTO)
    private Integer tId;

    /**
     * 业务名称
     */
    @NotBlank(groups = Write.class)
    private String typeName;

    /**
     * 价格
     */
    @NotNull(groups = Write.class)
    @DecimalMin(value = "0",groups = Write.class)
    private BigDecimal price;

    /**
     * 折扣
     */
    private Double discount;

    /**
     * 开始时间
     */
    @NotNull(groups = Write.class)
    private LocalDate startTime;

    /**
     * 结束时间
     */
    @NotNull(groups = Write.class)
    private LocalDate endTime;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后更改时间
     */
    private LocalDateTime updateTime;

    /**
     * 插入数据人员ID
     */
    private Integer insertId;

    /**
     * 更新人员ID
     */
    @Min(value = 1,groups = Write.class)
    private Integer updateId;


}
