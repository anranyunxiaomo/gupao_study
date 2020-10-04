package com.moxuan.gupao.study.demo2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName: gupao_study
 * @Package: com.moxuan.gupao.study.demo2
 * @ClassName: TestMain
 * @Author: zhangkai
 * @Description:
 * @Date: 2020/10/2 14:56
 */
public class TestMain {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        int maxSize=5;
        Product product = new Product(queue, maxSize);
        Consumer consumer = new Consumer(queue, maxSize);
        Thread t1 = new Thread(product);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();
    }
}
