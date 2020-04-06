package com.magic.cosmetic.bean;

import com.baomidou.mybatisplus.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @author likang
 * @date 2020/3/15 12:05
 */
@Data
@TableName(value = "goods")
public class Goods {
    /**
     * 商品主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 商品名词
     */
    @TableField(value = "name")
    private String name;

    /**
     * 价格
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 图片地址
     */
    @TableField(value = "images")
    private String images;

    /**
     * 产品分析
     */
    @TableField(value = "product_analysis")
    private String productAnalysis;

    /**
     * 试用皮肤
     */
    @TableField(value = "skin_type")
    private String skinType;

    /**
     * 品牌
     */
    @TableField(value = "brand")
    private String brand;

    /**
     * 规格
     */
    @TableField(value = "standard")
    private String standard;

    /**
     * 系列名
     */
    @TableField(value = "series_name")
    private String seriesName;

    /**
     * 上市时间
     */
    @TableField(value = "up_time")
    private Date upTime;

    /**
     * 已售数量
     */
    @TableField(value = "number")
    private Long number;

    /**
     * 描述
     */
    @TableField(value = "remake")
    private String remake;

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