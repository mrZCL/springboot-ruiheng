package com.ruiheng.service;

import com.ruiheng.entity.Enter_Prise;
import com.ruiheng.utils.result.Result;

import java.util.List;

public interface EnterPriseService {

    /**
     * 企业注册
     * @return
     */
    Result<Integer> addEnterPriseMapper(Enter_Prise enter_prise);

    /**
     * 添加企业客户
     */
    Result<Integer> addEnterPriseClient(Enter_Prise enterPrise);

    /**
     * 查询公司客户
     */
    List<Enter_Prise> findByEpType(String epType);

}
