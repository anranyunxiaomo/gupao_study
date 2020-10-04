package com.moxuan.gupao.study.demo4;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName dxyt-mdm
 * @ClassName Allocator
 * @Author zhangkai
 * @Description
 * @Date 2020/10/3 11:55 上午
 */
public class Allocator {
    private List<Object> list =new ArrayList<>();

    synchronized boolean apply(Object from,Object to){
        if (list.contains(from)||list.contains(to)){
            return false;
        }else {
            list.add(from);
            list.add(to);
            return true;
        }
    }

    synchronized void free(Object from,Object to){
        list.remove(from);
        list.remove(to);
    }
}
