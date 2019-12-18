package ThreadTest;

/**
 * 例子：创建三个窗口卖票，总数100张 使用实现Runnable接口的方式
 * 问题:
 * 进入if中到ticket--前,可能别的线程也进入了,就会有重票乃至负数票
 * 解决:
 * 使用同步方法的模式
 * 此时show()括号内默认为this
 */
class Window4 implements Runnable{
    private  int ticket = 100;
    @Override
    public void run() {
        while(true){
            show();
        }

    }

    private synchronized void show() {
        if (ticket>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":卖票，票号为："+ticket);
            ticket--;
        }
    }
}

public class WindowTest22 {
    public static void main(String[] args) {
        Window4 window2 = new Window4();
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
