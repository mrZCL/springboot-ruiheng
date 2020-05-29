package com.ruiheng.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * 权限类
 */
@Data
public class Permission implements Serializable {
    /**
     * id
     */
    private Integer id;
    /**
     * 权限编号
     */
    private Integer permissionId;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 权限描述
     */
    private String description;
    /**
     * 权限访问路径
     */
    private String url;
    /**
     * 权限标识
     */
    private String perms;
    /**
     * 权限父级id
     */
    private Integer parentId;

    /**
     * 关联角色id
     */
    private Integer rid;
    /**
     * 是否锁定0false1:true
     */
    private Integer available;
    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    private Integer type;
    /**
     * 排序
     */
    private Integer order;
    /**
     * 图标
     */
    private Integer icon;
    /**
     * 状态1有效2删除
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Integer createdTime;
    /**
     * 更新时间
     */
    private Timestamp updateTime;

    /**
     * 集合存取所有权限
     */
    private List<Permission> list;

}
