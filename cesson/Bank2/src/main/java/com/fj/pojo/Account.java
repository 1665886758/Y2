package com.fj.pojo;

/**
 * 账户信息表
 */
public class Account {

    private Integer id;

    private  String  cardNo;// 16位数字构成的卡号

    private  String  password;// 6位数字的密码

    private  Double  balance;// 2位小数

    private  Integer status;// 1为正常，0为冻结

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
