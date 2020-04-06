package com.magic.cosmetic.controller.rest;

import com.magic.cosmetic.bean.Brand;
import com.magic.cosmetic.bean.Effect;
import com.magic.cosmetic.common.AjaxResult;
import com.magic.cosmetic.service.BrandService;
import com.magic.cosmetic.service.EffectService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author likang
 * @date 2020/3/15 12:08
 */
@RestController
@RequestMapping("rest/api/effect")
public class EffectController {

    @Resource
    private EffectService effectService;

    @GetMapping
    public AjaxResult select(@RequestParam String id) {
        Effect effect = effectService.getById(id);
        return StringUtils.isEmpty(id) ? AjaxResult.error() : effect != null ? AjaxResult.success("查找成功", effect) : AjaxResult.error();
    }

    @PostMapping
    public AjaxResult save(@RequestBody Effect effect) {
        boolean save = effectService.save(effect);
        return effect != null ? save ? AjaxResult.success() : AjaxResult.error() : AjaxResult.error();
    }

    @PutMapping
    public AjaxResult update(@RequestBody Effect effect) {
        boolean update = effectService.updateById(effect);
        return effect != null ? update ? AjaxResult.success() : AjaxResult.error() : AjaxResult.error();
    }

    @DeleteMapping
    public AjaxResult delete(@RequestParam String id) {
        boolean update = effectService.removeById(id);
        return StringUtils.isEmpty(id) ? AjaxResult.error() : update ? AjaxResult.success() : AjaxResult.error();
    }
}
