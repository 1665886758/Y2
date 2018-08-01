package com.fj.service;

import com.fj.mapper.EntryMapper;
import com.fj.pojo.Entry;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface EntryService {

    /**
     * 查询文件列表信息业务
     * @return
     */
    public PageInfo<Entry> getEntryFileInfo();

    /**
     *查询文件分类信息业务
     */
    public  PageInfo<Entry> listWithPage(Integer pageNum,Integer categoryId);

    /**
     * 删除信息
     */
    public int deleteFilesInfo(Integer id);

    /**
     * 新增信息
     */
    public int insertFilesInfo(Entry entry);

    /**
     * 根据id查找文件信息
     */
    public Entry getFileInfoById(int id);

    /**
     * 修改信息
     */
    public int updateFilesInfo(Entry entry);
}
