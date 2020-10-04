package com.moxuan.gupao.study.demo3;

import com.sun.corba.se.spi.ior.MakeImmutable;

/**
 * @ProjectName: gupao_study
 * @Package: com.moxuan.gupao.study.demo3
 * @ClassName: VolatileDemo
 * @Author: zhangkai
 * @Description:
 * @Date: 2020/10/2 15:40
 */
public class VolatileDemo {

    private volatile static boolean stop =false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread   =   new Thread(()->{
           int i =0;
           while (!stop){
               i++;
           }
        });
        thread.start();
        Thread.sleep(1000);
        stop=true;
    }
}
