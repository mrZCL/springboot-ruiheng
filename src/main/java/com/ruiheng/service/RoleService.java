package com.ruiheng.service;

import com.ruiheng.entity.Role;

import java.util.List;

public interface RoleService {
    /**
     * 查询父角色组的id
     * @return
     */
    List<Role> getRoleParentAll(Integer epId);

    /**
     * 查找parentId查找所有子角色目录
     * @return
     */
    List<Role> getRolefindParId(Integer epId,Integer parentId);

    /**
     * 角色添加
     * @param roleName
     * @param parentId
     * @return
     */
    Integer addRole(String roleName,Integer parentId,Integer epId);

    /**
     * 通过角色id修改名称
     * @param roleName
     * @param id
     * @return
     */
    Integer updateRoleName(String roleName,Integer id);

    /**
     * 删除角色
     * @param id
     * @return
     */
    Integer updateRoleStatus(Integer id);
}
