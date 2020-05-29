package com.ruiheng.mapper;

import com.ruiheng.entity.Enter_Prise;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *企业表
 */
@Component(value = "EnterPriseMapper")
public interface EnterPriseMapper {

    /**
     * 企业注册
     * @return
     */
    Integer addEnterPriseMapper(Enter_Prise enter_prise);

    /**
     * 判断企业手机账号是否重复
     */
    Integer findReEnterPrisePhone(@Param("epPhone")String epPhone);

    /**
     * 判断企业名称是否重复
     */
    Integer findReEnterPriseName(@Param("epName")String epName);

    /**
     * 通过企业名称查询企业id
     */
    Enter_Prise queryEnterPriseId(@Param("epName")String epName);

    /**
     * 添加企业客户
     */
    Integer addEnterPriseClient(Enter_Prise enterPrise);

    /**
     * 查询公司客户
     */
    List<Enter_Prise> findByEpType(@Param("epType")String epType);
}