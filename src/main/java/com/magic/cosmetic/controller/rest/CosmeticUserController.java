package com.magic.cosmetic.controller.rest;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.magic.cosmetic.bean.Brand;
import com.magic.cosmetic.bean.CosmeticUser;
import com.magic.cosmetic.common.AjaxResult;
import com.magic.cosmetic.service.BrandService;
import com.magic.cosmetic.service.CosmeticUserService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author likang
 * @date 2020/3/15 12:08
 */
@RestController
@RequestMapping("rest/api/user")
public class CosmeticUserController {

    @Resource
    private CosmeticUserService cosmeticUserService;

    @GetMapping
    public AjaxResult select(@RequestParam String id) {
        CosmeticUser user = cosmeticUserService.getById(id);
        return StringUtils.isEmpty(id) ? AjaxResult.error() : user != null ? AjaxResult.success  ("查找成功", user) : AjaxResult.error();
    }

    @PostMapping
    public AjaxResult save(@RequestBody CosmeticUser user) {
        boolean save = cosmeticUserService.save(user);
        return user != null ? save ? AjaxResult.success() : AjaxResult.error() : AjaxResult.error();
    }

    @PutMapping
    public AjaxResult update(@RequestBody CosmeticUser user) {
        boolean update = cosmeticUserService.updateById(user);
        return user != null ? update ? AjaxResult.success() : AjaxResult.error() : AjaxResult.error();
    }

    @DeleteMapping
    public AjaxResult delete(@RequestParam String id) {
        boolean update = cosmeticUserService.removeById(id);
        return StringUtils.isEmpty(id) ? AjaxResult.error() : update ? AjaxResult.success() : AjaxResult.error();
    }
}
