package com.moxuan.gupao.study.demo1;

/**
 * @ProjectName dxyt-mdm
 * @ClassName ThreadStudy
 * @Author zhangkai
 * @Description
 * @Date 2020/9/19 7:41 下午
 */
public class ThreadStudy extends Thread{
    @Override
    public void run() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 线程执行的指令
        System.out.println("-----"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadStudy threadStudy = new ThreadStudy();
        threadStudy.start();
        System.out.println(Thread.currentThread().getName());

    }
}
