package com.moxuan.gupao.study.demo6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ProjectName: gupao_study
 * @Package: com.moxuan.gupao.study.demo6
 * @ClassName: TestDemo
 * @Author: zhangkai
 * @Description:
 * @Date: 2020/10/5 15:05
 */
public class TestDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        // 重入锁
        Lock lock =new ReentrantLock();
        Condition condition = lock.newCondition();
        int maxSize =5;
        Producer producer = new Producer(queue,maxSize,lock,condition);
        Consumer consumer = new Consumer(queue,maxSize,lock,condition);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t2.start();
        t1.start();
    }
}
