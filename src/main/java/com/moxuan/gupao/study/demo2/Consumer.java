package com.moxuan.gupao.study.demo2;

import java.util.Queue;

/**
 * @ProjectName: gupao_study
 * @Package: com.moxuan.gupao.study.demo2
 * @ClassName: Consumer
 * @Author: zhangkai
 * @Description:
 * @Date: 2020/10/2 14:48
 */
public class Consumer implements Runnable{
    private Queue<String> msg;
    private int maxSize;

    public Consumer(Queue<String> msg, int maxSize) {
        this.msg = msg;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true){
            synchronized (msg){
                while (msg.isEmpty()) {
                    try {
                        msg.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者消费生产者生产的消息:"+msg.remove());
                // 唤醒阻塞状态的生产者
                msg.notify();
            }
        }
    }
}
