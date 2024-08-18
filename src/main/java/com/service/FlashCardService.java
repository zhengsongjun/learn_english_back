package com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dto.FlashCardDto;
import com.entity.FlashCard;

import java.util.List;


public interface FlashCardService extends IService<FlashCard> {
    List<FlashCard> getAllFlashCard();

    Integer insertFlashCard(FlashCardDto flashCardDto);

    boolean updateFlashCard(FlashCardDto flashCardDto);

    List<FlashCard> toCategorySelectFlashCards(String id);

}
