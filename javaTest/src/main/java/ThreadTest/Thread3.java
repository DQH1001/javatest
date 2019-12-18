package ThreadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 创建线程的方式三,实现Callable接口,jdk5.0新增
 */
class NumThread implements Callable{
    private int sum=0;
    private int i=0;
    private Object obj=new Object();
    private ReentrantLock lock=new ReentrantLock();
    @Override
    public Integer call() throws Exception {

        for (;i<=100;i++){
            synchronized(obj){
//                try{
//                    lock.lock();
                    if (i%2==0){
                        Thread.sleep(20);
                        System.out.println(Thread.currentThread().getName()+":i:"+i+"-sum:"+sum);
                        sum+=i;
                    }
//                }finally {
//                    lock.unlock();
//                }
            }

        }
        return sum;
    }
}
public class Thread3 {
    public static void main(String[] args) {
        NumThread numThread=new NumThread();

        FutureTask<Integer> futureTask=new FutureTask<>(numThread);
        FutureTask futureTask1=new FutureTask(numThread);

        Thread t1=new Thread(futureTask);
        t1.setName("线程一");

        Thread t2=new Thread(futureTask1);
        t2.setName("线程二");

        t1.start();
        t2.start();

        try{
            Integer sum=futureTask.get();
            System.out.println(sum);
        }catch(InterruptedException e){
            e.printStackTrace();
        }catch(ExecutionException e){
            e.printStackTrace();
        }
    }
}
