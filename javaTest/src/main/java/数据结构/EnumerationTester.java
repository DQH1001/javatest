package 数据结构;

/**
 * 枚举enum
 * enumeration
 */
public class EnumerationTester {
    public enum day{
        RED(1,"red"),
        BLUE(2,"bule"),
        GREEN(3,"green");
        private final int i;
        private final String color;
        day(int i, String color) {
            this.i=i;
            this.color=color;
        }
        public int getI()
        {
            return this.i;
        }
        public String getColor()
        {
            return this.color;
        }
        public static day valueOf(int i) {
            switch (i) {
                case 1:
                    return day.RED;
                case 2:
                    return day.BLUE;
                case 3:
                    return day.GREEN;
                default:
                    return null;
            }
        }
    }
    public static void main(String[] args) {
//        Enumeration<String> days;
//        Vector<String> dayNames = new Vector<String>();
//        dayNames.add("a");
//        dayNames.add("b");
//        dayNames.add("c");
//        dayNames.add("d");
//        dayNames.add("e");
//        days=dayNames.elements();
//        while (days.hasMoreElements()){
//            System.out.println(days.nextElement());
//        }
          for (day d:day.values()){
              System.out.println("枚举成员："+d+"\t值："+d.getI()+"\tcolor:"+d.getColor());
          }
        System.out.println("值转换成枚举：" + day.valueOf(2));

        System.out.println("字符串转换成枚举：" + day.valueOf("GREEN"));
    }
}
