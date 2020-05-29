package com.ruiheng.service;

import com.ruiheng.entity.ArtDescT;
import com.ruiheng.utils.result.Result;

import java.util.List;

public interface ArtDescTService {

    /**
     * 添加公司款式 颜色数组,尺码数组
     * @return
     */
    Result<Integer> addArtDescT(ArtDescT artDescT,String[] colorList,String[] sizeList);

    /**
     * 查询所有的款式-指定公司id
     */
    List<ArtDescT> findByRecLtdAll(String recLtd);
}
