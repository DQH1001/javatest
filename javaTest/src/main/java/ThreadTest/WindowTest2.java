package ThreadTest;

/**
 * 例子：创建三个窗口卖票，总数100张 使用实现Runnable接口的方式
 * 问题:
 * 进入if中到ticket--前,可能别的线程也进入了,就会有重票乃至负数票
 * 解决:当一个线程在操作时,别的线程不能进来
 * 锁必须是同一把锁
 * 使用synchronized(obj)代码块解决,由于是一个对象,所以obj是同一个
 */
class Window2 implements Runnable{
    private  int ticket = 100;
    Object obj=new Object();
    @Override
    public void run() {
        while(true){
            synchronized(obj){
                if (ticket>0){
                    //加上sleep后出现大量重复数据,不是说sleep本身原因
                    //而是此种方式本就存在安全隐患,sleep只是放大了
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":卖票，票号为："+ticket);
                    ticket--;
                }else {
                    break;
                }
            }
        }
    }
}
public class WindowTest2 {
    public static void main(String[] args) {
        Window2 window2 = new Window2();
        Thread t1 = new Thread(window2);
        t1.setName("窗口一");
        Thread t2 = new Thread(window2);
        t2.setName("窗口二");
        Thread t3 = new Thread(window2);
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
