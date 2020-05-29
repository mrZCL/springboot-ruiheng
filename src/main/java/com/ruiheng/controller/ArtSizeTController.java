package com.ruiheng.controller;

import com.alibaba.fastjson.JSON;
import com.ruiheng.entity.ArtSizeT;
import com.ruiheng.service.ArtSizeTService;
import com.ruiheng.utils.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ArtSizeTController")
@Api(tags = "尺码表数据")
public class ArtSizeTController {

    @Autowired
    private ArtSizeTService artSizeTServiceImpl;

    /**
     * 显示所有尺码
     */
    @GetMapping("/getSize")
    @ApiOperation("显示所有尺码")
    public String getSize(@RequestParam("artSizeNum")String artSizeNum){
        List<ArtSizeT> list = artSizeTServiceImpl.getArtSizeTnum(artSizeNum);
        return JSON.toJSONString(list);
    }

    @PostMapping("/addSize")
    @ApiOperation("添加尺码")
    public Result<Integer> addSize(@RequestParam("artSize")String artSize,@RequestParam("recLtd")String recLtd){
        return artSizeTServiceImpl.addSize(artSize,recLtd);
    }
}
