package com.ruiheng.mapper;

import com.ruiheng.entity.ArtSizeT;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ArtSizeTMapper {

    /**
     * 查询尺码父级
     */
    List<ArtSizeT> getArtSizeTparent(@Param("artSizeNum")String artSizeNum);

    /**
     * 查询所有尺码
     */
    List<ArtSizeT> getAllSize(@Param("parentId")Integer parentId);

    /**
     * 添加公司自定义尺码
     */
    Integer addSize(@Param("artSize")String artSize,@Param("recLtd")String recLtd);

    /**
     * 查询重复添加的尺码
     */
    Integer findReSize(@Param("artSize")String artSize,@Param("recLtd")String recLtd);
}