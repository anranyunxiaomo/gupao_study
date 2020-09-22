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
            System.out.println(ClassLayout.parseInstance(classLayoutDemo).toPrintable());
        }
    }
}
