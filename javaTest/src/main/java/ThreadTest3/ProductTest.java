package ThreadTest3;

/**
 * 线程通信的经典应用:生产者消费者问题
 *
 * 生产者productor将产品交给店员Clerk,而消费者Customer从店员处取走产品,
 * 店员一次只能持有固定数量的产品(20),如果生产者试图生产更多的产品,店员
 * 会叫生产者停一下,如果店中有空位放产品在通知生产者继续生产;
 * 如果店中没有产品了,店员会告诉消费者等一下,如果有了产品在通知消费者来取走产品
 *
 *
 */
class Clerk{
    private int productCount=0;
    public synchronized void consumeProduct() {
        if (productCount<20){
            productCount++;
            System.out.println(Thread.currentThread().getName()+":开始生产第"+productCount+"个产品");
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void produceProduct() {
        if (productCount>0){
            System.out.println(Thread.currentThread().getName()+":开始消费第"+productCount+"个产品");
            productCount--;

            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Productor extends Thread{//生产者
    private Clerk clerk;
    public Productor(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":开始生产产品...");
        while (true){
            try{
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}
class Consumer extends Thread{//消费者
    private Clerk clerk;
    public Consumer(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":开始消费产品...");
        while (true){
            try{
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk=new Clerk();

        Productor p1=new Productor(clerk);
        p1.setName("生产者1");
        Productor p2=new Productor(clerk);
        p2.setName("生产者2");

        Consumer c1=new Consumer(clerk);
        c1.setName("消费者1");
        Consumer c2=new Consumer(clerk);
        c2.setName("消费者2");
        Consumer c3=new Consumer(clerk);
        c3.setName("消费者3");

        p1.start();
        p2.start();
        c1.start();
        c2.start();
        c3.start();
    }
}
