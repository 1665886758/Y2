package com.pojo;

public class Boy {

    private String name;

    private Girl girl;

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "name='" + name + '\'' +
                ", girl=" + girl +
                '}';
    }
}
