package com.ruiheng.mapper;

import com.ruiheng.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "UserMapper")
public interface UserMapper {
    /**
     * 查询所有改企业的用户
     * @return
     */
    List<User> getAllUser(@Param("epId")Integer epId);

    /**
     * 根据部门id查询员工
     * @param departmentId
     * @return
     */
    List<User> getUserFindDepartmentId(@Param("epId")Integer epId ,@Param("departmentId") Integer departmentId);

    /**
     * 通过角色id查询用户
     * @param userRoleid
     * @return
     */
    List<User> getRoleUserFindRoleId(@Param("epId")Integer epId ,@Param("userRoleid")Integer userRoleid);

    /**
     * 通过用户名查询员工
     * @param userName
     * @return
     */
    List<User> getUserFindUserName(@Param("epId")Integer epId ,@Param("userName")String userName);

    /**
     * 登录
     * @param userPhone
     * @return
     */
    User login(@Param("userPhone")String userPhone);

    /**
     * 通过手机号查询用户个人信息--构造返回数据
     */
    List<User> findUserInfoByPhone(@Param("userPhone") String userPhone);


    /**
     * 用户注册
     * @param user
     * @return
     */
    Integer insertUserInfo(User user);

    /**
     * 查询手机号是否存在
     * @return
     */
    User findPhoneAll(@Param("phone") String phone);

    /**
     * 通过id添加企业id
     */
    Integer addUserEpId(@Param("userEpId")Integer userEpId,@Param("id")Integer id);

    /**
     * 员工离职
     */
    Integer userQuit(@Param("id")Integer id);
}