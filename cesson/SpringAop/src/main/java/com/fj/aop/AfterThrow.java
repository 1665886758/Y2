package com.fj.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.nio.file.FileSystem;

@Component
@Aspect
public class AfterThrow {

    @AfterThrowing("execution(public * throwDemo())")
    public void throwing(JoinPoint JoinPoint){
        System.out.println("我是异常啦啦啦");
    }
}
