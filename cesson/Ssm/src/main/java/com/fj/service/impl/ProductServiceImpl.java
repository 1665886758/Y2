package com.fj.service.impl;

import com.fj.mapper.ProductMapper;
import com.fj.pojo.Product;
import com.fj.service.ProductService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jdk.internal.org.objectweb.asm.Handle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public int getAdd(Product product) {
        return productMapper.add(product);
    }

    @Override
    public PageInfo<Product> getproductInfo(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Product> l=productMapper.productInfo();
        PageInfo<Product> product=new PageInfo<Product>(l);
        return product;
    }
}
