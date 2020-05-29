package com.ruiheng.service.impl;

import com.ruiheng.entity.ArtDescT;
import com.ruiheng.mapper.ArtColorTMapper;
import com.ruiheng.mapper.ArtDescTMapper;
import com.ruiheng.mapper.SizeRelationMapper;
import com.ruiheng.service.ArtDescTService;
import com.ruiheng.utils.result.Result;
import com.ruiheng.utils.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
public class ArtDescTServiceImpl implements ArtDescTService {

    /**
     * 产品款式操作
     */
    @Autowired
    private ArtDescTMapper artDescTMapper;
    /**
     *颜色关联操作
     */
    @Autowired
    private ArtColorTMapper artColorTMapper;
    /**
     * 尺码关联操作
     */
    @Autowired
    private SizeRelationMapper sizeRelationMapper;


    /**
     * 添加公司款式
     */
    @Transactional
    public Result<Integer> addArtDescT(ArtDescT artDescT,String[] colorList,String[] sizeList) {
        //通过编号查询是否有重复,2个参数公司id
        ArtDescT flag = artDescTMapper.findArtDescTByArtNo(artDescT.getArtNo(),artDescT.getRecLtd());
        if (flag.getCount() > 0){
            System.out.println("产品编号重复");
            return new Result(ResultCode.FAILURE,"产品编号重复");
        }else{
            try {
                //调用添加产品款式方法
                Integer num =  artDescTMapper.addArtDescT(artDescT);
                if (num > 0){
                    //添加产品成功后,查询产品id
                    ArtDescT artId = artDescTMapper.findArtDescTByArtNo(artDescT.getArtNo(),artDescT.getRecLtd());
                    System.out.println("添加产品款式成功");
                    for (String integer : colorList) {
                        artColorTMapper.addArtColorT(artId.getId(),integer,artId.getRecLtd());//通过产品款式id,颜色是数组,有多个用循环添加
                    }
                    for (String integer : sizeList) {
                        sizeRelationMapper.addSizeRelation(artId.getId().toString(),integer,artId.getRecLtd());//通过产品款式id关联尺码表+尺码是循环数组
                    }
                    return new Result(ResultCode.SUCCESS,"产品所有关联成功!");
                }else{
                    return new Result(ResultCode.FAILURE,"产品款式添加失败");
                }
            }catch (Exception e){
                log.error("添加款式异常! -> {}",e.getMessage());
                return new Result(ResultCode.FAILURE,"款式添加异常出错");
            }
        }
    }

    @Override
    public List<ArtDescT> findByRecLtdAll(String recLtd) {
        List<ArtDescT> list = artDescTMapper.findByRecLtdAll(recLtd);
        return list;
    }
}
