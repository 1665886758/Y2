package com.fj.service;

import com.fj.pojo.Product;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProductService {

    public int getAdd(Product product);

    public PageInfo<Product> getproductInfo(Integer pageNo, Integer pageSize);
}
