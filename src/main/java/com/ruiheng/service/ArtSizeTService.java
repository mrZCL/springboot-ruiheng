package com.ruiheng.service;

import com.ruiheng.entity.ArtSizeT;
import com.ruiheng.utils.result.Result;

import java.util.List;

public interface ArtSizeTService {

    /**
     * 查询所有类型
     * @return
     */
    List<ArtSizeT> getArtSizeTnum(String artSizeNum);
    /**
     * 添加公司自定义尺码
     */
    Result<Integer> addSize(String artSize, String recLtd);

}
