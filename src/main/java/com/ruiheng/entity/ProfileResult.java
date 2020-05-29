package com.ruiheng.entity;

import lombok.Getter;
import lombok.Setter;
import org.crazycake.shiro.AuthCachePrincipal;

import java.io.Serializable;
import java.util.*;

@Setter
@Getter
public class ProfileResult implements Serializable,AuthCachePrincipal {
    private Integer userId;
    private String mobile;
    private String username;
    private Integer userNumber;
    private Integer userEpId;
    private String headImgUrl;
    private String userSex;

    /**
     *
     * @param user
     */
    public ProfileResult(User user, List<User> list) {
        this.userId = user.getId();
        this.mobile = user.getUserPhone();
        this.username = user.getUserName();
        this.userNumber = user.getUserNumber();
        this.userEpId = user.getUserEpId();
        this.headImgUrl = user.getHeadImgUrl();
        this.userSex = user.getUserSex();

        Set<String> users = new HashSet<>();
        Set<Role> roles = new HashSet<>();
        Set<Permission> pers = new HashSet<>();

//        this.list = list;
//        for (Result result : list) {
//            roles.addAll(result.getRoleList());
//            pers.addAll(result.getPermissionList());
//        }
//        this.map.put("roles",roles);
//        this.map.put("pers",pers);
    }


    public ProfileResult(User user) {

    }

    @Override
    public String getAuthCacheKey() {
        return null;
    }
}
