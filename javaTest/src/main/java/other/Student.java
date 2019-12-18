package other;

public interface Student {
    public void method1();
    default void method3() {
        double a=10/3;
        System.out.println("default-m3\n"+a);
    }
}
