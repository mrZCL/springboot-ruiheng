package com.ruiheng.controller;


import com.alibaba.fastjson.JSON;
import com.ruiheng.entity.ArtDescT;
import com.ruiheng.entity.SysUomT;
import com.ruiheng.service.ArtDescTService;
import com.ruiheng.utils.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ArtDescTController")
@Api(tags = "产品款式表")
public class ArtDescTController {

    /**
     * 产品service接口
     */
    @Autowired
    private ArtDescTService artDescTService;

    @PostMapping("/addArtDescT")
    @ApiOperation("添加款式方法,颜色和尺码是个数组")
    public Result<Integer> addArtDescT(ArtDescT artDescT, String[] colorList, String[] sizeList,@RequestBody List<SysUomT> sysUomTList){
        System.out.println("进入添加款式方法");
        return artDescTService.addArtDescT(artDescT,colorList,sizeList,sysUomTList);
    }

    /**
     * 查询所有款式-通过公司id
     */
    @GetMapping("/findByRecLtdAll")
    @ApiOperation("掺入公司id-查询所有款式-款式管理")
    public String findByRecLtdAll(String recLtd){
        List<ArtDescT> list = artDescTService.findByRecLtdAll(recLtd);
        return JSON.toJSONString(list);
    }

    @PostMapping("/add")
    public String add(ArtDescT artDescT,@RequestBody List<SysUomT> sysUomTList){
        System.out.println(artDescT);
        System.out.println(sysUomTList);
        return null;
    }

}
