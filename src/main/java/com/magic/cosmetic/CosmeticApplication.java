package com.magic.cosmetic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动类
 *
 * @author likang
 */
@SpringBootApplication(scanBasePackages = "com.magic.cosmetic.*")
@MapperScan("com.magic.cosmetic.dao")
public class CosmeticApplication {

    public static void main(String[] args) {
        SpringApplication.run(CosmeticApplication.class, args);
    }

}
