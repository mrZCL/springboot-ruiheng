package com.ruiheng.controller;

import com.alibaba.fastjson.JSON;
import com.ruiheng.entity.SysUomT;
import com.ruiheng.service.SysUomTService;
import com.ruiheng.utils.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/SysUomTController")
@Api(tags = "工序表")
@CrossOrigin
public class SysUomTController {

    @Autowired
    private SysUomTService sysUomTService;

    /**
     *查询车种工序
     */
    @GetMapping("/getSysUomTBytype1")
    @ApiOperation("查询车种工序")
    public String getSysUomTBytype1(String recLtd){
        List<SysUomT> sysUomTBytype1 = sysUomTService.getSysUomTBytype1(recLtd);
        System.out.println("集合数据:"+sysUomTBytype1);
        for (SysUomT sysUomT : sysUomTBytype1) {
            System.out.println(sysUomT);
        }
        return JSON.toJSONString(sysUomTBytype1);
    }

    /**
     * 查询基本款类目
     */
    @GetMapping("/getSysUomTBytype2")
    @ApiOperation("查询基本款类目")
    public String getSysUomTBytype2(){
        List<SysUomT> sysUomTBytype2 = sysUomTService.getSysUomTBytype2();
        return JSON.toJSONString(sysUomTBytype2);
    }


    @GetMapping("/getSysUomTBytype2AndId")
    @ApiOperation("查询对应的基本款工序-掺入父级id")
    public String getSysUomTBytype2AndId(@RequestParam("id") Integer id){
        List<SysUomT> sysUomTBytype2AndId = sysUomTService.getSysUomTBytype2AndId(id);
        return JSON.toJSONString(sysUomTBytype2AndId);
    }

    @PostMapping("/addUomNameByRecLtd")
    @ApiOperation("添加车种工序,指定公司的")
    public Result<Integer> addUomNameByRecLtd(@RequestParam("uomName")String uomName,@RequestParam("recLtd")String recLtd){
        return sysUomTService.addUomNameByRecLtd(uomName,recLtd);
    }

    @PostMapping("/add")
    @ApiOperation("测试")
    public String add(@RequestBody List<SysUomT> list,@RequestParam("integers")Integer[] integers){
        System.out.println("list"+list);
        for (SysUomT sysUomT : list) {
            System.out.println("属性值:"+sysUomT.getCreUser());
        }
        return null;
    }
}
