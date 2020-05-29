package com.ruiheng.service;

import com.ruiheng.entity.SysUomT;
import com.ruiheng.utils.result.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUomTService {

    /**
     * 查询车种工序
     */
    List<SysUomT> getSysUomTBytype1(String recLtd);

    /**
     * 查询基本款类目
     * @return
     */
    List<SysUomT> getSysUomTBytype2();

    /**
     * 查询对应的基本款工序-掺入父级id
     */
    List<SysUomT> getSysUomTBytype2AndId(Integer id);

    /**
     * 添加车种工序,指定公司的
     */
    Result<Integer> addUomNameByRecLtd(String uom_name, String rec_ltd);
}
