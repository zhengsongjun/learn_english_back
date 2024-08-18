package com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.Category;
import com.vo.CategoryVo;

import java.util.List;

public interface CatetoryService extends IService<Category> {
    List<CategoryVo> getAllCategory();
    void insertCategory(String name);

    boolean validate(String name);

    boolean deleteCategory(String id);
}
