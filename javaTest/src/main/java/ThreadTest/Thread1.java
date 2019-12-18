package ThreadTest;

/**
 * 多线程的创建方式一：
 * 继承thread，重写run方法，创建对象调用start方法(该方法会调用run方法)
 * 例子：
 * 遍历一百以内的所有偶数
 */
//1.创建一个继承于Thread的子类
class MyThread extends Thread{
    //重写run方法
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
public class Thread1 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        MyThread t2 = new MyThread();
        t2.start();

    }
}
