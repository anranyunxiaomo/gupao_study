package com.moxuan.gupao.study.demo2;

import com.sun.org.apache.bcel.internal.util.Class2HTML;
import org.openjdk.jol.info.ClassLayout;
import sun.applet.Main;

/**
 * @ProjectName: gupao_study
 * @Package: com.moxuan.gupao.study.demo2
 * @ClassName: LockDemo
 * @Author: zhangkai
 * @Description:
 * @Date: 2020/10/2 14:24
 */
public class LockDemo {
    public static void main(String[] args) throws InterruptedException {
        LockDemo lockDemo = new LockDemo();
        Thread t1 = new Thread(()->{
            synchronized (lockDemo){
                System.out.println("t1 抢占到锁");
                System.out.println(ClassLayout.parseInstance(lockDemo).toPrintable());
            }
        });
        t1.start();
        Thread.sleep(10000);
        synchronized (lockDemo){
            System.out.println("mian 抢占到锁");
            System.out.println(ClassLayout.parseInstance(lockDemo).toPrintable());
        }
    }
}



