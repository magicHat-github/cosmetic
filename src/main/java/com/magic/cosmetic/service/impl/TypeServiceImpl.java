package com.magic.cosmetic.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.magic.cosmetic.dao.TypeMapper;
import com.magic.cosmetic.bean.Type;
import com.magic.cosmetic.service.TypeService;

/**
 * @author likang
 * @date 2020/3/15 11:59
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {

}

