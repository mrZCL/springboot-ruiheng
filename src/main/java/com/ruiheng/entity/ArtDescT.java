package com.ruiheng.entity;

import lombok.Data;
import org.crazycake.shiro.AuthCachePrincipal;

import java.io.Serializable;
import java.util.Date;

@Data
public class ArtDescT implements Serializable, AuthCachePrincipal {

    /**
     * id
     */
    private Integer id;
    /**
     * 产品代码
     */
    private String artNo;

    /**
     * 产品大类
     */
    private String artType;

    /**
     * 产品名称
     */
    private String artDesc;

    /**
     * 设计编号
     */
    private String artSamNo;

    /**
     * 客户产品代码
     */
    private String artCustNo;

    /**
     * 参考产品代码
     */
    private String artOthNo;

    /**
     * 主料
     */
    private String artFabDesc;

    /**
     * 主料简称
     */
    private String artFabShortType;

    /**
     * 条码
     */
    private String artBarcode;

    /**
     * 单位
     */
    private String artUom;

    /**
     * 备注
     */
    private String artRemark;

    /**
     * 英文描述
     */
    private String artEnDesc;

    /**
     * 英文简述
     */
    private String artEnShtdesc;

    /**
     * 过期日期
     */
    private Date artExpiresDate;

    /**
     * 销售价
     */
    private String artSalesUpr;

    /**
     * 售价1
     */
    private String artSales1Upr;

    /**
     * 售价2
     */
    private String artSales2Upr;

    /**
     * 售价3
     */
    private String artSales3Upr;

    /**
     * 售价4
     */
    private String artSales4Upr;

    /**
     * 售价5
     */
    private String artSales5Upr;

    /**
     * 售价6
     */
    private String artSales6Upr;

    /**
     * 成本价
     */
    private String artCostUpr;

    /**
     * 成本价1
     */
    private String artCost1Upr;

    /**
     * 成本价2
     */
    private String artCost2Upr;

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
     * 公司
     */
    private String recLtd;

    /**
     * 系统序号
     */
    private String recId;

    /**
     * 起订量
     */
    private String artMinQty;

    /**
     * 单价
     */
    private String artUprice;

    /**
     * TK分类
     */
    private String artTkType;

    /**
     * 品牌
     */
    private String artBrind;

    /**
     * 类别
     */
    private String artBrindType;

    /**
     * Category
     */
    private String artBrindCategory;

    /**
     * 尺码组别
     */
    private String artSizeGroup;

    /**
     * 对象名称
     */
    private String artSex;

    /**
     * 系列
     */
    private String artSeries;

    /**
     * 件/盒包
     */
    private String artBoxQty;

    /**
     * 季度
     */
    private String artSeason;

    /**
     * 产品名称
     */
    private String artStdDesc;

    /**
     * 执行标准
     */
    private String artStdNo;

    /**
     * 安全类别
     */
    private String artSafetyCategoty;

    /**
     * 安全等级
     */
    private String artGrade;

    /**
     * 安全技术
     */
    private String artSecTech;

    /**
     * 主料
     */
    private String artStdFab;

    /**
     * 主料1
     */
    private String artStdFab1;

    /**
     * 主料2
     */
    private String artStdFab2;

    /**
     * 主料3
     */
    private String artStdFab3;

    /**
     * 主料4
     */
    private String artStdFab4;

    /**
     * 主料5
     */
    private String artStdFab5;

    /**
     * 主料6
     */
    private String artStdFab6;

    /**
     * 主料7
     */
    private String artStdFab7;

    /**
     * WMS名称
     */
    private String artWmsDesc;

    /**
     * 年龄
     */
    private String artAge;

    /**
     * 洗水法
     */
    private String artWash;

    /**
     * 号型布类
     */
    private String artHxFab;

    /**
     * 外发类型
     */
    private String artWfType;

    /**
     * 印花编号
     */
    private String artYhNo;

    /**
     * 外发编号
     */
    private String artWfNo;

    /**
     * 车花编号
     */
    private String artChNo;

    /**
     * 模杯编号
     */
    private String artCupNo;

    /**
     * 小系列
     */
    private String artSeries2;

    /**
     * 设计师
     */
    private String artDesignOperator;

    /**
     * 纸样师
     */
    private String artZyOperator;

    /**
     * 唛架师
     */
    private String artMjOperator;

    /**
     * 车办师
     */
    private String artSewOperator;

    /**
     * 匹数单位
     */
    private String artCountUom;

    /**
     * 查货单位
     */
    private String artCustChkStd;

    /**
     * 尺码清单
     */
    private String artSizeList;

    /**
     * 系统类别
     */
    private String artClass;

    /**
     * 色号清单
     */
    private String artColorList;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 最近更新时间
     */
    private Date updateTime;

    /**
     * 款式图片路径
     */
    private String imgUrl;

    /**
     * 查询是否有重复
     */
    private Integer count;

    @Override
    public String getAuthCacheKey() {
        return null;
    }
}