package com.fj.service.impl;

import com.fj.mapper.BookMapper;
import com.fj.pojo.Book;
import com.fj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    public BookMapper getBookMapper() {
        return bookMapper;
    }

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public List<Book> getBookInfo() {
       return bookMapper.bookInfo();
    }

    @Override
    public int getInsert(Book book) {
        return bookMapper.bookInsert(book);
    }

    public int getUpdate(Book book){
        return bookMapper.update(book);
    }

    public int getDel(int id){
        return bookMapper.bookDel(id);
    }
}
