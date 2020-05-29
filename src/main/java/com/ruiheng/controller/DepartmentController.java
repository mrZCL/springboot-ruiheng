package com.ruiheng.controller;

import com.alibaba.fastjson.JSON;
import com.ruiheng.entity.Department;
import com.ruiheng.service.DepartmentService;
import com.ruiheng.utils.result.Result;
import com.ruiheng.utils.result.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@CrossOrigin//开启跨域访问
@Api(tags = "部门类操作")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 查询该公司下的所有部门分组
     * @return
     */
    @GetMapping("/getAllDepartment")
    @ApiOperation("显示所有该公司下的所有部门分组")
    public String getAllDepartment(@RequestParam("epId")Integer epId){
        List<Department> list = departmentService.getAllDepartment(epId);
        if (list!=null){
            String json = JSON.toJSONString(list);
            return json;
        }
        System.out.println("集合为空:");
        return null;
    }

    /**
     * 新增部门-通过企业id添加该公司的部门
     * @param departmentName
     * @return
     */
    @PostMapping("/addDepartment")
    @ApiOperation("通过企业id添加该公司的部门-parentId默认传个0")
    public Result<Integer> addDepartment(@RequestParam("departmentName")String departmentName, @RequestParam("parentId")Integer  parentId, @RequestParam("epId") Integer epId){
        System.out.println("departmentName"+departmentName);
        Integer num = departmentService.addDepartment(departmentName,parentId,epId);
        if (num > 0){
            System.out.println("部门添加成功");
            return new Result(ResultCode.SUCCESS,"添加部门成功!");
        }
        System.out.println("部门添加失败");
        return new Result(ResultCode.FAILURE,"添加部门失败!");
    }


    /**
     * 通过部门id修改部门名称
     * @param departmentName
     * @param id
     * @return
     */
    @PutMapping("/updateDepartmentName")
    @ApiOperation("通过部门id修改部门名称")
    public Result<Integer> updateDepartmentName(@RequestParam("departmentName")String departmentName,@RequestParam("id")Integer id){
        Integer num = departmentService.updateDepartmentName(departmentName,id);
        if(num > 0){
            System.out.println("修改成功");
            return new Result(ResultCode.SUCCESS,"修改成功!");
        }
        System.out.println("失败");
        return new Result(ResultCode.FAILURE,"修改失败!");
    }

    /**
     * 通过部门id修改部门状态-用户界面显示删除
     * @param id
     * @return
     */
    @PutMapping("/updateDepartmentFindId")
    @ApiOperation("通过部门id修改部门状态-用户界面显示删除")
    public Result<Integer> updateDepartmentFindId(@RequestParam("id")Integer id){
        System.out.println("删除Id"+id);
        Integer num = departmentService.updateDepartmentFindId(id);
        if (num > 0){
            return new Result(ResultCode.SUCCESS,"删除成功");
        }
        System.out.println("删除失败");
        return new Result(ResultCode.FAILURE,"删除失败!");
    }
}
