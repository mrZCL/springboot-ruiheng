package com.ruiheng.entity;


import lombok.Data;

import java.io.Serializable;

/**
 * 关联角色权限类
 */
@Data
public class Role_Permission implements Serializable {
    /**
     * id
     */
    private Integer id;
    /**
     * 角色id
     */
    private Integer roleId;
    /**
     * 权限id
     */
    private Integer permissionId;

}
