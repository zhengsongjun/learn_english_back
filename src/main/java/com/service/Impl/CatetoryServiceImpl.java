package com.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dto.FlashCardDto;
import com.entity.Category;
import com.entity.FlashCard;
import com.mapper.CatetoryMapper;
import com.mapper.FlashCardMapper;
import com.service.CatetoryService;
import com.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CatetoryServiceImpl extends ServiceImpl<CatetoryMapper, Category> implements CatetoryService  {

    @Autowired
    CatetoryMapper catetoryMapper;

    @Autowired
    FlashCardMapper flashCardMapper;

    @Override
    public List<CategoryVo> getAllCategory() {
        List<Category> catetories = catetoryMapper.selectList(new QueryWrapper<>());
        List<CategoryVo> categoryVos = new ArrayList<>();
        catetories.forEach(i -> {
            categoryVos.add(toCategoryGetVO(i));
        });
        return categoryVos;
    }

    @Override
    public void insertCategory(String name) {
        Category category = new Category();
        category.setName(name);
        category.setId(UUID.randomUUID().toString());
        catetoryMapper.insert(category);
    }

    @Override
    public boolean validate(String name) {
        QueryWrapper<Category> objectQueryWrapper = new QueryWrapper<>();
        Category category = new Category();
        category.setName(name);
        objectQueryWrapper.setEntity(category);
        List<Object> objects = catetoryMapper.selectObjs(objectQueryWrapper);
        return objects.isEmpty();
    }

    @Override
    public boolean deleteCategory(String id) {
        QueryWrapper<FlashCard> flashCardDtoQueryWrapper = new QueryWrapper<>();
        FlashCard flashCard = new FlashCard();
        flashCard.setCategoryId(id);
        QueryWrapper<FlashCard> flashCardQueryWrapper = flashCardDtoQueryWrapper.setEntity(flashCard);
        List<Object> objects = flashCardMapper.selectObjs(flashCardQueryWrapper);
        if(!objects.isEmpty()){
            return false;
        }else{
            catetoryMapper.deleteById(id);
            return true;
        }
    };


    public CategoryVo toCategoryGetVO(Category catetory) {
        CategoryVo categoryVo = new CategoryVo();
        categoryVo.setValue(catetory.getId());
        categoryVo.setLabel(catetory.getName());
        return categoryVo;
    }


}
