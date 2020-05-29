package com.ruiheng.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 企业类
 */
@Data
public class Enter_Prise implements Serializable {
    /**
     * id
     */
    private Integer id;
    /**
     * 企业编号
     */
    private Integer epId;
    /**
     * 企业名称
     */
    private String epName;
    /**
     * 企业法人
     */
    private String epPeople;
    /**
     * 性别1男2女
     */
    private String epSex;
    /**
     * 登录密码
     */
    private String epPwd;

    /**
     * 公司所属区域id
     */
    private Integer epRegion;
    /**
     * 公司详细地址
     */
    private String epAddress;
    /**
     * 企业电话
     */
    private String epPhone;
    /**
     * 企业营业编码
     */
    private String epCode;
    /**
     * 企业状态1位在线,2失效
     */
    private Integer epStatus;
    /**
     * 加入时间
     */
    private Timestamp createdTime;
    /**
     * 更新时间
     */
    private Timestamp updateTime;

    /**
     * 企业id0为企业,企业为企业的供应商和企业客户
     */
    private String epType;

}
