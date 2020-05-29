package com.ruiheng.mapper;


import com.ruiheng.entity.ArtColorT;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Component(value = "ArtColorTMapper")
public interface ArtColorTMapper {

    /**
     * 添加颜色关联
     */
    Integer addArtColorT(@Param("artNo")Integer artNo,@Param("artColor")String artColor,@Param("recLtd")String recLtd);

    /**
     * 通过款式id查询颜色
     */
    List<ArtColorT> findArtColorTByArtNo(@Param("artNo")String artNo);
}