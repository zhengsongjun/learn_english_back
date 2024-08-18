package com.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.Catetory;

import java.util.List;

public interface CatetoryService extends IService<Catetory> {
    List<Catetory> getAllCatory();
}
