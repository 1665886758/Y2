package com.fj;

import com.fj.entity.Book;
import com.fj.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookTest {

    @Test
    public void Test(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("app01.xml");
        BookService bookService=(BookService) ctx.getBean("bookService");
//        bookService.bookInfo();
//        bookService.throwDemo();
       // bookService.returnings("张浩");
        bookService.login("admin","123");
    }
}
