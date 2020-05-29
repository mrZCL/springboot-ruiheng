package com.ruiheng.service;

import com.ruiheng.entity.BasDefTypeT;
import com.ruiheng.utils.result.Result;

import java.util.List;

public interface BasDefTypeTService {

    /**
     * 查询所有类目
     */
    List<BasDefTypeT> typeAll(String recLid);

    /**
     * 添加服装3类目
     */
    Result<Integer> addBasType(BasDefTypeT basDefTypeT);
}
