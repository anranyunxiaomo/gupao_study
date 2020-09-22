package com.moxuan.gupao.study.demo2;

/**
 * @ProjectName dxyt-mdm
 * @ClassName synchronizedDemo03
 * @Author zhangkai
 * @Description 类锁  静态锁
 * @Date 2020/9/22 11:15 下午
 */
public class synchronizedDemo03 {

    public static int count =0;

  public synchronized  static void incr()  {
      synchronized (synchronizedDemo03.class){
      try {
          Thread.sleep(1);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
      count++;
    }
  }
    // 类锁  静态锁
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <1000 ; i++) {
            new Thread(()->synchronizedDemo03.incr()).start();
        }
        Thread.sleep(2000);
        System.out.println("运行结果:"+count);
    }
}
