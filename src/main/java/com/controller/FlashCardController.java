package com.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.entity.FlashCard;
import com.service.FlashCardService;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flashCard")
public class FlashCardController {

    @Autowired
    private FlashCardService flashCardService;

    @GetMapping
    public List<FlashCard> getAllFlashCard(){
        return flashCardService.getAllFlashCard();
    };

}
