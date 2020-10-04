package com.moxuan.gupao.study.demo4;

import javax.lang.model.element.VariableElement;

/**
 * @ProjectName dxyt-mdm
 * @ClassName ThreadLocalDemo
 * @Author zhangkai
 * @Description
 * @Date 2020/10/3 2:52 下午
 */
public class ThreadLocalDemo {

          static   ThreadLocal<Integer>   threadLocal   =        new ThreadLocal<Integer>(){
                @Override
                protected Integer initialValue(){
                    return 0;
                }
            };


    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                Integer num = threadLocal.get();
                threadLocal.set(num+=5);
                System.out.println(Thread.currentThread().getName()+"-"+threadLocal.get());
            });
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
