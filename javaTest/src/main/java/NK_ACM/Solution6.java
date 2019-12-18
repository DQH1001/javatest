package NK_ACM;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * 在数学上，斐波那契数列以如下被以递推的方法定义：F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)（n>=3，n∈N*）
 * 1、1、2、3、5、8、13、21、34
 */
public class Solution6 {
    /**
     * 解决递归溢出方式一，循环
     *  public int Fibonacci(int n) {
     *         int preNum=1;
     *         int prePreNum=0;
     *         int result=0;
     *         if(n==0)
     *             return 0;
     *         if(n==1)
     *             return 1;
     *         for(int i=2;i<=n;i++){
     *             result=preNum+prePreNum;
     *             prePreNum=preNum;
     *             preNum=result;
     *         }
     *         return result;
     *
     *     }
     *  解法二：一个简单的动态规划，以一定的空间代价避免代价更大的重复计算的栈空间浪费：
     *      链接：https://www.nowcoder.com/questionTerminal/c6c7742f5ba7442aada113136ddea0c3
     *      来源：牛客网
     *
     *      if(n<=1){
     *          return n;
     *      }
     *      int[] record = new int[n+1];
     *      record[0] = 0;
     *      record[1] = 1;
     *      for(int i=2;i<=n;i++){
     *          record[i] = record[i-1] + record[i-2];
     *      }
     *      return record[n];
     */

    //递归 数太大会栈溢出
    public int Fibonacci(int n) {
        if (n==0){
            return 0;
        }
        if (n==1||n==2){
            return 1;
        }else{
            return Fibonacci(n-1)+Fibonacci(n-2);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution6().Fibonacci(5));
    }
}
