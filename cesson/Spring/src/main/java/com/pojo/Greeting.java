package com.pojo;

public class Greeting {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Greeting(String name) {
        this.name = name;
    }

    public Greeting() {
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "name='" + name + '\'' +
                '}';
    }
}
