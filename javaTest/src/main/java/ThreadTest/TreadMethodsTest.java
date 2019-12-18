package ThreadTest;

/**
 * 测试Thread类中的常用的方法
 * 1.start
 * 2.run
 * 3.currentThread，静态方法，返回执行当前代码的线程
 * 4.getName，获取当前线程的名字
 * 5.setName，设置当前线程的名字
 * 6.yieId，释放当前cpu的执行权
 * 7.join,调别的线程进来，只有等该线程执行完才会继续执行调用该线程的线程，此时主线程为阻塞状态
 * 8.stop，已过时，强制结束当前线程
 * 9.sleep(long millitime)，让当前线程休息多少毫秒
 * 10.setPriority
 */
class HelloThread extends Thread{
    //重写run方法
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if(i%2==0){
                try {
                    sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":优先级："+Thread.currentThread().getPriority()+":"+i);
            }
//            if (i%20==0){
//                //让给别的线程执行
//                yield();
//            }
        }
    }
    public HelloThread(String name){
        super(name);
    }
}
public class TreadMethodsTest {
    public static void main(String[] args) {
        HelloThread t1 = new HelloThread("线程一");
        //给分线程命名
//        t1.setName("线程一");
        t1.setPriority(2);
        t1.start();
        //给主线程命名
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(8);
        for (int i=1;i<100;i++){
            if(i%2==1){
                System.out.println(Thread.currentThread().getName()+":优先级："+Thread.currentThread().getPriority()+":"+i);
            }
            if (i%20==0){
                //让给别的线程执行
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
