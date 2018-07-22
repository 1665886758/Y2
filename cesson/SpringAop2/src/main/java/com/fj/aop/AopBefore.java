package com.fj.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

public class AopBefore {

    public void before(JoinPoint JoinPoint){
        System.out.println("我是前置增强:"+JoinPoint.getSignature().getName());
    }
}
