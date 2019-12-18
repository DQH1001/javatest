package ThreadTest2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题方法三,Runnable与Lock锁,java5.0新增
 */
class Window implements Runnable{
    private int ticket=100;
    //1.实例化ReentrankLock
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try{
                //2.调用锁住方法
                lock.lock();
                if (ticket>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"售票:票号为:"+ticket);
                    ticket--;
                }else{
                    break;
                }
            }finally {
                //3.调用解锁方法
                lock.unlock();
            }
        }
    }
}
public class LockTest {
    public static void main(String[] args) {
        Window window=new Window();
        Thread t1=new Thread(window);
        Thread t2=new Thread(window);
        Thread t3=new Thread(window);
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}
