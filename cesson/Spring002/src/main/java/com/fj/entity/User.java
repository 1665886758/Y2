package com.fj.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {

    private String name;

    private List color;

    private Set loveNumber;

//    private Map<String,String>

    public Set getLoveNumber() {
        return loveNumber;
    }

    public void setLoveNumber(Set loveNumber) {
        this.loveNumber = loveNumber;
    }

    public List getColor() {
        return color;
    }

    public void setColor(List color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", color=" + color +
                ", loveNumber=" + loveNumber +
                '}';
    }

//    public User(){
//        System.out.println("无参构造-1");
//    }

    public void init(){
        System.out.println("姓名:"+this.getName()+"-2");
    }
}
