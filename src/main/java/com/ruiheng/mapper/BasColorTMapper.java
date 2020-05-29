package com.ruiheng.mapper;


import com.ruiheng.entity.BasColorT;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "BasColorTMapper")
public interface BasColorTMapper  {

    /**
     * 查询颜色
     */
    List<BasColorT> getBasColorT();

    /**
     * 添加颜色(颜色和公司id)
     */
    Integer addBascolor(@Param("colorCnDesc")String colorCnDesc,@Param("recLtd")String recLtd);

    /**
     * 判断重复颜色>0
     */
    Integer getReColor(@Param("colorCnDesc")String colorCnDesc);

    /**
     * 判断公司添加的重复颜色
     */
    Integer getReColorId(@Param("colorCnDesc")String colorCnDesc,@Param("recLtd")String recLtd);
}