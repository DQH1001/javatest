package 数据结构;

import java.util.BitSet;

/**
 * 位集合
 * 动物园
 */

public class BitSetTest {
    private BitSet bitset = new BitSet(80);
    /**
     * 查询动物园中是否存在某种动物
     * */
    public boolean getAnimal(int bitIndex) {
        return bitset.get(bitIndex);
    }
    /**
     * 查询动物园中动物的种类数
     * */
    public int getLength() {
        int i =0 ;
        int k ;
        int j = getLogicLength();
        for( k=0 ;k < j; k++)
        {
            if(bitset.get(k))
                i++;
        }
        return i;
    }
    private int getLogicLength() {
        /*返回的不是想要的，这个函数返回的是位集的逻辑长度*/
        return bitset.length();
    }
    /**
     *如果将枚举定义在调用程序的地方，就可以固定使用某一位来表示动物园中是否有这种小动物，哈哈
     * */
    public void addAnimal(int bitIndex) {
        bitset.set(bitIndex);
    }
    /**
     *将某种动物移出动物园
     * */
    public void clearAnimal(int bitIndex) {
        bitset.clear(bitIndex);
    }
    /**
     * 模块测试函数
     * */
    public static final int Tigger =0;
    public static final int Mouse =1;
    public static final int Cat=2;
    public static final int Dog=3;
    public static final int Fox=4;
    public static final int Horse=5;
    public static final int Ox=6;
    public static final int Pig=7;

    public static void main(String[] args) {
        BitSetTest AnimalStat = new BitSetTest();
        AnimalStat.addAnimal(Pig);
        AnimalStat.addAnimal(Ox);
        AnimalStat.addAnimal(Horse);

        if(AnimalStat.getAnimal(Pig))
            System.out.println("hava pig");

        if(AnimalStat.getAnimal(Horse))
            System.out.println("hava horse");

        System.out.println("动物园中动物种类数：");
        System.out.print(AnimalStat.getLength());

    }
}
