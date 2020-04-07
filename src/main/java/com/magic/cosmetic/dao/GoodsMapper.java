package com.magic.cosmetic.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.magic.cosmetic.bean.Goods;
import org.beetl.sql.core.annotatoin.Param;

import java.util.List;

/**
 * @author likang
 * @date 2020/3/15 12:05
 */
public interface GoodsMapper extends BaseMapper<Goods> {


    List<Goods> getListByCondition(@Param("brand") String brand, @Param("type") String type, @Param("effect") String effect);
}