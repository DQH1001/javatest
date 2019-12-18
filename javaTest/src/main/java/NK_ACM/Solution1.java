package NK_ACM;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Solution1 {
    public String replaceSpace(StringBuffer str) {
        String s=str.toString();
        String s1=s.replaceAll(" ","%20");
        return s1;
    }

    public static void main(String[] args) {
        Solution1 solution=new Solution1();
        System.out.println(solution.replaceSpace(new StringBuffer("a sd")));
    }
}
