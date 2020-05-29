package com.ruiheng.entity;

import lombok.Data;
import org.crazycake.shiro.AuthCachePrincipal;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class SysUomT implements Serializable, AuthCachePrincipal {
    /**
     * id
     */
    private Integer id;

    /**
     * 款式编号
     */
    private String uomCode;
    /**
     * 工序名称
     */
    private String uomName;

    /**
     * 单价
     */
    private BigDecimal uomPrice;

    /**
     * 是否开放单价0:false,1:true
     */
    private boolean numFlag;

    /**
     * 是否计数0:false,1:true
     */
    private boolean flag;

    /**
     * 工序类型用于前台展示区分0默认,1车种工序2基本款
     */
    private Integer uomType;
    /**
     * 描述
     */
    private String uomDesc;

    /**
     * 父id
     */
    private Integer uomParent;


    /**
     * 过期日期
     */
    private Date uomExpirseDate;

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