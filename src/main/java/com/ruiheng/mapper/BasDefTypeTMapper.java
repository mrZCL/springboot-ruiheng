package com.ruiheng.mapper;

import com.ruiheng.entity.BasDefTypeT;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "BasDefTypeTMapper")
public interface BasDefTypeTMapper  {

    /**
     * 查询所有类目
     */
    List<BasDefTypeT> typeAll();

    /**
     * 查询2级类目录
     */
    List<BasDefTypeT> typeTwo(@Param("id")String id);

    /**
     * 查询3级类目录
     */
    List<BasDefTypeT> typeThree(@Param("id")String id);

    /**
     * 添加服装3类目
     */
    Integer addBasType(BasDefTypeT basDefTypeT);

    /**
     * 拼接公司自定义类目
     */
    List<BasDefTypeT> getType(@Param("pgListId")String pgListId,@Param("recLtd")String recLtd);

}