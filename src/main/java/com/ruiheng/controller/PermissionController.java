package com.ruiheng.controller;

import com.alibaba.fastjson.JSON;
import com.ruiheng.entity.Permission;
import com.ruiheng.service.PermissionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PermissionController")
@CrossOrigin
@Api(tags = "权限表操作")
public class PermissionController {

    @Autowired
    private PermissionService permissionServiceImpl;

    /**
     * 查询所有权限
     */
    @GetMapping("/getPermissionParent")
    public String getPermissionParent(){
        List<Permission> permissionList = permissionServiceImpl.getPermissionParent();
        return JSON.toJSONString(permissionList);
    }
}
