package com.ruiheng.service.impl;

import com.ruiheng.entity.Role;
import com.ruiheng.mapper.RoleMapper;
import com.ruiheng.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getRoleParentAll(Integer epId) {
        return roleMapper.getRoleParentAll(epId);
    }

    @Override
    public List<Role> getRolefindParId(Integer epId,Integer parentId) {
        return roleMapper.getRolefindParId(epId,parentId);
    }

    @Transactional
    @Override
    public Integer addRole(String roleName, Integer parentId,Integer epId) {
        return roleMapper.addRole(roleName,parentId,epId);
    }

    @Override
    @Transactional
    public Integer updateRoleName(String roleName, Integer id) {
        return roleMapper.updateRoleName(roleName,id);
    }

    @Override
    @Transactional
    public Integer updateRoleStatus(Integer id) {
        return roleMapper.updateRoleStatus(id);
    }
}
