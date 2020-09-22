package com.moxuan.gupao.study.demo1;

import java.util.concurrent.*;

/**
 * @ProjectName dxyt-mdm
 * @ClassName CallableDemo
 * @Author zhangkai
 * @Description
 * @Date 2020/9/20 9:25 下午
 */
public class CallableDemo implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("com in");
        return "success";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        CallableDemo callableDemo = new CallableDemo();
        Future<String> future = executorService.submit(callableDemo);
        // 阻塞
        System.out.println(future.get());
    }
}
