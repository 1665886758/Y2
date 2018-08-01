package com.fj.service.impl;

import com.fj.mapper.CategoryMapper;
import com.fj.pojo.Category;
import com.fj.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getFileCategoryInfo() {
        return categoryMapper.FileCategory();
    }
}
