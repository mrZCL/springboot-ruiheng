package com.ruiheng.entity;

import lombok.Data;

/**
 * 关联用户角色类
 */
@Data
public class User_Role {
    /**
     * id
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer user_id;
    /**
     * 角色id
     */
    private Integer role_id;


}
