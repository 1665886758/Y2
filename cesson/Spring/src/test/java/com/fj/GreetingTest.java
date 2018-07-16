package com.fj;

import com.pojo.Boy;
import com.pojo.Greeting;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {

    @Test
    public void test(){
//        ApplicationContext txt=new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext txt=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});//ClassPathXmlApplicationContext参数可以是数组
        Greeting greeting=(Greeting)txt.getBean("greeting");//括号对应xml配置文件id
        System.out.println(greeting);

        Greeting greeting2=(Greeting)txt.getBean("greeting2");
        System.out.println(greeting2);

        Boy Boy=(Boy)txt.getBean("gender");
        System.out.println(Boy);
    }
}
