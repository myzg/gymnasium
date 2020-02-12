package com.myzg.gymnasium.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.myzg.gymnasium.config.validate.Write;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 会员基础信息表
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "mbrbasic",resultMap = "MbrbasicFull")
public class Mbrbasic implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 会员ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @Min(value = 1,groups = Write.class)
    private Integer id;

    /**
     * 姓名
     */
    @NotBlank(groups = Write.class)
    private String uName;

    /**
     * 年龄
     */
    @Min(value = 1,groups = Write.class)
    private Integer uAge;

    /**
     * 出生日期
     */
    @NotNull(groups = Write.class)
    private LocalDate uBirthday;

    /**
     * 性别
     */
    @NotBlank(groups = Write.class)
    private String uSex;

    /**
     * 生份证证件号
     */
    @Length(min = 18,max = 18,groups = Write.class)
    private String uIdcard;

    /**
     * 联系电话
     */
    @Length(min = 11,max = 11,groups = Write.class)
    private String uPhone;

    /**
     * 联系地址
     */
    @NotBlank(groups = Write.class)
    private String uAdress;

    /**
     * 民族ID
     */
    @Min(value = 1,groups = Write.class)
    private Integer nation;

    /**
     * 具体民族
     * */
    @TableField(exist = false)
    private Nation theNation;

    /**
     * 第二联系人电话
     */
    @Length(min = 11,max = 11,groups = Write.class)
    private String uFamilyphone;

    /**
     * QQ
     */
    private String uQq;

    /**
     * 微信
     */
    private String uWechat;

    /**
     * 加入时间
     */
    private LocalDateTime createTime;

    /**
     * 最后修改时间
     */
    private LocalDateTime updateTime;


}
