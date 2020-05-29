package com.ruiheng.service.impl;

import com.ruiheng.entity.BasColorT;
import com.ruiheng.mapper.BasColorTMapper;
import com.ruiheng.service.BasColorTService;
import com.ruiheng.utils.result.Result;
import com.ruiheng.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BasColorTServiceImpl implements BasColorTService {

    @Autowired
    private BasColorTMapper basColorTMapper;

    /**
     * 查询颜色
     */
    public List<BasColorT> getBasColorT() {
        List<BasColorT> list = basColorTMapper.getBasColorT();
        return list;
    }

    /**
     * 添加颜色
     */
    public Result<Integer> addBascolor(String colorCnDesc, String recLtd) {
        Integer flag = basColorTMapper.getReColor(colorCnDesc);//默认颜色是否重复
        Integer flag2 = basColorTMapper.getReColorId(colorCnDesc,recLtd);//自定义添加颜色是否重复
        if (flag > 0 || flag2 > 0){
            System.out.println("颜色重复");
            return new Result(ResultCode.FAILURE,"颜色重复");
        }else {
            Integer num = basColorTMapper.addBascolor(colorCnDesc, recLtd);
            if (num > 0){
                System.out.println("添加颜色成功!");
                return new Result(ResultCode.SUCCESS,"颜色添加成功");
            }else {
                System.out.println("添加失败");
                return new Result(ResultCode.FAILURE,"添加失败");
            }
        }
    }

}
