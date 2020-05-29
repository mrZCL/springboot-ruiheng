package com.ruiheng.service.impl;

import com.ruiheng.entity.ArtSizeT;
import com.ruiheng.mapper.ArtSizeTMapper;
import com.ruiheng.service.ArtSizeTService;
import com.ruiheng.utils.result.Result;
import com.ruiheng.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtSizeTServiceImpl implements ArtSizeTService {

    @Autowired
    private ArtSizeTMapper artSizeTMapper;

    /**
     * 查询所有尺码
     * @param artSizeNum
     * @return
     */
    @Override
    public List<ArtSizeT> getArtSizeTnum(String artSizeNum) {
        List<ArtSizeT> artList = artSizeTMapper.getArtSizeTparent(artSizeNum);
        for (ArtSizeT sizeT : artList) {
            List<ArtSizeT> sizeTList = artSizeTMapper.getAllSize(sizeT.getId());
            sizeT.setList(sizeTList);
        }
        return artList;
    }

    /**
     * 自定义公司添加尺码方法
     */
    public Result<Integer> addSize(String artSize, String recLtd) {
        Integer flag = artSizeTMapper.findReSize(artSize,recLtd);
        if (flag > 0){
            System.out.println("添加的尺码已存在");
            return new Result(ResultCode.FAILURE,"添加的尺码已存在");
        }else {
            Integer num = artSizeTMapper.addSize(artSize,recLtd);
            if (num > 0){
                System.out.println("添加尺码成功");
                return new Result(ResultCode.SUCCESS,"添加尺码成功");
            }else{
                System.out.println("尺码添加失败");
                return new Result(ResultCode.FAILURE,"添加尺码失败!");
            }
        }
    }
}
