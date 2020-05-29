package com.ruiheng.service;

import com.ruiheng.entity.User;
import com.ruiheng.utils.result.Result;

import java.util.List;

public interface UserService {

    /**
     * 查询所有用户
     */
    List<User> getAllUser(Integer epId);

    /**
     * 根据部门id查询员工
     */
    List<User> getUserFindDepartmentId(Integer epId ,Integer departmentId);


    /**
     * 通过角色id查询用户
     */
    List<User> getRoleUserFindRoleId(Integer epId ,Integer userRoleid);

    /**
     * 通过用户名查询员工
     */
    List<User> getUserFindUserName(Integer epId ,String userName);

    /**
     * 登录
     * @param userPhone
     * @return
     */
    User login(String userPhone);



    /**
     * 构造用户返回数据
     */
    List<User> findUserInfoByPhone(String userPhone);

    /**
     * 用户注册
     * @param user
     * @return
     */
    Result<Integer> insertUserInfo(User user);

    /**
     * 员工离职
     */
    Integer userQuit(Integer id);

}
