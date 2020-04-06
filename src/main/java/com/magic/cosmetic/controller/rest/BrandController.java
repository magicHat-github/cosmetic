package com.magic.cosmetic.controller.rest;

import com.magic.cosmetic.bean.Brand;
import com.magic.cosmetic.common.AjaxResult;
import com.magic.cosmetic.service.BrandService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author likang
 * @date 2020/3/15 12:08
 */
@RestController
@RequestMapping("rest/api/brand")
public class BrandController {

    @Resource
    private BrandService brandService;

    @GetMapping
    public AjaxResult select(@RequestParam String id) {
        Brand brand = brandService.getById(id);
        return StringUtils.isEmpty(id) ? AjaxResult.error() : brand != null ? AjaxResult.success  ("查找成功", brand) : AjaxResult.error();
    }

    @PostMapping
    public AjaxResult save(@RequestBody Brand brand) {
        boolean save = brandService.save(brand);
        return brand != null ? save ? AjaxResult.success() : AjaxResult.error() : AjaxResult.error();
    }

    @PutMapping
    public AjaxResult update(@RequestBody Brand brand) {
        boolean update = brandService.updateById(brand);
        return brand != null ? update ? AjaxResult.success() : AjaxResult.error() : AjaxResult.error();
    }

    @DeleteMapping
    public AjaxResult delete(@RequestParam String id) {
        boolean update = brandService.removeById(id);
        return StringUtils.isEmpty(id) ? AjaxResult.error() : update ? AjaxResult.success() : AjaxResult.error();
    }
}
