package com.pojo;

public class Girl {

    private String name;
    private String LoveColor;

    public String getLoveColor() {
        return LoveColor;
    }

    public void setLoveColor(String loveColor) {
        LoveColor = loveColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                "LoveColor='" + LoveColor + '\'' +
                '}';
    }
}
