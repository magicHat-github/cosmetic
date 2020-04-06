package com.magic.cosmetic.bean;

import lombok.Data;

/**
 * 公司基本信息
 * @author magicHat
 */
@Data
public class CompanyInfo {

    private String nameWhole;
    private String nameSmall;
    private String nameEnglish;
    private String address;
    private String telephone;
    private String phoneNumber;
    private String email;

    public CompanyInfo(String nameWhole, String nameSmall, String nameEnglish, String address, String telephone, String phoneNumber, String email) {
        this.nameWhole = nameWhole;
        this.nameSmall = nameSmall;
        this.nameEnglish = nameEnglish;
        this.address = address;
        this.telephone = telephone;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
