package com.moxuan.gupao.study.demo2;

/**
 * @ProjectName dxyt-mdm
 * @ClassName SynchronizedDemo
 * @Author zhangkai
 * @Description
 * @Date 2020/9/22 10:46 下午
 */
public class SynchronizedDemo {
    // 方法锁
    synchronized void demo(){

    }

//    synchronized static void demo2(){
//
//    }

    // 代码块
  Object object =  new Object();
    void demo3(){
        synchronized (object) {
            // 线程安全性问题
        }
        }
        // 静态修饰
        synchronized static void demo04(){

        }
        // 类锁
        void demo05(){
        synchronized (SynchronizedDemo.class){

        }
        }

    // 锁的范围
    // 实例锁  保护在当前的实例对象中
    // 静态锁  类对象  类锁
    // 代码块
    public static void main(String[] args) {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        // 锁的互斥性
        new Thread(()->
                synchronizedDemo.demo(),"t1")
                .start();

        new Thread(()->
                synchronizedDemo.demo(),"t2")
                .start();
    }

}
