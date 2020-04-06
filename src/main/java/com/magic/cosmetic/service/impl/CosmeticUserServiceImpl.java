package com.magic.cosmetic.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.magic.cosmetic.dao.CosmeticUserMapper;
import com.magic.cosmetic.bean.CosmeticUser;
import com.magic.cosmetic.service.CosmeticUserService;

/**
 * @author likang
 * @date 2020/3/15 11:59
 */
@Service
public class CosmeticUserServiceImpl extends ServiceImpl<CosmeticUserMapper, CosmeticUser> implements CosmeticUserService {

}

