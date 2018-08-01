package com.fj.mapper;

import com.fj.pojo.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import java.util.List;

public interface BookMapper {

    List<Book> bookInfo();

    int bookInsert(Book book);

    int update(Book book);

    int bookDel(@Param("id") int id);
}


