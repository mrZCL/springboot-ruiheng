package com.ruiheng.service.impl;

import com.ruiheng.entity.SysUomT;
import com.ruiheng.mapper.SysUomTMapper;
import com.ruiheng.service.SysUomTService;
import com.ruiheng.utils.result.Result;
import com.ruiheng.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUomTServiceImpl implements SysUomTService {

    @Autowired
    private SysUomTMapper sysUomTMapper;

    /**
     * 查询车种工序
     */
    public List<SysUomT> getSysUomTBytype1(String recLtd) {
        List<SysUomT> sysUomTBytype1 = sysUomTMapper.getSysUomTBytype1();
        List<SysUomT> byrecLtd = sysUomTMapper.findByrecLtd(recLtd);
        if (byrecLtd != null && !byrecLtd.equals("")){
            sysUomTBytype1.addAll(byrecLtd);//添加属于自己公司的车种
        }
        return sysUomTBytype1;
    }

    /**
     * 查询基本款类目
     */
    public List<SysUomT> getSysUomTBytype2() {
        return sysUomTMapper.getSysUomTBytype2();
    }

    /**
     * 查询对应的基本款工序-掺入父级id
     */
    public List<SysUomT> getSysUomTBytype2AndId(Integer id) {
        return sysUomTMapper.getSysUomTBytype2AndId(id);
    }

    /**
     * 添加车种工序,指定公司的
     */
    public Result<Integer> addUomNameByRecLtd(String uom_name, String rec_ltd) {
        Integer num = sysUomTMapper.addUomNameByRecLtd(uom_name, rec_ltd);
        if (num > 0){
            System.out.println("添加成功!");
            return new Result<>(ResultCode.SUCCESS);
        }else {
            System.out.println("添加失败");
            return new Result<>(ResultCode.FAILURE);
        }
    }

}
