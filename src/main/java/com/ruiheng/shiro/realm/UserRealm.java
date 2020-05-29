package com.ruiheng.shiro.realm;

import com.ruiheng.entity.User;
import com.ruiheng.service.UserService;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Realm
 **/
public class UserRealm extends IhrmRealm {

    @Autowired
    private UserService userService;

//    @Autowired
//    private PermissionService permissionService;

    //认证方法  
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) {

        //获取用户的手机号和密码
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        String mobile = upToken.getUsername();
        String password = new String(upToken.getPassword());
        //根据手机号查询用户
        User user = userService.login(mobile);

        //根据用户是否存在,用户密码是否和输入密码一致
        if (user != null && user.getUserPwd().equals(password)){
            //构造用户数据
            List<User> userList = userService.findUserInfoByPhone(user.getUserPhone());
            //构造方法：安全数据,密码,realm域名
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userList , user.getUserPwd() , this.getName());
            System.out.println("构造安全数据:"+info);
            return info;
        }
        //返回null,会抛出异常,表示用户名和密码不匹配
        return null;
    }
}
