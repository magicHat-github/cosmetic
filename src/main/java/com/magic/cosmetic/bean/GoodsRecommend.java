package com.magic.cosmetic.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @author likang
 * @date 2020/3/15 12:05
 */
@Data
@TableName(value = "goods_recommend")
public class GoodsRecommend {
    /**
     * 推荐主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    /**
     * 商品主键
     */
    @TableField(value = "goods")
    private Long goods;

    /**
     * 点赞数量
     */
    @TableField(value = "like")
    private Integer like;

    /**
     * 讨厌数量
     */
    @TableField(value = "hate")
    private Long hate;

    /**
     * 点击数量
     */
    @TableField(value = "click")
    private Integer click;

    /**
     * 推荐级别
     */
    @TableField(value = "level")
    private Integer level;
}