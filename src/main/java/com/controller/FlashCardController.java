package com.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dto.FlashCardDto;
import com.entity.FlashCard;
import com.mapper.FlashCardMapper;
import com.service.FlashCardService;
import com.untils.Result;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flashCard")
public class FlashCardController {

    @Autowired
    private FlashCardService flashCardService;

    @GetMapping
    public List<FlashCard> getAllFlashCard(){
        return flashCardService.getAllFlashCard();
    };

    @PostMapping
    public Result<String> insertFlashCard(@RequestBody FlashCardDto flashCardDto) {
        Integer i = flashCardService.insertFlashCard(flashCardDto);
        if(i == 1){
            return Result.success("拆入成功");
        }else{
            return Result.error("拆入失败");
        }
    };

    @PutMapping
    public Result<String> updateFlashCard(@RequestBody FlashCardDto flashCardDto) {
        boolean b = flashCardService.updateFlashCard(flashCardDto);
        return b ? Result.success("修改成功!") : Result.error("修改失败！");
    }

    @GetMapping("/{category_id}")
    public Result<List<FlashCard>> toTypeSelectFlashCard(@PathVariable String category_id){
        List<FlashCard> categorySelectFlashCards = flashCardService.toCategorySelectFlashCards(category_id);
        return Result.success(categorySelectFlashCards);
    }

}
