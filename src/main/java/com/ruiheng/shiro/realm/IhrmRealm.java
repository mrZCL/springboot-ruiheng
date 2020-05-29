package com.ruiheng.shiro.realm;

import com.ruiheng.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 *Realm
 **/
public class IhrmRealm extends AuthorizingRealm {

    public void setName(String name){
        super.setName("IhrmRealm");
    }


    //授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取安全数据
        User result = (User) principalCollection.getPrimaryPrincipal();
        System.out.println("获取安全数据:"+result);
        //获取权限信息
//        Set<String> apisPerms = (Set<String>) result.getRole();
        //构造权限信息,返回值
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.setStringPermissions(apisPerms);
//        info.addStringPermission("/user/prefile");
        return info;
    }

    //认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
