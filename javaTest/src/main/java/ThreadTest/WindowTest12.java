package ThreadTest;

/**
 * 例子：创建三个窗口卖票，总数100张 使用继承Thread类的方式
 * 存在线程安全问题，三个一百，顺序递减
 * 如不用static，就涉及到第二种创建线程方法
 * 解决:
 * 使用同步方法的模式
 * 此时为保证锁是同一个,方法要用static修饰
 */
class Window3 extends Thread{
    private static int ticket = 100;
    @Override
    public void run() {
        while(true){
            show();
        }

    }
    private static synchronized void show(){
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

public class WindowTest12{
    public static void main(String[] args) {
        Window3 t1 = new Window3();
        t1.setName("窗口一");
        Window3 t2 = new Window3();
        t2.setName("窗口二");
        Window3 t3 = new Window3();
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
