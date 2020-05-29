package com.ruiheng.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 企业人员类
 */
@Data
public class Ep_Per_List implements Serializable {
    /**
     * id
     */
    private Integer id;
    /**
     * 企业id
     */
    private Integer epId;
    /**
     * 用户id
     */
    private Integer userId;



}
