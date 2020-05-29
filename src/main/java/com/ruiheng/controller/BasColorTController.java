package com.ruiheng.controller;

import com.alibaba.fastjson.JSON;
import com.ruiheng.entity.BasColorT;
import com.ruiheng.service.BasColorTService;
import com.ruiheng.utils.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/BasColorTController")
@Api(tags = "操作基本颜色表")
public class BasColorTController {

    @Autowired
    private BasColorTService basColorTServiceImpl;

    /**
     * 查询所有有状态的颜色
     */
    @GetMapping("/getBasColorT")
    @ApiOperation("查询所有颜色")
    public String getBasColorT(){
        List<BasColorT> list = basColorTServiceImpl.getBasColorT();
        return JSON.toJSONString(list);
    }

    /**
     * 添加颜色
     */
    @PostMapping("/addBascolor")
    @ApiOperation("添加颜色")
    public Result<Integer> addBascolor(@RequestParam("colorCnDesc")String colorCnDesc,@RequestParam("recLtd")String recLtd){
        return basColorTServiceImpl.addBascolor(colorCnDesc, recLtd);
    }
}
