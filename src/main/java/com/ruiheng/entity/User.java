package com.ruiheng.entity;

import lombok.Data;
import org.crazycake.shiro.AuthCachePrincipal;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * 用户类
 */
@Data
public class User implements Serializable, AuthCachePrincipal {
    /**
     *id
     */
    private Integer id;
    /**
     *员工工号
     */
    private Integer userNumber;
    /**
     *用户名称
     */
    private String userName;
    /**
     *用户头像
     */
    private String headImgUrl;
    /**
     *用户性别1男2女
     */
    private String userSex;
    /**
     *登录密码
     */
    private String userPwd;


    private String ip;
    /**
     *盐值加密
     */
    private String salt;
    /**
     *年龄
     */
    private Integer age;
    /**
     *身份证号码
     */
    private String userId;
    /**
     *银行卡号
     */
    private String bankCard;
    /**
     *电子邮箱
     */
    private String userEmail;
    /**
     *电话号码
     */
    private String userPhone;
    /**
     *企业id
     */
    private Integer userEpId;
    /**
     *角色id
     */
    private Integer userRoleid;
    /**
     *部门id
     */
    private Integer departmentId;
    /**
     *是否锁定0false1:true
     */
    private Integer locked;
    /**
     *用户状态0启用1冻结2删除
     */
    private Integer userStatus;
    /**
     *加入日期
     *
     **
     */
    private String createdDate;
    /**
     *最近操作日期
     */
    private Timestamp updateDate;
    /**
     *最后登录时间
     */
    private Timestamp lastLoginTime;

    /**
     * 角色表
     */
    private Role role;

    /**
     * 企业表
     */
    private Enter_Prise enter_prise;

    /**
     * 部门表
     */
    private Department department;

    /**
     * 权限表
     */
    private Permission permission;

    /**
     * 查询返回数字
     */
    private Integer count;

    /**
     * 集合
     */
    private List<Role> roleList;

    /**
     * 集合
     */
    private List<Permission> permissionList;

    @Override
    public String getAuthCacheKey() {
        return null;
    }
}
