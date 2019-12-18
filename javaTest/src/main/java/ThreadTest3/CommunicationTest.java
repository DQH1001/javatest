package ThreadTest3;

/**
 * 线程通信的例子,使用俩个线程打印1-100,线程一,线程二,交替打印
 */
class Number implements Runnable{
    private int number=1;
    private Object obj=new Object();
    @Override
    public void run() {
        while (true){
//            synchronized (obj){
              synchronized (this){
                //将别的线程唤醒
//                obj.notify();
                notify();
                if (number<=100){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    number++;

                    try {
                        //使得当前线程阻塞
//                        obj.wait();
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }
        }
    }
}
public class CommunicationTest {
    public static void main(String[] args) {
        Number number=new Number();
        Thread t1=new Thread(number);
        Thread t2=new Thread(number);
        t1.setName("线程一");
        t2.setName("线程二");
        t1.start();
        t2.start();
    }
}
