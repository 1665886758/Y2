package com.fj.service;

import com.fj.entity.Book;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookService {


    public void bookInfo(){
        System.out.println("一万个为什么");
    }

    public void throwDemo(){
        System.out.println("抛出异常");
//        throw new RuntimeException();   //抛出异常
    }

    public String returnings(String book){
        System.out.println("返回值类型");
        return "666";
    }

    public String login(String name,String pwd){
        System.out.println("执行登录操作");
        return "Login";
    }
}
