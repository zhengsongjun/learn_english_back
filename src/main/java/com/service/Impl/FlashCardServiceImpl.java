package com.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dto.FlashCardDto;
import com.entity.Catetory;
import com.entity.FlashCard;
import com.mapper.CatetoryMapper;
import com.mapper.FlashCardMapper;
import com.service.FlashCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Service
public class FlashCardServiceImpl extends ServiceImpl<FlashCardMapper,FlashCard> implements FlashCardService {

    @Autowired
    FlashCardMapper flashCardMapper;

    @Autowired
    CatetoryMapper catetoryMapper;
    @Override
    public List<FlashCard> getAllFlashCard() {
        return flashCardMapper.selectList(new QueryWrapper<>());
    }
    public FlashCard FlashDtoToEntity(FlashCardDto flashCardDto){
        FlashCard flashCard = new FlashCard();
        flashCard.setQuestion(flashCardDto.getQuestion());
        flashCard.setAnswer(flashCardDto.getAnswer());
        return flashCard;
    }


}
