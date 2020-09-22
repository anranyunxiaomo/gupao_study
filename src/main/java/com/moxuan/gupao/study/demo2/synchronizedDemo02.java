package com.moxuan.gupao.study.demo2;

/**
 * @ProjectName dxyt-mdm
 * @ClassName synchronizedDemo02
 * @Author zhangkai
 * @Description 实例锁
 * @Date 2020/9/22 11:15 下午
 */
public class synchronizedDemo02 {


        private static int count =0;

        public synchronized void incr(){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
        // 实例化的锁到底生效不生效 取决于 一个对象还是多个对象
        // 循环里面还是外面  共同拿一把锁 还是多个锁
        public static void main(String[] args) throws InterruptedException {
           //  synchronizedDemo02 app = new synchronizedDemo02();
            for (int i = 0; i <1000 ; i++) {
                synchronizedDemo02 app = new synchronizedDemo02();
                new Thread(()->app.incr()).start();
            }
            // 保证线程执行结束
            Thread.sleep(2000);
            System.out.println("运行结果:"+count);
        }
}
