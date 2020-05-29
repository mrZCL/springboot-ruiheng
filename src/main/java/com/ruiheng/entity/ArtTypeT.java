package com.ruiheng.entity;

import lombok.Data;
import org.crazycake.shiro.AuthCachePrincipal;

import java.io.Serializable;
import java.util.Date;

@Data
public class ArtTypeT implements Serializable, AuthCachePrincipal {
    /**
     * 大类代码
     */
    private Integer artId;

    /**
     * 产品大类
     */
    private String artType;

    /**
     * 父id
     */
    private String artParentId;

    /**
     * 英文名
     */
    private String artEnType;

    /**
     * 检查关键字
     */
    private String artChkKey;

    /**
     * 过期
     */
    private String artExpires;

    /**
     * 定义
     */
    private String artTypeDef;

    /**
     * 计划天数
     */
    private String artPlanDay;

    /**
     * 产能分组
     */
    private String artEngGroup;

    /**
     * 量小产能
     */
    private String artSetMinQty;

    /**
     * 产能值
     */
    private String artPlanEngQty;

    /**
     * 最少生产时间
     */
    private String artMinTime;

    /**
     * 分类
     */
    private String artCategory;

    /**
     * 建立者
     */
    private String creUser;

    /**
     * 建立日期
     */
    private Date creDate;

    /**
     * 更新者
     */
    private String updUser;

    /**
     * 更新日期
     */
    private Date updDate;

    /**
     * 查核者
     */
    private String chkUser;

    /**
     * 查核日期
     */
    private Date chkDate;

    /**
     * 审批者
     */
    private String cfmUser;

    /**
     * 审批日期
     */
    private Date cfmDate;

    /**
     * 状态
     */
    private Integer recStatus;

    /**
     * 公司代码
     */
    private String recLtd;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 最近更新时间
     */
    private Date updateTime;

    @Override
    public String getAuthCacheKey() {
        return null;
    }
}