package com.fj.service.impl;

import com.fj.mapper.DetailMapper;
import com.fj.pojo.Detail;
import com.fj.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("detailService")
public class DetailServiceImpl implements DetailService {

    @Autowired
    private DetailMapper detailMapper;

    @Override
    public List<Detail> getListAll(String title) {
        return detailMapper.listAll(title);
    }

    @Override
    public int deleteById(Integer id) {
        return detailMapper.setDeleteInfo(id);
    }
}
