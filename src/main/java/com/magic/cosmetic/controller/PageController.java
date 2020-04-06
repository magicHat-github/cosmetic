package com.magic.cosmetic.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.magic.cosmetic.bean.*;
import com.magic.cosmetic.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import static com.magic.cosmetic.common.Constants.STATUS_TRUE;

/**
 * @author likang
 * 2020/3/6 22:37
 */
@Controller
public class PageController {

    private final GoodsService goodsService;
    private final GoodsTypeService goodsTypeService;
    private final GoodsBrandService goodsBrandService;
    private final GoodsEffectService goodsEffectService;
    private final CosmeticUserService cosmeticUserService;
    private final BrandService brandService;
    private final EffectService effectService;
    private final TypeService typeService;

    public PageController(BrandService brandService, EffectService effectService, TypeService typeService, CosmeticUserService cosmeticUserService, GoodsService goodsService, GoodsTypeService goodsTypeService, GoodsBrandService goodsBrandService, GoodsEffectService goodsEffectService) {
        this.brandService = brandService;
        this.effectService = effectService;
        this.typeService = typeService;
        this.cosmeticUserService = cosmeticUserService;
        this.goodsService = goodsService;
        this.goodsTypeService = goodsTypeService;
        this.goodsBrandService = goodsBrandService;
        this.goodsEffectService = goodsEffectService;
    }

    /**
     * 默认根目录跳转首页，重定向至index.html
     *
     * @return 结果
     */
    @GetMapping("/")
    public String rootPage() {
        return "redirect:index";
    }

    /**
     * 跳转至首页
     *
     * @param request 参数
     * @return 结果
     */
    @GetMapping("index")
    public String homePage(HttpServletRequest request) {
        return "index.html";
    }

    /**
     * 跳转至登录
     *
     * @param request 参数
     * @return 结果
     */
    @GetMapping("login")
    public String loginPage(HttpServletRequest request) {
        return "login.html";
    }

    /**
     * 跳转至注册
     *
     * @param request 参数
     * @return 结果
     */
    @GetMapping("register")
    public String register(HttpServletRequest request) {
        return "register.html";
    }


    @PostMapping("login")
    public String select(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
        CosmeticUser user = cosmeticUserService.getOne(Wrappers.<CosmeticUser>lambdaQuery().eq(CosmeticUser::getName, username).eq(CosmeticUser::getPassword, password).eq(CosmeticUser::getState, STATUS_TRUE));
        if (user != null) {
            request.getSession().setAttribute("user", user);
            return "redirect:index";
        }
        request.setAttribute("loginMessage", "用户名密码失败！");
        return "login.html";
    }

    @PostMapping("register")
    public String select(CosmeticUser user, HttpServletRequest request) {
        boolean save = false;
        if (user == null || StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getPassword()) || StringUtils.isEmpty(user.getEmail()) || StringUtils.isEmpty(user.getPhone())) {
            request.setAttribute("registerMessage", "注册信息不能为空，注册失败，请重新注册！");
        } else {
            CosmeticUser cosmeticUser = cosmeticUserService.getOne(Wrappers.<CosmeticUser>lambdaQuery().eq(CosmeticUser::getName, user.getName()));
            if (cosmeticUser != null) {
                request.setAttribute("registerMessage", "用户名已存在，注册失败，请重新注册！");
                return "register.html";
            }
            cosmeticUser = cosmeticUserService.getOne(Wrappers.<CosmeticUser>lambdaQuery().eq(CosmeticUser::getEmail, user.getEmail()));
            if (cosmeticUser != null) {
                request.setAttribute("registerMessage", "邮箱已存在，注册失败，请重新注册！");
                return "register.html";
            }
            cosmeticUser = cosmeticUserService.getOne(Wrappers.<CosmeticUser>lambdaQuery().eq(CosmeticUser::getPhone, user.getPhone()));
            if (cosmeticUser != null) {
                request.setAttribute("registerMessage", "手机号已存在，注册失败，请重新注册！");
                return "register.html";
            }
            user.setType(1);
            user.setLevel(1);
            save = cosmeticUserService.save(user);
        }
        if (save) {
            request.setAttribute("loginMessage", "注册成功！");
            return "redirect:login";
        }
        return "register.html";
    }


    /**
     * 业务处理
     */
    @GetMapping("singleProduct")
    public String singleProduct(@RequestParam(value = "id") String id,
                                HttpServletRequest request) {
        request.setAttribute("goods", goodsService.getById(id));
        List<GoodsBrand> brandList = goodsBrandService.list(Wrappers.<GoodsBrand>lambdaQuery().eq(GoodsBrand::getGoodsId, id));
        Set<String> brandIds = new HashSet<>();
        brandList.forEach(item -> brandIds.add(item.getBrandId()));
        List<GoodsType> typeList = goodsTypeService.list(Wrappers.<GoodsType>lambdaQuery().eq(GoodsType::getGoodsId, id));
        Set<String> typeIds = new HashSet<>();
        typeList.forEach(item -> typeIds.add(item.getTypeId()));
        List<GoodsEffect> effectList = goodsEffectService.list(Wrappers.<GoodsEffect>lambdaQuery().eq(GoodsEffect::getGoodsId, id));
        Set<String> effectIds = new HashSet<>();
        effectList.forEach(item -> effectIds.add(item.getEffectId()));
        if (!brandIds.isEmpty()) {
            request.setAttribute("brandList", brandService.list(Wrappers.<Brand>lambdaQuery().in(Brand::getId, brandIds)));
        }
        if (!typeIds.isEmpty()) {
            request.setAttribute("typeList", typeService.list(Wrappers.<Type>lambdaQuery().in(Type::getId, typeIds)));
        }
        if (!effectIds.isEmpty()) {
            request.setAttribute("effectList", effectService.list(Wrappers.<Effect>lambdaQuery().in(Effect::getId, effectIds)));
        }
        return "single-product.html";
    }

    @GetMapping("shopList")
    public String shopList(@RequestParam(value = "pageNum", defaultValue = "1") Integer currentPage,
                           @RequestParam(value = "pageSize", defaultValue = "3") Integer size,
                           @RequestParam(value = "brand", required = false) String brand,
                           @RequestParam(value = "type", required = false) String type,
                           @RequestParam(value = "effect", required = false) String effect,
                           HttpServletRequest request) {
        IPage<Goods> page = new Page<>(currentPage, size);
        LambdaQueryWrapper<Goods> lambdaQueryWrapper = Wrappers.lambdaQuery();
        Set<String> productIds = new HashSet<>();
        if (StringUtils.isEmpty(brand)) {
            List<GoodsBrand> brandList = goodsBrandService.list(Wrappers.<GoodsBrand>lambdaQuery().eq(GoodsBrand::getBrandId, brand));
            brandList.forEach(item -> productIds.add(item.getGoodsId()));
        }
        if (StringUtils.isEmpty(type)) {
            List<GoodsType> typeList = goodsTypeService.list(Wrappers.<GoodsType>lambdaQuery().eq(GoodsType::getTypeId, brand));
            typeList.forEach(item -> productIds.add(item.getGoodsId()));
        }
        if (StringUtils.isEmpty(effect)) {
            List<GoodsEffect> effectList = goodsEffectService.list(Wrappers.<GoodsEffect>lambdaQuery().eq(GoodsEffect::getEffectId, brand));
            effectList.forEach(item -> productIds.add(item.getGoodsId()));
        }
        if (!productIds.isEmpty()) {
            lambdaQueryWrapper.in(Goods::getId, productIds);
        }
        lambdaQueryWrapper.eq(Goods::getState, STATUS_TRUE);
        lambdaQueryWrapper.orderByDesc(Goods::getUpdatedTime);
        request.setAttribute("goodsList", goodsService.page(page, lambdaQueryWrapper));
        request.setAttribute("brandList", brandService.list(Wrappers.<Brand>lambdaQuery()
                .eq(Brand::getState, STATUS_TRUE)
                .orderByDesc(Brand::getTop)));
        request.setAttribute("effectList", effectService.list(Wrappers.<Effect>lambdaQuery()
                .eq(Effect::getState, STATUS_TRUE)
                .orderByDesc(Effect::getTop)));
        request.setAttribute("typeList", typeService.list(Wrappers.<Type>lambdaQuery()
                .eq(Type::getState, STATUS_TRUE)
                .orderByDesc(Type::getTop)));
        return "shop-list.html";
    }

    @GetMapping("api/addCart/{id}")
    public String addCart(@PathVariable String id, @RequestParam String redirect, HttpServletRequest request) {
        List<Goods> goodsList = (List<Goods>) request.getSession().getAttribute("cart");
        if (goodsList == null){
            goodsList = new ArrayList<>();
        }
        AtomicBoolean exist = new AtomicBoolean(false);
        goodsList.forEach(item -> {
            if (item.getId().equals(id)){
                exist.set(true);
                item.setNumber(item.getNumber() + 1);
            }
        });
        if (!exist.get()){
            Goods goods = goodsService.getById(id);
            goods.setNumber(1L);
            goodsList.add(goods);
        }
        String totalMoney = "0.00";
        if (!goodsList.isEmpty()){
            for (Goods item : goodsList) {
                totalMoney = String.valueOf(item.getPrice().multiply(BigDecimal.valueOf(item.getNumber())));
            }
        }
        request.getSession().setAttribute("totalMoney", totalMoney);
        request.getSession().setAttribute("cart", goodsList);
        return "redirect:" + redirect;
    }

    @GetMapping("api/deleteCart/{id}")
    public String deleteCart(@PathVariable String id, @RequestParam String redirect,  HttpServletRequest request) {
        List<Goods> goodsList = (List<Goods>) request.getSession().getAttribute("cart");
        if (goodsList == null){
            goodsList = new ArrayList<>();
        }
        List<Goods> list = new ArrayList<>(goodsList);
        for (Goods goods : list) {
            if (goods.getId().equals(id)){
                goodsList.remove(goods);
            }
        }
        String totalMoney = "0.00";
        if (!goodsList.isEmpty()){
            for (Goods item : goodsList) {
                totalMoney = String.valueOf(item.getPrice().multiply(BigDecimal.valueOf(item.getNumber())));
            }
        }
        request.getSession().setAttribute("totalMoney", totalMoney);
        request.getSession().setAttribute("cart", goodsList);
        return "redirect:" + redirect;
    }

    @GetMapping("about")
    public String about(HttpServletRequest request) {
        return "about.html";
    }

    @GetMapping("account")
    public String account(HttpServletRequest request) {
        return "account.html";
    }

    @GetMapping("cart")
    public String cart(HttpServletRequest request) {
        return "cart.html";
    }

    @GetMapping("layout/header/brand")
    public String headerBrand(HttpServletRequest request) {
        request.setAttribute("brandList", brandService.list(Wrappers.<Brand>lambdaQuery()
                .eq(Brand::getState, STATUS_TRUE)
                .orderByDesc(Brand::getTop)));
        return "page/layout.html#brandListMode";
    }

    @GetMapping("layout/header/effect")
    public String headerEffect(HttpServletRequest request) {
        request.setAttribute("effectList", effectService.list(Wrappers.<Effect>lambdaQuery()
                .eq(Effect::getState, STATUS_TRUE)
                .orderByDesc(Effect::getTop)));
        return "page/layout.html#effectListMode";
    }

    @GetMapping("layout/header/type")
    public String headerType(HttpServletRequest request) {
        request.setAttribute("typeList", typeService.list(Wrappers.<Type>lambdaQuery()
                .eq(Type::getState, STATUS_TRUE)
                .orderByDesc(Type::getTop)));
        return "page/layout.html#typeListMode";
    }
}
