package ThreadTest2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题方法三,Thread与Lock锁,java5.0新增
 */
class Window2 extends Thread{
    private static int ticket=100;
    //1.实例化ReentrankLock
    private static ReentrantLock lock = new ReentrantLock();
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
public class LockTest2 {
    public static void main(String[] args) {
        Window2 w1=new Window2();
        Window2 w2=new Window2();
        Window2 w3=new Window2();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();
    }
}
