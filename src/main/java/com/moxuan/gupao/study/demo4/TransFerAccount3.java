package com.moxuan.gupao.study.demo4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ProjectName dxyt-mdm
 * @ClassName TransFerAccount
 * @Author zhangkai
 * @Description
 * @Date 2020/10/3 11:32 上午
 */
public class TransFerAccount3 implements Runnable{

    /**
     * 转出方
     */
    private Account fromAccount;

    /**
     * 转入方
     */
    private Account toAccount;
    private int amount;



    public TransFerAccount3(Account fromAccount, Account toAccount, int amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }


    @Override
    public void run() {
        Account left =null;
        Account right =null;
        if (fromAccount.hashCode()>toAccount.hashCode()){
            left=toAccount;
            right = fromAccount;
        }

        while (true) {
                synchronized (left) {
                    synchronized (right) {
                        if (fromAccount.getBalance() > amount) {
                            fromAccount.debit(amount);
                            toAccount.credit(amount);
                        }
                    }
                }
                // 转出账户的余额
                System.out.println(fromAccount.getAccountName() + "->" + fromAccount.getBalance());
                // 转入账户的余额
                System.out.println(toAccount.getAccountName() + "->" + toAccount.getBalance());
        }
    }


    public static void main(String[] args) {
        Account formAccount = new Account("轩",100000);
        Account toAccount = new Account("弟弟", 300000);
        Thread t1 = new Thread(new TransFerAccount3(formAccount, toAccount, 10));
        Thread t2 = new Thread(new TransFerAccount3(toAccount, formAccount, 30));
        t1.start();
        t2.start();
    }
}