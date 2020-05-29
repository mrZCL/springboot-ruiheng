package com.ruiheng.controller;

import com.alibaba.fastjson.JSON;
import com.ruiheng.entity.BasDefTypeT;
import com.ruiheng.service.BasDefTypeTService;
import com.ruiheng.utils.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/BasDefTypeTController")
@Api(tags = "服装类目操作")
public class BasDefTypeTController {

    @Autowired
    private BasDefTypeTService basDefTypeTService;

    /**
     * 所有类目
     */
    @GetMapping("/typeAll")
    @ApiOperation("所有类目-公司id")
    public String typeAll(@RequestParam("recLid")String recLid){
        System.out.println("是否为空Lid:"+recLid);
        List<BasDefTypeT> list = basDefTypeTService.typeAll(recLid);
        return JSON.toJSONString(list);
    }

    /**
     * 添加类目
     */
    @PostMapping("/addBasType")
    @ApiOperation("添加类目")
    public Result<Integer> addBasType(BasDefTypeT basDefTypeT){
        return basDefTypeTService.addBasType(basDefTypeT);
    }

}
