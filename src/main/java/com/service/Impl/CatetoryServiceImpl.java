package com.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Catetory;
import com.mapper.CatetoryMapper;
import com.service.CatetoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatetoryServiceImpl extends ServiceImpl<CatetoryMapper,Catetory> implements CatetoryService  {

    @Autowired
    CatetoryMapper catetoryMapper;
    @Override
    public List<Catetory> getAllCatory() {
       return catetoryMapper.selectList(new QueryWrapper<Catetory>());
    }
}
