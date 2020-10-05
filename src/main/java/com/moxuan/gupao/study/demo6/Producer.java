package com.moxuan.gupao.study.demo6;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @ProjectName: gupao_study
 * @Package: com.moxuan.gupao.study.demo6
 * @ClassName: Producer
 * @Author: zhangkai
 * @Description:
 * @Date: 2020/10/5 14:53
 */
public class Producer  implements Runnable {

    private Queue<String> msg;

    private int maxSize;

    Lock lock;
    Condition condition;

    public Producer(Queue<String> msg, int maxSize, Lock lock, Condition condition) {
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
            while (msg.size()==maxSize){
                System.out.println("生产者队列满了,先等待");
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
            System.out.println("生产消息:"+i);
            msg.add("生产者的消息内容"+i);
            // 唤醒阻塞的状态的线程
            condition.signal();
            lock.unlock();
        }
    }
}
