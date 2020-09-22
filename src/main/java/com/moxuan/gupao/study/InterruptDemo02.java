package com.moxuan.gupao.study;

import java.util.concurrent.TimeUnit;

/**
 * @ProjectName dxyt-mdm
 * @ClassName InterruptDemo02
 * @Author zhangkai
 * @Description
 * @Date 2020/9/20 11:04 下午
 */
public class InterruptDemo02 implements Runnable{
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            //false
            try {
                TimeUnit.SECONDS.sleep(200);
            } catch (InterruptedException e) {
                // jvm 层面抛出异常  触发了 线程复位
                e.printStackTrace();
                // 可以不做处理
                // 继续中断 ->
                Thread.currentThread().interrupt();
                // 抛出异常 ..
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new InterruptDemo02());
        t1.start();
        Thread.sleep(1000);
        //加入 一秒是为了让线程进行 上面的睡 sleep  通过这种方式 将线程发出通知 isInterrupted =true
        // 但是这个时候 jvm 抛出异常 导致 复位 isInterrupted =false
        t1.interrupt();
        // 也叫复位
      //   Thread.interrupted();
    }
}
