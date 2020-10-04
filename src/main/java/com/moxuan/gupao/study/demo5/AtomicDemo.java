package com.moxuan.gupao.study.demo5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ProjectName dxyt-mdm
 * @ClassName AtiomicDemo
 * @Author zhangkai
 * @Description
 * @Date 2020/10/3 4:46 下午
 */
public class AtomicDemo {

    private static  int count= 0;

  static   Lock lock =new ReentrantLock();

    public static void inc(){
        // 获得锁 (互斥锁)
        lock.lock();
        try {
            Thread.sleep(1);
            count++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            // 释放锁
            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <1000; i++) {
            new Thread(()->{
                AtomicDemo.inc();
            }).start();
        }
        Thread.sleep(4000);
        System.out.println("result:"+count);
    }

}
