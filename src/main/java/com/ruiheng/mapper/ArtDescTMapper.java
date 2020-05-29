package com.ruiheng.mapper;

import com.ruiheng.entity.ArtDescT;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "ArtDescTMapper")
public interface ArtDescTMapper{

    /**
     * 添加公司款式
     * @return
     */
    Integer addArtDescT(ArtDescT artDescT);

    /**
     * 查询重复编号和查询id
     */
    ArtDescT findArtDescTByArtNo(@Param("artNo")String artNo,@Param("recLtd")String recLtd);

    /**
     * 查询所有的款式-指定公司id
     */
    List<ArtDescT> findByRecLtdAll(@Param("recLtd")String recLtd);
}