package com.fj.entity;

/**
 * shuben
 */
 public class Book {

    private Integer id; //编号
     private String ISBN; //（出版商一套书定的编号）
     private String name; //姓名
     private double price;
     private double discount;//（折扣）
     private String publisher;//（出版社）
     private Person person; //对象类型

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Integer getId() {
         return id;
     }

     public void setId(Integer id) {
         this.id = id;
     }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", person=" + person +
                '}';
    }

    public String getISBN() {
         return ISBN;
     }

     public void setISBN(String ISBN) {
         this.ISBN = ISBN;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public double getPrice() {
         return price;
     }

     public void setPrice(double price) {
         this.price = price;
     }

     public double getDiscount() {
         return discount;
     }

     public void setDiscount(double discount) {
         this.discount = discount;
     }

     public String getPublisher() {
         return publisher;
     }

     public void setPublisher(String publisher) {
         this.publisher = publisher;
     }


}
