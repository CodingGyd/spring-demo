package com.gyd.springdemo.tx;

/**
 * @ClassName MyAccount
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/20 19:48
 * @Version 1.0
 */
public class MyAccount {

    //银行账户
    private String card;

    //银行卡余额
    private Double balance;

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void transfer(MyAccount outUser, MyAccount inUser, Double money){

    }
}
