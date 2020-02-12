package com.myzg.gymnasium.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.myzg.gymnasium.config.validate.Write;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 员工表
 * </p>
 *
 * @author myzg
 * @since 2020-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "employee", resultMap = "EmployeeFull")
public class Employee implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 表自增ID
     */
    @TableId(value = "o_id", type = IdType.AUTO)
    @Min(value = 1, groups = Write.class)
    private Integer oId;

    /**
     * 姓名
     */
    @NotBlank(groups = Write.class)
    private String name;

    /**
     * 性别
     */
    @NotBlank(groups = Write.class)
    private String sex;

    /**
     * 出生日期
     */
    @NotNull(groups = Write.class)
    private LocalDate birthday;

    /**
     * 生份证证件
     */
    @TableField("ID_number")
    @Length(min = 18,max = 18 , groups = Write.class)
    private String idNumber;

    /**
     * 婚姻状态
     */
    private String maritalStatus;

    /**
     * 民族ID
     */
    private Integer nationId;


    /**
     * 具体民族值
     */
    @TableField(exist = false)
    private Nation nation;


    /**
     * 政治面貌
     */
    private String politicsStatus;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 联系电话
     */
    @NotBlank(groups = Write.class)
    private String phone;

    /**
     * 联系地址
     */
    @NotBlank(groups = Write.class)
    private String adress;

    /**
     * 所属部门ID
     */
    @Min(value = 1,groups = Write.class)
    private Integer branchId;

    /**
     * 具体部门
     */
    @TableField(exist = false)
    private Branch branch;

    /**
     * 职位ID
     */
    @Min(value = 1,groups = Write.class)
    private Integer positionId;

    /**
     * 具体职称
     * */
    @TableField(exist = false)
    private Postnamed postnamed;

    /**
     * 基本工资
     */
    @DecimalMin(value = "1",groups = Write.class)
    private BigDecimal basicSalary;

    /**
     * 雇佣形式
     */
    @NotBlank(groups = Write.class)
    private String hireType;

    /**
     * 最高学历
     */
    private String education;

    /**
     * 毕业院校
     */
    private String school;

    /**
     * 专业
     */
    private String major;

    /**
     * 雇佣时间
     */
    @NotNull(groups = Write.class)
    private LocalDate hireTime;

    /**
     * 在职状态
     */
    private String workStatus;

    /**
     * 解雇时间
     */
    private LocalDate dimissionTime;

    /**
     * 合同起效时间
     */
    @NotNull(groups = Write.class)
    private LocalDate pactStart;

    /**
     * 合同结束时间
     */
    @NotNull(groups = Write.class)
    private LocalDate pactEnd;

    /**
     * 工龄
     */
    private Integer workAge;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 最后更改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;


}
