package com.magic.cosmetic.service;

import com.magic.cosmetic.bean.Goods;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author likang
 * @date 2020/3/15 11:59
 */
public interface GoodsService extends IService<Goods> {


    List<Goods> getListByCondition(String brand, String type, String effect);
}

