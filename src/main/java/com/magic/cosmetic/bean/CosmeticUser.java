package com.magic.cosmetic.bean;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import lombok.Data;

/**
 * 
 * @author likang
 * @date 2020/3/15 12:05
 */
@Data
@TableName(value = "cosmetic_user")
public class CosmeticUser {
    /**
     * 用户主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 用户名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 用户类型
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 用户级别
     */
    @TableField(value = "level")
    private Integer level;

    /**
     * 用户密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 用户头像
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 用户邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 手机号
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 状态（0：禁用，1：启用）
     */
    @TableField(value = "status", fill = FieldFill.INSERT)
    private Boolean state;

    /**
     * 创建人
     */
    @TableField(value = "created_by", fill = FieldFill.INSERT)
    private String createdBy;

    /**
     * 创建时间
     */
    @TableField(value = "created_time", fill = FieldFill.INSERT)
    private Date createdTime;

    /**
     * 修改人
     */
    @TableField(value = "updated_by", fill = FieldFill.INSERT_UPDATE)
    private String updatedBy;

    /**
     * 修改时间
     */
    @TableField(value = "updated_time", fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;
}