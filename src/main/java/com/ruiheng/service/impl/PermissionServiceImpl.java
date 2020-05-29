package com.ruiheng.service.impl;

import com.ruiheng.entity.Permission;
import com.ruiheng.mapper.PermissionMapper;
import com.ruiheng.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 权限查询
     */
    @Override
    public List<Permission> getPermissionParent() {
        List<Permission> list = permissionMapper.getPermissionParent();
        List<Permission> permissionList;
        for (Permission permission : list) {
            permissionList = permissionMapper.getPermission(permission.getId());
            permission.setList(permissionList);
        }
        return list;
    }
}
