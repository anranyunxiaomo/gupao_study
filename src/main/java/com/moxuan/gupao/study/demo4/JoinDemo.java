package com.moxuan.gupao.study.demo4;

import java.util.Date;

/**
 * @ProjectName dxyt-mdm
 * @ClassName JoinDemo
 * @Author zhangkai
 * @Description
 * @Date 2020/10/3 12:30 下午
 */
public class JoinDemo {

    private static  int i =10;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i = 30;

        });
        // callable /Future (阻塞)
        t.start();
        // t 线程中的执行结果对于main 线程可见
        t.join(); // happens-Before 模型
        // 我希望t 线程执行对主线程可见.
        System.out.println("i:"+i);
    }

}
