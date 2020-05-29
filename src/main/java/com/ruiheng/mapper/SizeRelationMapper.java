package com.ruiheng.mapper;

import com.ruiheng.entity.SizeRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "SizeRelationMapper")
public interface SizeRelationMapper {

    /**
     * 添加尺码关联
     */
    Integer addSizeRelation(@Param("artNo")String artNo,@Param("artSize")String artSize,@Param("recLtd")String recLtd);

    /**
     * 查询款式尺码- 通过款式id
     */
    List<SizeRelation> findSizeRelationByArtNo(@Param("artNo")String artNo);
}
