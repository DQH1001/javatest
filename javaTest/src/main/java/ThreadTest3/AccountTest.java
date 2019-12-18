package ThreadTest3;

/**
 * 银行有一个账户
 * 有俩个储户分别向同一个账户存3000,每次一千,存三次,每次存完打印余额
 */
class Account extends Thread{
    private static int mount=0;
    private int count=0;
    private static Object obj = new Object();
    @Override
    public void run() {
        while (true){
            synchronized (obj){
                if (count<3){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mount+=1000;
                    System.out.println(Thread.currentThread().getName()+"余额为:"+mount);
                    count++;
                }else{
                    break;
                }
            }
        }
    }
}
public class AccountTest {
    public static void main(String[] args) {
        Account a1=new Account();
        a1.setName("储户一");
        Account a2=new Account();
        a2.setName("储户二");
        a1.start();
        a2.start();
    }
}
