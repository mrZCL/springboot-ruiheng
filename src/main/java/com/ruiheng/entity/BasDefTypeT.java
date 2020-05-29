package com.ruiheng.entity;

import lombok.Data;
import org.crazycake.shiro.AuthCachePrincipal;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class BasDefTypeT implements Serializable, AuthCachePrincipal {
    /**
     * id
     */
    private Integer id;

    /**
     * 列表值
     */
    private String pgListId;

    /**
     * 类别
     */
    private String pgType;

    /**
     * 列表描述
     */
    private String pgListDesc;

    /**
     * 英文描述
     */
    private String pgListEnDesc;

    /**
     * 关键字列表
     */
    private String pgChkList;

    /**
     * 过期日期
     */
    private Date pgExpiresDate;

    /**
     * 摘要
     */
    private String pgMemo;

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
     * 顺序号
     */
    private String recId;

    /**
     * 公司代码
     */
    private String recLtd;

    /**
     * 记录序号
     */
    private String recStep;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 最近更新时间
     */
    private Date updateTime;

    /**
     * 父子级类目
     */
    private List<BasDefTypeT> list;


    @Override
    public String getAuthCacheKey() {
        return null;
    }
}