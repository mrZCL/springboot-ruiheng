package com.ruiheng.controller;

import com.alibaba.fastjson.JSON;
import com.ruiheng.entity.User;
import com.ruiheng.service.UserService;
import com.ruiheng.utils.result.Result;
import com.ruiheng.utils.result.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(tags = "用户操作接口")
@CrossOrigin(origins = "*", maxAge = 3600)//开启跨域访问
public class UserController {

    @Autowired
    private UserService userServiceimpl;

    /**
     * 查询所有用户
     */
    @GetMapping("/getAllUser")//RequestMethod.POST
    @ApiOperation("查询该公司下的所有员工信息")
    public List<User> getALLUser(@RequestParam("epId")Integer epId){
            List<User> list =  userServiceimpl.getAllUser(epId);
            if (list != null){
                return list;
            }

        System.out.println("getALLUser集合为空");
       return null;
    }

    /**
     * 通过部门id查询用户
     * @param departmentId
     * @return
     */
    @GetMapping("/getUserFindDepartmentId")
    @ApiOperation("通过部门id查询相关人员信息")
    public List<User> getUserFindDepartmentId(@RequestParam("epId")Integer epId,@RequestParam("departmentId")Integer departmentId){
        List<User> list = userServiceimpl.getUserFindDepartmentId(epId,departmentId);
        if (list != null){
            return list;
        }
        System.out.println("getUserFindDepartmentId集合为空");
        return null;
    }

    /**
     * 查询角色下的人员
     */
    @GetMapping("/getRoleUserFindRoleId")
    @ApiOperation("通过角色id查询相关角色人员信息")
    public String getRoleUserFindRoleId(@RequestParam("epId")Integer epId,@RequestParam("userRoleid")Integer userRoleid){
        List<User> list = userServiceimpl.getRoleUserFindRoleId(epId,userRoleid);
        if (list != null){
            String json = JSON.toJSONString(list);
            return json;
        }
        System.out.println("getRoleUserFindRoleId集合为空");

        return null;
    }

    /**
     * 通过用户名查询相关信息
     */
    @GetMapping("/getUserFindUserName")
    @ApiOperation("通过用户名查询个人信息")
    public String getUserFindUserName(@RequestParam("epId")Integer epId,@RequestParam("userName")String userName){
        List<User> list = userServiceimpl.getUserFindUserName(epId,userName);
        String json = JSON.toJSONString(list);
        return json;
    }


    @PostMapping("/login")
    @ApiOperation("登录")
    public Result login(@RequestBody Map<String,Object> loginMap){
        String phone = (String) loginMap.get("phone");
        String password = (String) loginMap.get("password");
        if (phone != null && phone != "" && password != "" && password != null) {
            try {
                //构造登录令牌
                password = new Md5Hash(password, phone, 3).toString();
                UsernamePasswordToken upToken = new UsernamePasswordToken(phone, password);
                //获取subject
                Subject subject = SecurityUtils.getSubject();
                //调用login方法,进入realm完成认证
                subject.login(upToken);
                //获取sessionId
                String sessionId = (String) subject.getSession().getId();
                System.out.println("获取sessionID:" + sessionId);
                //构造返回结果
                return new Result(ResultCode.SUCCESS, sessionId);
            } catch (UnknownAccountException e) {
                //e.printStackTrace();
                //登录失败:用户名不存在
                System.out.println("登录失败用户名不存在");
                return new Result(ResultCode.FAILURE, "登录失败,账号不存在");
            } catch (IncorrectCredentialsException e) {
                //e.printStackTrace();
                //登录失败:密码错误
                System.out.println("密码错误");
                return new Result(ResultCode.FAILURE, "登录失败,密码错误");
            }catch (Exception e){
                System.out.println("异常:"+e);
                return new Result(ResultCode.FAILURE);
            }
        }else {
            return new Result(ResultCode.FAILURE, "登录信息不完整");
        }
    }

    @GetMapping("/prefile")
    @ApiOperation("用户登录后返回的数据")
    public Result prefile(){
//        //获取session中的安全数据
        Subject subject = SecurityUtils.getSubject();
//        //subject获取所有的安全集合
        PrincipalCollection principals = subject.getPrincipals();
//        //获取安全数据
//        ProfileResult result = (ProfileResult) principals.getPrimaryPrincipal();

        User result = (User) principals.getPrimaryPrincipal();

        return new Result(ResultCode.SUCCESS , result);
    }

    /**
     * 用户信息注册
     */
    @PostMapping("/insertUserInfo")
    @ApiOperation("注册用户信息")
    public Result<Integer> insertUserInfo(@RequestBody User user){
        System.out.println("进入用户注册方法");
        return userServiceimpl.insertUserInfo(user);
    }

    /**
     * 员工离职
     */
    @PutMapping("/userQuit")
    @ApiOperation("员工离职")
    public Result<Integer> userQuit(@RequestParam("id")Integer id){
        Integer num = userServiceimpl.userQuit(id);
        if (num > 0){
            System.out.println("员工离职成功");
            return new Result(ResultCode.SUCCESS,"离职成功");
        }else{
            System.out.println("员工离职失败");
            return new Result(ResultCode.FAILURE,"离职失败");
        }
    }
}
