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
@TableName(value = "goods_brand")
public class GoodsBrand {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 商品主键
     */
    @TableField(value = "goods_id")
    private String goodsId;

    /**
     * 品牌主键
     */
    @TableField(value = "brand_id")
    private String brandId;
}