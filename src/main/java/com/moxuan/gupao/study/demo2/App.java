package com.moxuan.gupao.study.demo2;

import sun.applet.Main;

import javax.swing.text.TabableView;

/**
 * @ProjectName dxyt-mdm
 * @ClassName App
 * @Author zhangkai
 * @Description
 * @Date 2020/9/22 10:20 下午
 */
public class App {

    public static int count =0;

    public static synchronized void incr(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            count++;
    }
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <1000 ; i++) {
            App app = new App();
            new Thread(()->app.incr()).start();
        }
        // 保证线程执行结束
        Thread.sleep(2000);
        System.out.println("运行结果:"+count);
    }
}
