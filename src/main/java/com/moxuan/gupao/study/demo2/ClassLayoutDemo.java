package com.moxuan.gupao.study.demo2;

import org.openjdk.jol.info.ClassLayout;

/**
 * @ProjectName dxyt-mdm
 * @ClassName ClassLayoutDemo
 * @Author zhangkai
 * @Description
 * @Date 2020/9/23 12:04 上午
 */
public class ClassLayoutDemo {
    public static void main(String[] args) {
        ClassLayoutDemo classLayoutDemo = new ClassLayoutDemo();
        synchronized (classLayoutDemo){
            // 在计算hashcode 就无法进行偏向锁的使用,因为对象头里,
            // 偏向锁的空间无法进行hashcode 的存储.所以会升级到重量级锁.
            classLayoutDemo.hashCode();
            System.out.println(ClassLayout.parseInstance(classLayoutDemo).toPrintable());
        }
    }
}
