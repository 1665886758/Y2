package com.fj;

import com.fj.pojo.Book;
import com.fj.service.BookService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

public class BookTest {
    Logger logger =Logger.getLogger(BookTest.class);

    @Test
    public void test(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService=(BookService)ctx.getBean("bookService");
//        查询信息
//        List<Book> bList=bookService.getBookInfo();
//        System.out.println(bList);
//        新增
//        Book b=new Book();
//        b.setName("理财精英");
//        b.setKind("外交经济");
//        b.setTag("猛赚一个亿");
//        b.setClassification("经济");
//        b.setPrice(44);
//        bookService.getInsert(b);
//
//        //修改
//        Book b2=new Book();
//        b2.setName("百万富翁不是梦");
//        b2.setId(6);
//        bookService.getUpdate(b2);

        bookService.getDel(6);
    }
}
