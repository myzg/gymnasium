package com.myzg.gymnasium.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.myzg.gymnasium.config.validate.Write;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 教练课时表
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "classhour")
public class Classhour implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 表自增ID
     */
    @TableId(value = "t_id", type = IdType.AUTO)
    @Min(value = 1,groups = Write.class)
    private Integer tId;

    /**
     * 教练ID
     */
    @Min(value = 1,groups = Write.class)
    private Integer coachId;

    /**
     * 开始时间
     */
    @NotNull(groups = Write.class)
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @NotNull(groups = Write.class)
    private LocalDateTime endTime;

    /**
     * 会员ID
     */
    @Min(value = 1,groups = Write.class)
    private Integer uId;

    /**
     * 地点
     */
    private String site;

    /**
     * 客户评价
     */
    private String uEvaluate;


}
