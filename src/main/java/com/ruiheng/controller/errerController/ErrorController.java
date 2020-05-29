package com.ruiheng.controller.errerController;

import com.ruiheng.utils.result.Result;
import com.ruiheng.utils.result.ResultCode;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hyl
 * @date: 2020/02/08
 **/
@RestController
@CrossOrigin
public class ErrorController {

    //公共错误跳转
    @GetMapping(value = "/autherror")
    public Result autherror(int code){
        System.out.println("进入公共错误");
        if (code == 1){
            return new Result(ResultCode.UNAUTHENTICATED,"您还没有登录!");
        }else {
            return new Result(ResultCode.UNAUTHORISE,"对不起,您还没有该权限");
        }
    }
}
