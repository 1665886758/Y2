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
          //1.前置增强 2.后置增强
//        bookService.bookInfo();
          //3.异常抛出增强
//        bookService.throwDemo();
          //4.最终增强
       // bookService.returnings("张浩");
           //5.环绕增强
        bookService.login("admin","123");
    }
}
