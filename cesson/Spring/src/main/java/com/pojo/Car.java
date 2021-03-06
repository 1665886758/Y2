package com.pojo;

public class Car {


    private Double price;

    private String name;

    private Double speed;


    public Car() {
    }

    public Car(Double price, String name) {
        this.price = price;
        this.name = name;
    }

    public Car(String name, Double speed) {
        this.name = name;
        this.speed = speed;
    }



    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", speed=" + speed +
                '}';
    }
}
