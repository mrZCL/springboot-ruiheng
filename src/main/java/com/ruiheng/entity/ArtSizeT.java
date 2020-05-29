package com.ruiheng.entity;

import lombok.Data;
import org.crazycake.shiro.AuthCachePrincipal;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ArtSizeT implements Serializable, AuthCachePrincipal {
    /**
     * id
     */
    private Integer id;

    /**
     * 尺码编号
     */
    private String artSizeNum;

    /**
     * 尺码
     */
    private String artSize;

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
     * 父级id
     */
    private Integer parentId;

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
     * 创建时间
     */
    private Date createdTime;

    /**
     * 最近更新时间
     */
    private Date updateTime;

    /**
     * 存取所有尺码
     */
    private List<ArtSizeT> list;

    private List<ArtSizeT> list2;

    @Override
    public String getAuthCacheKey() {
        return null;
    }
}