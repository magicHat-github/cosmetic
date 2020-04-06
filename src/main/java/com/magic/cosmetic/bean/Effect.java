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
@TableName(value = "effect")
public class Effect {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 描述
     */
    @TableField(value = "remake")
    private String remake;

    /**
     * 推荐程度（数值越高，推荐程度越高）
     */
    @TableField(value = "top")
    private Integer top;

    /**
     * 状态（0：禁用，1：启用）
     */
    @TableField(value = "state", fill = FieldFill.INSERT)
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