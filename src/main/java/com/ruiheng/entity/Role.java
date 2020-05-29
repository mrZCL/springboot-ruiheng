package com.ruiheng.entity;

import lombok.Data;
import org.crazycake.shiro.AuthCachePrincipal;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * 角色类
 */
@Data
public class Role implements Serializable, AuthCachePrincipal {
    /**
     * id
     */
    private Integer id;
    /**
     * 角色名字
     */
    private String roleName;
    /**
     * 角色描述
     */
    private String description;
    /**
     * 角色父级id
     */
    private Integer parentId;
    /**
     * 是否锁定0 false 1:true
     */
    private boolean available;
    /**
     * 状态1有效2删除
     */
    private Integer status;

    /**
     * 企业id
     */
    private Integer epId;
    /**
     * 创建时间
     */
    private Timestamp createdTime;
    /**
     * 更新时间
     */
    private Timestamp updateTime;

    /**
     * 记录父组下所有的子级总数
     */
    private Integer count;

    /**
     * 存储子目录
     */
    private List<Role> list;

    @Override
    public String getAuthCacheKey() {
        return null;
    }
}