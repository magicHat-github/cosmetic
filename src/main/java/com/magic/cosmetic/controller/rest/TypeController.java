package com.magic.cosmetic.controller.rest;

import com.magic.cosmetic.bean.Brand;
import com.magic.cosmetic.bean.Type;
import com.magic.cosmetic.common.AjaxResult;
import com.magic.cosmetic.service.BrandService;
import com.magic.cosmetic.service.TypeService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author likang
 * @date 2020/3/15 12:08
 */
@RestController
@RequestMapping("rest/api/type")
public class TypeController {

    @Resource
    private TypeService typeService;

    @GetMapping
    public AjaxResult select(@RequestParam String id) {
        Type type = typeService.getById(id);
        return StringUtils.isEmpty(id) ? AjaxResult.error() : type != null ? AjaxResult.success("查找成功", type) : AjaxResult.error();
    }

    @PostMapping
    public AjaxResult save(@RequestBody Type type) {
        boolean save = typeService.save(type);
        return type != null ? save ? AjaxResult.success() : AjaxResult.error() : AjaxResult.error();
    }

    @PutMapping
    public AjaxResult update(@RequestBody Type type) {
        boolean update = typeService.updateById(type);
        return type != null ? update ? AjaxResult.success() : AjaxResult.error() : AjaxResult.error();
    }

    @DeleteMapping
    public AjaxResult delete(@RequestParam String id) {
        boolean update = typeService.removeById(id);
        return StringUtils.isEmpty(id) ? AjaxResult.error() : update ? AjaxResult.success() : AjaxResult.error();
    }
}
