package com.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.entity.Category;
import com.service.CatetoryService;
import com.untils.Result;
import com.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CatetoryService catetoryService;

    @GetMapping
    public Result<List<CategoryVo>> getAllCategory() {
        return Result.success(catetoryService.getAllCategory());
    }

    @PostMapping
    public Result<String> insertCategory(@RequestBody Category category) {
            catetoryService.insertCategory(category.getName());
            return Result.success("添加成功！");
    }

    @PostMapping("/validate")
    public Result<String> validate(@RequestBody Category category){
        boolean validate = catetoryService.validate(category.getName());
        if(validate){
            return Result.success("分类名称可取");
        }else{
            return Result.error("分类名称不可取");
        }
    }

    @DeleteMapping("/{id}")
    public Result<String> deleteCategory(@PathVariable String id){
        boolean state = catetoryService.deleteCategory(id);
        return state ?  Result.success("删除成功") : Result.error("此分类下有记忆卡片，无法删除");
    }


}
