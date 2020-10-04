package com.moxuan.gupao.study.demo2;

import java.util.Queue;

/**
 * @ProjectName: gupao_study
 * @Package: com.moxuan.gupao.study.demo2
 * @ClassName: Product
 * @Author: zhangkai
 * @Description:
 * @Date: 2020/10/2 14:47
 */
public class Product implements Runnable{
    private Queue<String> msg;
    private int maxSize;

    public Product(Queue<String> msg, int maxSize) {
        this.msg = msg;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        int i =0;
        while (true){
            i++;
            synchronized (msg){
                while (msg.size()==maxSize){
                    // 如果生产满了
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
                System.out.println("生产者生产消息:"+i);
                msg.add("生产消息:"+i);
                // 唤醒处于阻塞状态的消费者
                msg.notify();
            }
        }
    }
}
