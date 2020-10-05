package com.moxuan.gupao.study.demo6;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @ProjectName: gupao_study
 * @Package: com.moxuan.gupao.study.demo6
 * @ClassName: Consumer
 * @Author: zhangkai
 * @Description:
 * @Date: 2020/10/5 14:54
 */
public class Consumer implements Runnable {
    private Queue<String> msg;

    private int maxSize;

    Lock lock;
    Condition condition;

    public Consumer(Queue<String> msg, int maxSize, Lock lock, Condition condition) {
        this.msg = msg;
        this.maxSize = maxSize;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        int i =0;
        while (true){
            i++;
            lock.lock();
            while (msg.isEmpty()){
                System.out.println("消费者队列空了,先等待");
            // 阻塞线程并且释放锁
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("消费消息:"+msg.remove());
            // 唤醒阻塞的状态的线程
            condition.signal();
                lock.unlock();
        }
    }
}
