package com.ruiheng.mapper;

import com.ruiheng.entity.Permission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PermissionMapper {

    /**
     * 查询权限父级标题
     */
    List<Permission> getPermissionParent();

    /**
     * 查询全部权限
     */
    List<Permission> getPermission(@Param("parentId")Integer parentId);

    /**
     * 通过角色id查询所有角色权限
     */
    List<Permission> findPermissionByRoleId(@Param("roleId")Integer roleId);
}