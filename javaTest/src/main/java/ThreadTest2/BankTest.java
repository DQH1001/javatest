package ThreadTest2;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 */
public class BankTest {
}
class Bank{
    private Bank(){}

    private static Bank instance=null;
    public static Bank getInstance(){
        //方式一:效率较差,因为判断只需第一次,而所有线程都需要等
//        synchronized (Bank.class){
//            if(instance==null){
//                instance=new Bank();
//            }
//            return instance;
//        }
        //方式二:效率稍高,等待的线程可能就只有几个,不会所有的线程等待
        if(instance==null){
            synchronized (Bank.class){
                if(instance==null){
                    instance=new Bank();
                }

            }
        }
        return instance;
    }
}