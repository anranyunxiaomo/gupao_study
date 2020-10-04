package com.moxuan.gupao.study.demo5;

import javax.lang.model.element.VariableElement;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ProjectName dxyt-mdm
 * @ClassName ReadWriteLockDemo
 * @Author zhangkai
 * @Description
 * @Date 2020/10/3 4:58 下午
 */
public class ReadWriteLockDemo {
    static   Map<String,Object> hashMap =   new HashMap<String,Object>();
    static   ReentrantReadWriteLock rwl =new ReentrantReadWriteLock();
    static Lock read =rwl.readLock();
    static Lock write = rwl.writeLock();

    public static Object get (String key){
        // 读锁 Thread A 阻塞
        read.lock();
        try {
            return hashMap.get(key);
        }finally {
            // 释放读锁
            read.unlock();
        }
    }

    public static Object write(String key,String value){
        // other Thread 获得了写锁
        write.lock();
        try {
            return hashMap.put(key,value);
        }finally {
            write.unlock();
        }
    }

}
