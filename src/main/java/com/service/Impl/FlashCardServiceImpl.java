package com.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dto.FlashCardDto;
import com.entity.FlashCard;
import com.mapper.CatetoryMapper;
import com.mapper.FlashCardMapper;
import com.service.FlashCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


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

    @Override
    public Integer insertFlashCard(FlashCardDto flashCardDto) {
       return flashCardMapper.insert(FlashDtoToEntity(flashCardDto));
    }

    @Override
    public boolean updateFlashCard(FlashCardDto flashCardDto) {
        int i = flashCardMapper.updateById(FlashDtoToEntity(flashCardDto));
        return i == 1;
    }

    @Override
    public List<FlashCard> toCategorySelectFlashCards(String id) {
        FlashCard flashCard = new FlashCard();
        flashCard.setCategoryId(id);
        QueryWrapper<FlashCard> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.setEntity(flashCard);
        List<FlashCard> flashCardList = flashCardMapper.selectList(objectQueryWrapper);
        return flashCardList;
    }

    public FlashCard FlashDtoToEntity(FlashCardDto flashCardDto){
        FlashCard flashCard = new FlashCard();
        if(flashCardDto.getId().isEmpty()){
            flashCard.setId(UUID.randomUUID().toString());
        }
        flashCard.setQuestion(flashCardDto.getQuestion());
        flashCard.setAnswer(flashCardDto.getAnswer());
        flashCard.setCategoryId(flashCardDto.getCategoryId());
        flashCard.setErrorCount(flashCardDto.getErrorCount());
        flashCard.setPracticeCount(flashCardDto.getPracticeCount());
//        flashCard.setMasteryStatus(flashCardDto.getMasteryStatus());
        return flashCard;
    }


}
