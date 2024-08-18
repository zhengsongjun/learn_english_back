package com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.FlashCard;

import java.util.List;


public interface FlashCardService extends IService<FlashCard> {
    List<FlashCard> getAllFlashCard();

    List<String> getCategory();
}
