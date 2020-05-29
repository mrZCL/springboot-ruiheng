package com.ruiheng.controller;

import com.ruiheng.service.ArtColorTService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/ArtColorTController")
@Api(tags = "操作颜色表")
public class ArtColorTController {

    @Autowired
    private ArtColorTService artColorTServiceImpl;


}
