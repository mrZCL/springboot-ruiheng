package com.ruiheng.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface EpPerListMapper  {

    /**
     * 企业关联添加
     */
    Integer addEpPerList(@Param("epId")Integer epId,@Param("user_id")Integer user_id);
}