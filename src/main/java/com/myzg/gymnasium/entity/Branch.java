package com.myzg.gymnasium.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.myzg.gymnasium.config.validate.Write;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "branch")
public class Branch implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 部门ID
     */
    @TableId(value = "t_id", type = IdType.AUTO)
    @Min(value = 1, groups = Write.class)
    @NotNull(groups = Write.class)
    private Integer tId;

    /**
     * 部门名称
     */
    @NotEmpty(groups = {Write.class})
    private String named;


}
