package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.entity.FlashCard;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FlashCardMapper extends BaseMapper<FlashCard> {

}