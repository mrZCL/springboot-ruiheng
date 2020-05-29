package com.ruiheng.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 区域类
 */
@Data
public class Region implements Serializable {
    /**
     * id
     */
    private Integer id;
    /**
     * 地区名称
     */
    private String regionName;
    /**
     * 父级id
     */
    private Integer parentId;

}
