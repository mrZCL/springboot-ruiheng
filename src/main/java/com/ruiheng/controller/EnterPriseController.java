package com.ruiheng.controller;

import com.alibaba.fastjson.JSON;
import com.ruiheng.entity.Enter_Prise;
import com.ruiheng.service.EnterPriseService;
import com.ruiheng.utils.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/EnterPriseController")
@CrossOrigin
@Api(tags = "公司表操作")
public class EnterPriseController {

    @Autowired
    private EnterPriseService enterPriseService;

    /**
     * 企业信息注册
     */
    @PostMapping("/addEnterPriseMapper")
    @ApiOperation("企业注册信息")
    public Result<Integer>  addEnterPriseMapper(@RequestBody Enter_Prise enter_prise){
        return enterPriseService.addEnterPriseMapper(enter_prise);
    }

    /**
     * 添加企业客户
     * @return
     */
    @PostMapping("/addEnterPriseClient")
    @ApiOperation("添加企业客户")
    public Result<Integer> addEnterPriseClient(@RequestBody Enter_Prise enter_prise){
        return enterPriseService.addEnterPriseClient(enter_prise);
    }

    /**
     * 查看公司客户
     */
    @GetMapping("/findByEpType")
    @ApiOperation("查看公司客户-客户管理")
    public String findByEpType(String epType){
        List<Enter_Prise> list = enterPriseService.findByEpType(epType);
        return JSON.toJSONString(list);
    }
}
