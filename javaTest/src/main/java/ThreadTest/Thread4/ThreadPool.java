package ThreadTest.Thread4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程方式4:使用线程池
 */
class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<=100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<=100;i++){
            if(i%2==1){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        //1.使用ExecutorService接口创建指定线程数量的线程池
        ExecutorService service= Executors.newFixedThreadPool(10);
        //设置线程池属性方式
        ThreadPoolExecutor service1=(ThreadPoolExecutor)service;
        service1.setCorePoolSize(15);

        //2.将实现Runnable接口的类对象传入execute方法的参数
        service.execute(new NumberThread());//适合适用于Runnable
        service.execute(new NumberThread1());

//        service.submit()//适合适用于callable
        //3.不用了关闭线程池
        service.shutdown();
    }
}
