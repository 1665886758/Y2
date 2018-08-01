package com.fj.mapper;

import com.fj.pojo.Entry;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface EntryMapper {

    /**
     * 查询所有文件信息
     * @return
     */
    public List<Entry> entryFile();

    /**
     * 根据文件类型categoryId查找信息
     */
    public List<Entry> list(@Param("categoryId") Integer categoryId);

    /**
     * 新增文件信息
     */
    public int addFiles(Entry entry);

    /**
     * 删除文件信息
     */
    public int delFiles(@Param("id") Integer id);

    /**
     * 根据id查找信息
     */
    public Entry fileInfoById(@Param("id") Integer id);

    /**
     * 修改信息
     */
    public int setFiles(Entry Entry);



}
