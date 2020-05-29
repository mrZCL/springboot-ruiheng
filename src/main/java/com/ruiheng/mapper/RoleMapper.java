package com.ruiheng.mapper;

import com.ruiheng.entity.Role;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "RoleMapper")
public interface RoleMapper {

    /**
      * 查询父角色组的id
      */
    List<Role> getRoleParentAll(@Param("epId")Integer epId);

    /**
     * 查找parentId查找所有子角色目录
     */
    List<Role> getRolefindParId(@Param("epId")Integer epId,@Param("parentId")Integer parentId);

    /**
     * 添加角色
     */
    Integer addRole(@Param("roleName")String roleName,@Param("parentId")Integer parentId,@Param("epId")Integer epId);

    /**
     * 通过角色id修改名称
     */
    Integer updateRoleName(@Param("roleName")String roleName,@Param("id")Integer id);

    /**
     * 删除角色
     */
    Integer updateRoleStatus(@Param("id")Integer id);

    /**
     * 通过用户id查询用户角色
     */
    List<Role> findRoleByUserId(@Param("userId")Integer userId);
}