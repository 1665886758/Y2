package com.fj.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import java.util.Arrays;

public class AopRound {

    public void getBookInfo(ProceedingJoinPoint pjp){
        System.out.println("方法名:"+pjp.getSignature().getName());
       try{
           Object proceed = pjp.proceed();
           System.out.println(proceed);     //获取Service方法的返回数据
           System.out.println(Arrays.toString(pjp.getArgs()));
       }catch (Throwable throwable){
           throwable.printStackTrace();
       }
    }
}
