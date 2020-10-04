package com.moxuan.gupao.study.demo3;

/**
 * @ProjectName: gupao_study
 * @Package: com.moxuan.gupao.study.demo3
 * @ClassName: DLCClass
 * @Author: zhangkai
 * @Description:
 * @Date: 2020/10/2 18:10
 */
public class DLCClass {

    public static volatile  DLCClass dlcClass;

    public DLCClass() {
    }

    public static DLCClass getInstance(){
        if (dlcClass==null) {
            synchronized (dlcClass) {
                if (dlcClass == null) {
                    //  new 一个对象 需要三个指令  ->指令重排序
                    dlcClass = new DLCClass();
                }
            }
        }
        return dlcClass;
        }
}
