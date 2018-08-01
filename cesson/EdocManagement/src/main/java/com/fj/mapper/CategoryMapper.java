package com.fj.mapper;

import com.fj.pojo.Category;
import java.util.List;

public interface CategoryMapper {

    /**
     * 查询文件类型信息
     * @return
     */
    public List<Category> FileCategory();
}
