package com.moxuan.gupao.study.demo4;

/**
 * @ProjectName dxyt-mdm
 * @ClassName Accout
 * @Author zhangkai
 * @Description
 * @Date 2020/10/3 11:28 上午
 */
public class Account {

    private String accountName;

    private int balance;

    public Account(String accountName, int balance) {
        this.accountName = accountName;
        this.balance = balance;
    }

    /**
     * 更新转出方的余额
     */
    public void debit (int amount){
        this.balance-=amount;
    }

    /**
     * 更新转入方的余额
     */
    public void credit(int amount) {
        this.balance+=amount;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
