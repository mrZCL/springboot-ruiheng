package com.ruiheng.controller;

import com.alibaba.fastjson.JSON;
import com.ruiheng.entity.Role;
import com.ruiheng.service.RoleService;
import com.ruiheng.utils.result.Result;
import com.ruiheng.utils.result.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/RoleController")
@CrossOrigin
@Api(tags = "角色表操作")
public class RoleController {

    @Autowired
    private RoleService roleServiceimpl;

    /**
     * 角色管理分组数据
     * @return
     */
    @GetMapping("/getRoleParentAll")
    @ApiOperation("角色分组列表-指定公司编号")
    public String getRoleParentAll(@RequestParam("epId")Integer epId){

        List<Role> list= roleServiceimpl.getRoleParentAll(epId);
        List<Role> list2;
        for (Role role1 : list) {
            list2 = roleServiceimpl.getRolefindParId(epId,role1.getId());
            role1.setList(list2);
        }
        String json = JSON.toJSONString(list);
        return json;
    }

    /**
     * 添加角色,父级id为0则是父级目录
     * @param roleName
     * @param parentId
     * @param epId
     * @return
     */
    @PostMapping("/addRole")
    @ApiOperation("添加角色,通过parentId来添加-在对应的公司id下")
    public Result<Integer> addRole(@RequestParam("roleName")String roleName,@RequestParam("parentId")Integer parentId,@RequestParam("epId")Integer epId){
        Integer num = roleServiceimpl.addRole(roleName,parentId,epId);
        if (num > 0){
            System.out.println("添加成功");
            return new Result(ResultCode.SUCCESS,"添加成功");
        }
        System.out.println("失败");
        return new Result(ResultCode.FAILURE,"添加失败!");
    }

    /**
     * 通过id修改名称角色
     * @param roleName
     * @param id
     * @return
     */
    @PutMapping("/updateRoleName")
    @ApiOperation("通过角色id来修改角色名称")
    public Result<Integer> updateRoleName(@RequestParam("roleName")String roleName,@RequestParam("id")Integer id){
        Integer num = roleServiceimpl.updateRoleName(roleName,id);
        if (num > 0 ){
            System.out.println("修改成功");
            return new Result(ResultCode.SUCCESS,"修改成功!");
        }
        System.out.println("修改失败");
        return new Result(ResultCode.FAILURE,"修改失败");
    }

    /**
     * 通过id来修改角色状态-在用户界面删除该角色
     * @param id
     * @return
     */
    @PutMapping("/updateRoleStatus")
    @ApiOperation("通过id来修改角色状态-在用户界面删除该角色")
    public Result<Integer> updateRoleStatus(@RequestParam("id")Integer id){
        Integer num = roleServiceimpl.updateRoleStatus(id);
        if (num > 0){
            System.out.println("删除成功");
            return new Result(ResultCode.SUCCESS,"删除成功!");
        }
        System.out.println("删除失败");
        return new Result(ResultCode.FAILURE,"删除失败!");
    }
}
