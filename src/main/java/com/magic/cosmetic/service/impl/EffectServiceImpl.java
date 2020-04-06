package com.magic.cosmetic.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.magic.cosmetic.bean.Effect;
import com.magic.cosmetic.dao.EffectMapper;
import com.magic.cosmetic.service.EffectService;

/**
 * @author likang
 * @date 2020/3/15 11:59
 */
@Service
public class EffectServiceImpl extends ServiceImpl<EffectMapper, Effect> implements EffectService {

}

