package com.ruiheng.service;

import com.ruiheng.entity.Permission;

import java.util.List;

public interface PermissionService {

    /**
     * 查询权限父级标题
     */
    List<Permission> getPermissionParent();

}
