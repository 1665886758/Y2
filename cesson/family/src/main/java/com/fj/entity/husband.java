package com.fj.entity;

public class husband {
    private int id;
    private String name;
    private  wife wife;

    @Override
    public String toString() {
        return "husband{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", wife=" + wife +
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

    public com.fj.entity.wife getWife() {
        return wife;
    }

    public void setWife(com.fj.entity.wife wife) {
        this.wife = wife;
    }
}
