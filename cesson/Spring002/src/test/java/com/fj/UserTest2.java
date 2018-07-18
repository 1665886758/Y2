package com.fj;

import com.fj.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest2 {

    @Test
    public void TestIn(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext2.xml");
        UserController userController=(UserController)ctx.getBean("userController");//跳转控制层,扣号属性避免与类名相同
        userController.getInfo();
    }
}
