package com.magic.cosmetic.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.magic.cosmetic.bean.GoodsType;
import com.magic.cosmetic.dao.GoodsTypeMapper;
import com.magic.cosmetic.service.GoodsTypeService;

/**
 * @author likang
 * @date 2020/3/15 11:59
 */
@Service
public class GoodsTypeServiceImpl extends ServiceImpl<GoodsTypeMapper, GoodsType> implements GoodsTypeService {

}

