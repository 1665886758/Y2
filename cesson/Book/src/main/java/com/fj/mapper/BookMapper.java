package com.fj.mapper;

import com.fj.entity.Book;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface BookMapper {

    /**
     * 查询
     */
    public List<Book> getBookListInfo();

    /**
     * 删除
     */
    public int delBookById(@Param("id") Integer id);

    /**
     * 修改
     */
    public int upBookInfoById(Book book);

    /**
     * 新增
     */
    public int addBookInfo(Book book);

    /**
     * 根据条件查询
     */
    public List<Book> selectBookInfoById(Book book);

    /**
     * 新增(set)
     */
    public int addBook(Book book);

    /**
     * 修改
     */
    public int upBook(Book book);

    /**
     * 查询多表信息
     */
    public List<Book> getBookInfo(@Param("id") Integer id);

    /**
     * 多对一
     */
    public List<Book> getBookInfo2(@Param("id") Integer id, @Param("id2") Integer id2);
}
