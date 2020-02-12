package com.myzg.gymnasium.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.myzg.gymnasium.config.validate.Write;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 会员锻炼表
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "exerciserecord")
public class Exerciserecord implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 表自增id
     */
    @Min(value = 1,groups = Write.class)
    @TableId(value = "t_id",type = IdType.AUTO)
    private Integer tId;

    /**
     * 会员ID
     */
    @Min(value = 1,groups = Write.class)
    private Integer uId;

    /**
     * 业务类型ID
     */
    @Min(value = 1,groups = Write.class)
    private Integer businessId;

    /**
     * 锻炼开始时间
     */
    @NotNull(groups = Write.class)
    private LocalDateTime startTime;


}
