package com.magic.cosmetic.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.magic.cosmetic.dao.BrandMapper;
import com.magic.cosmetic.bean.Brand;
import com.magic.cosmetic.service.BrandService;

/**
 * @author likang
 * @date 2020/3/15 11:59
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

}

