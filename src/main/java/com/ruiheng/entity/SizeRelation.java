package com.ruiheng.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 颜色关联表
 */
@Data
public class SizeRelation implements Serializable {

    /**
     * id
     */
    private Integer id;
    /**
     * 尺码值
     */
    private String artSize;
    /**
     * 产品款式id
     */
    private String artNo;
    /**
     * 状态
     */
    private Integer recStatus;
    /**
     * 顺序号
     */
    private String recId;
    /**
     * 公司id
     */
    private String recLtd;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新时间
     */
    private Date updateTime;

}
