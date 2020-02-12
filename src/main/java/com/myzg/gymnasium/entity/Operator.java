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
 * 操作员表
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "operator")
public class Operator implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 操作员表自增ID
     */
    @TableId(value = "t_id", type = IdType.AUTO)
    private Integer tId;

    /**
     * 操作员权限
     */
    private String authority;

    /**
     * 备注
     */
    private String remark;

    /**
     * 操作员工号
     */
    private Integer oId;

    /**
     * BCrypt密码
     */
    private String password;


}
