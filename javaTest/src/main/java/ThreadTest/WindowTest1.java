package ThreadTest;

/**
 * 例子：创建三个窗口卖票，总数100张 使用继承Thread类的方式
 * 存在线程安全问题，三个一百，顺序递减
 * 如不用static，就涉及到第二种创建线程方法
 * 解决:当一个线程在操作时,别的线程不能进来
 * 锁必须是同一把锁
 * 使用synchronized(obj)代码块解决,由于是不同对象,所以obj得声明为static
 *
 */
class Window extends Thread{
    private static int ticket = 100;
    private static Object obj = new Object();
    @Override
    public void run() {
        while(true){
//            synchronized (obj){
            synchronized (Window.class){
                if (ticket>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName()+":卖票，票号为："+ticket);
                    ticket--;
                }else {
                    break;
                }
            }
        }
    }
}

public class WindowTest1{
    public static void main(String[] args) {
        Window t1 = new Window();
        t1.setName("窗口一");
        Window t2 = new Window();
        t2.setName("窗口二");
        Window t3 = new Window();
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
