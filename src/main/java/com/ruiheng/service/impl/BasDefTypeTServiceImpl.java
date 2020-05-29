package com.ruiheng.service.impl;

import com.ruiheng.entity.BasDefTypeT;
import com.ruiheng.mapper.BasDefTypeTMapper;
import com.ruiheng.service.BasDefTypeTService;
import com.ruiheng.utils.result.Result;
import com.ruiheng.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasDefTypeTServiceImpl implements BasDefTypeTService {

    @Autowired
    private BasDefTypeTMapper basDefTypeTMapper;

    /**
     * 所有类目
     */
    public List<BasDefTypeT> typeAll(String recLid) {
        List<BasDefTypeT> list = basDefTypeTMapper.typeAll();
        List<BasDefTypeT> listtypeTwo;
        for (BasDefTypeT basDefTypeT : list) {
            listtypeTwo = basDefTypeTMapper.typeTwo(basDefTypeT.getId().toString());
            basDefTypeT.setList(listtypeTwo);
            List<BasDefTypeT> listtypeThree;
            List<BasDefTypeT> listtype;
            for (BasDefTypeT typeT : listtypeTwo) {
                listtypeThree = basDefTypeTMapper.typeThree(typeT.getId().toString());
                if (recLid == "" || recLid == null){
                    System.out.println("空id进"+recLid);
                    typeT.setList(listtypeThree);//显示默认平台类目
                }else {
                    listtype = basDefTypeTMapper.getType(typeT.getId().toString(),recLid);//有公司id就显示平台加公司自定义类目
                    typeT.setList(listtypeThree);
                    listtypeThree.addAll(listtype);
                }
            }
        }

        return list;
    }

    /**
     * 添加服装类目
     */
    public Result<Integer> addBasType(BasDefTypeT basDefTypeT) {
        Integer num = basDefTypeTMapper.addBasType(basDefTypeT);
        if (num > 0){
            System.out.println("添加成功!");
            return new Result(ResultCode.SUCCESS,"新增类目成功!");
        }else{
            System.out.println("添加失败");
            return new Result(ResultCode.SUCCESS,"新增类目失败!");
        }
    }
}
