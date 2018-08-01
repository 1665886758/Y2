package com.fj.service;

import com.fj.pojo.Book;
import java.util.List;

public interface BookService {

    public List<Book> getBookInfo();

    public int getInsert(Book book);

    public int getUpdate(Book book);

    public int getDel(int id);
}
