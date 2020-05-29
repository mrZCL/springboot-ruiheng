package com.ruiheng.service.impl;

import com.ruiheng.mapper.ArtColorTMapper;
import com.ruiheng.service.ArtColorTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtColorTServiceImpl implements ArtColorTService {

    @Autowired
    private ArtColorTMapper artColorTMapper;


}
