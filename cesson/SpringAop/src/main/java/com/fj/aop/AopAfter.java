package com.fj.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopAfter {

    @After("execution(public * bookInfo())")
    public void after(JoinPoint JoinPoint){
        System.out.println("我是后置增强"+JoinPoint.getTarget().getClass());
    }
}
