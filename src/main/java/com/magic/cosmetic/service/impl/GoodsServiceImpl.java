package com.magic.cosmetic.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.magic.cosmetic.dao.GoodsMapper;
import com.magic.cosmetic.bean.Goods;
import com.magic.cosmetic.service.GoodsService;

/**
 * @author likang
 * @date 2020/3/15 11:59
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

}

