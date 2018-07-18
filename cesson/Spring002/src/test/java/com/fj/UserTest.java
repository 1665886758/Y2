package com.fj;

import com.fj.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    @Test
    public void Test(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
//      User user=(User)ctx.getBean("uName");
//        ((ClassPathXmlApplicationContext) ctx).destroy(); //关闭Spring读取配置文件(即将过时)
//        ((ClassPathXmlApplicationContext) ctx).close();//关闭Spring读取配置文件

        User user02=(User)ctx.getBean("uColor");
        //        System.out.println(user02.getColor());  调用实体类方法
        System.out.println(user02);

    }
}
