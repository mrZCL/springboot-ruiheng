package com.ruiheng.service.impl;

import com.ruiheng.entity.Permission;
import com.ruiheng.entity.Role;
import com.ruiheng.entity.User;
import com.ruiheng.mapper.PermissionMapper;
import com.ruiheng.mapper.RoleMapper;
import com.ruiheng.mapper.UserMapper;
import com.ruiheng.service.UserService;
import com.ruiheng.utils.result.Result;
import com.ruiheng.utils.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
public class UserServiceImpl implements UserService {

    /**
     * 用户表dao层
     */
    @Autowired
    private UserMapper userMapper;
    /**
     * 角色表dao层
     */
    @Autowired
    private RoleMapper roleMapper;
    /**
     * 权限表dao层
     */
    @Autowired
    private PermissionMapper permissionMapper;



     /**
     * 查询所有用户
     */
    public List<User> getAllUser(Integer epId) {
        return userMapper.getAllUser(epId);
    }

    /**
     * 根据部门id查询员工
     */
    public List<User> getUserFindDepartmentId(Integer epId ,Integer departmentId) {
        return userMapper.getUserFindDepartmentId(epId,departmentId);
    }

    /**
     * 通过角色id查询用户
     */
    public List<User> getRoleUserFindRoleId(Integer epId ,Integer userRoleid) {
        return userMapper.getRoleUserFindRoleId(epId,userRoleid);
    }

    /**
     * 通过用户名查询员工
     */
    public List<User> getUserFindUserName(Integer epId ,String userName) {
        return userMapper.getUserFindUserName(epId,userName);
    }



    /**
     * 登录
     * @param userPhone
     * @return
     */
    @Override
    public User login(String userPhone) {
        return userMapper.login(userPhone);
    }

    /**
     * 构造用户登录后的返回数据
     */

    public List<User> findUserInfoByPhone(String userPhone) {
        List<User> list = userMapper.findUserInfoByPhone(userPhone);
        System.out.println("List:"+list);
        List<Role> roleList;
        List<Permission> permissionList;
        for (User result : list) {
            roleList = roleMapper.findRoleByUserId(result.getId());
            result.setRoleList(roleList);
            for (Role role : roleList) {
                System.out.println("获取roleID:=="+role.getId());
                permissionList = permissionMapper.findPermissionByRoleId(role.getId());
                System.out.println("perm:=="+permissionList);
                result.setPermissionList(permissionList);
            }
        }
        return list;
    }


    /**
     * 用户注册
     */
    @Override
    @Transactional
    public Result<Integer> insertUserInfo(User user) {
        Integer num = 0;
        User falg = userMapper.findPhoneAll(user.getUserPhone());

        if (user.getUserName() != null && user.getUserName() != "" && user.getUserSex() != null && user.getUserSex() != ""
            && user.getUserPwd() != null && user.getUserPwd() != "" && user.getUserPhone() != null && user.getUserPhone() != ""){
            if (falg.getCount() > 0){
                System.out.println("用户手机号已存在");
                log.error("账号已存在");
                return new Result(ResultCode.newInstance(ResultCode.USEREXISTS,"用户账号已存在"));
            }else {
                try{
                    String password = new Md5Hash(user.getUserPwd() ,user.getUserPhone() , 3).toString();
                    user.setUserPwd(password);
                    num = userMapper.insertUserInfo(user);
                    if (num > 0) {
                        System.out.println("注册成功");
                        return new Result(ResultCode.newInstance(ResultCode.SUCCESS,"用户注册信息成功"));
                    }else {
                        log.error("注册失败!");
                        return new Result(ResultCode.newInstance(ResultCode.FAILURE,"用户注册信息失败"));
                    }
                }catch (Exception e){
                    log.error("注册信息异常! -> {}",e.getMessage());
                    return new Result(ResultCode.newInstance(ResultCode.FAILURE,"用户注册信息异常"));
                }
            }

        }else {
            System.out.println("用户注册信息不完整");
            log.error("注册信息不完整! ");
            return new Result(ResultCode.newInstance(ResultCode.FAILURE,"用户注册信息不完整"));
        }
    }

    /**
     * 员工离职
     */
    @Override
    public Integer userQuit(Integer id) {
        return userMapper.userQuit(id);
    }
}
