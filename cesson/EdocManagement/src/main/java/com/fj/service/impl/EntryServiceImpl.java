package com.fj.service.impl;

import com.fj.mapper.EntryMapper;
import com.fj.pojo.Entry;
import com.fj.service.EntryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("entryService")
public class EntryServiceImpl implements EntryService {

    @Autowired
    private EntryMapper entryMapper;

    @Override
    public PageInfo<Entry> getEntryFileInfo() {
        PageHelper.startPage(1,3);
        List<Entry> list=entryMapper.entryFile();
        PageInfo<Entry> pageInfo=new PageInfo<Entry>(list);
        return pageInfo;

    }

    @Override
    public PageInfo<Entry> listWithPage(Integer pageNum,Integer categoryId) {
        PageHelper.startPage(pageNum,3);
        List<Entry> list=entryMapper.list(categoryId);
        PageInfo<Entry> pageInfo=new PageInfo<Entry>(list);
        return pageInfo;
    }

    @Override
    public int deleteFilesInfo(Integer id) {
        return entryMapper.delFiles(id);
    }

    @Override
    public int insertFilesInfo(Entry entry) {
        return entryMapper.addFiles(entry);
    }

    @Override
    public Entry getFileInfoById(int id) {
        return entryMapper.fileInfoById(id);
    }

    @Override
    public int updateFilesInfo(Entry entry) {
        return entryMapper.setFiles(entry);
    }
}
