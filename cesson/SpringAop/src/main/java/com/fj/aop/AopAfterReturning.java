package com.fj.aop;

import com.fj.entity.Book;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 最终增强
 */
@Component
@Aspect
public class AopAfterReturning {

    @AfterReturning(pointcut = "execution(public * returnings(..))",returning="book")
    public void bookNameDemo(String book){
        System.out.println("最终增强返回:"+book);
    }
}
