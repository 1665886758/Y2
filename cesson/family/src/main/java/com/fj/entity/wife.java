package com.fj.entity;

public class wife {

    private int id;
    private String name;
    private husband husband;

    @Override
    public String toString() {
        return "wife{" +
                "name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.fj.entity.husband getHusband() {
        return husband;
    }

    public void setHusband(com.fj.entity.husband husband) {
        this.husband = husband;
    }
}
