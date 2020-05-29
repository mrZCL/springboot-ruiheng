package com.ruiheng.service;

import com.ruiheng.entity.BasColorT;
import com.ruiheng.utils.result.Result;

import java.util.List;

public interface BasColorTService {

    /**
     * 查询颜色
     */
    List<BasColorT> getBasColorT();

    /**
     * 添加颜色(颜色和公司id)
     */
    Result<Integer> addBascolor(String colorCnDesc, String recLtd);


}
