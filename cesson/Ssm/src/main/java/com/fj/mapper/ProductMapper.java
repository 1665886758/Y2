package com.fj.mapper;

import com.fj.pojo.Product;

import java.util.List;

public interface ProductMapper {

    //新增
    int add(Product product);

    //查询
    List<Product> productInfo();
}
