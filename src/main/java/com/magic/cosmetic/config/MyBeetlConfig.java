package com.magic.cosmetic.config;

import com.ibeetl.starter.BeetlTemplateCustomize;
import com.magic.cosmetic.bean.CompanyInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author magicHat
 */
@Configuration
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
public class MyBeetlConfig {

    @Value("${company.name.whole}")
    private String nameWhole;
    @Value("${company.name.small}")
    private String nameSmall;
    @Value("${company.name.english}")
    private String nameEnglish;
    @Value("${company.address}")
    private String address;
    @Value("${company.telephone}")
    private String telephone;
    @Value("${company.phone.num}")
    private String phoneNum;
    @Value("${company.email}")
    private String email;

    @Bean
    public BeetlTemplateCustomize beetlTemplateCustomize() {
        return groupTemplate -> {
            //可以在此配置全部模板的共享参数，项目启动时加载，因此不应在此配置动态参数
            Map<String, Object> shared = new HashMap<>(16);
            shared.put("ConfigCompany", new CompanyInfo(nameWhole, nameSmall, nameEnglish, address, telephone, phoneNum, email));
            groupTemplate.setSharedVars(shared);
        };
    }
}
