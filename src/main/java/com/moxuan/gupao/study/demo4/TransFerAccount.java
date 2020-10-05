package com.moxuan.gupao.study.demo4;


/**
 * @ProjectName dxyt-mdm
 * @ClassName TransFerAccount
 * @Author zhangkai
 * @Description
 * @Date 2020/10/3 11:32 上午
 */
public class TransFerAccount implements Runnable{

    /**
     * 转出方
     */
    private Account fromAccount;

    /**
     * 转入方
     */
    private Account toAccount;
    private int amount;
    Allocator allocator;

    public TransFerAccount(Account fromAccount, Account toAccount, int amount,Allocator allocator) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.allocator =allocator;
    }

    @Override
    public void run() {
        while (true) {
            if (allocator.apply(fromAccount, toAccount)) {
                try {
                synchronized (fromAccount) {
                    synchronized (toAccount) {
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
                }finally {
                    allocator.free(fromAccount,toAccount);
                }
            }
        }
    }


    public static void main(String[] args) {
        Account formAccount = new Account("轩",100000);
        Account toAccount = new Account("弟弟", 300000);
        Allocator allocator = new Allocator();
        Thread t1 = new Thread(new TransFerAccount(formAccount, toAccount, 10,allocator));
        Thread t2 = new Thread(new TransFerAccount(toAccount, formAccount, 30,allocator));
        t2.start();
        t1.start();
    }


}