package com.moxuan.gupao.study.demo1;

import java.util.concurrent.TimeUnit;

/**
 * @ProjectName dxyt-mdm
 * @ClassName Demo
 * @Author zhangkai
 * @Description
 * @Date 2020/9/20 10:00 下午
 */
public class Demo {
    public static void main(String[] args) {
        new Thread(()->{
            //  不释放锁 等到时间到了 继续执行 阻塞状态
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"STATUS_01").start();
        // 释放锁  并进行竞争 阻塞状态
        new Thread(()->{
            while (true) {
                synchronized (Demo.class) {
                    try {
                        Demo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"STATUS_02").start();
        new Thread(new BlockedDemo(),"BLOCKED_DEMO_1").start();
        new Thread(new BlockedDemo(),"BLOCKED_DEMO_2").start();
    }

    static class BlockedDemo extends Thread{
        @Override
        public void run() {
            synchronized (BlockedDemo.class){
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
