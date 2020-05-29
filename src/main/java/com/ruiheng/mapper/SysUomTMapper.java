package com.ruiheng.mapper;

import com.ruiheng.entity.SysUomT;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "SysUomTMapper")
public interface SysUomTMapper {

    /**
     * 查询车种工序
     * @return
     */
    List<SysUomT> getSysUomTBytype1();

    /**
     * 查询基本款类目
     * @return
     */
    List<SysUomT> getSysUomTBytype2();

    /**
     * 查询对应的基本款工序-掺入父级id
     * @return
     */
    List<SysUomT> getSysUomTBytype2AndId(@Param("id") Integer id);

    /**
     * 添加车种工序,指定公司的
     */
    Integer addUomNameByRecLtd(@Param("uom_name")String uom_name,@Param("rec_ltd")String rec_ltd);

    /**
     * 查询私有公司的车种工序-通过公司id
     */
    List<SysUomT> findByrecLtd(@Param("recLtd")String recLtd);
}