package com.moxuan.gupao.study.demo1;

/**
 * @ProjectName dxyt-mdm
 * @ClassName InterruptDemo
 * @Author zhangkai
 * @Description
 * @Date 2020/9/20 10:59 下午
 */
public class InterruptDemo extends Thread{

    private int i =0;
    @Override
    public void run() {
        //  Thread.currentThread().isInterrupted() 该方法 默认为false
        // 表示一个中断的标记 isInterrupted =false
        while (!Thread.currentThread().isInterrupted()){
            System.out.println("test"+i++);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new InterruptDemo());
        thread.start();
        // 设置 isInterrupted =true
        thread.interrupt();
    }
}
