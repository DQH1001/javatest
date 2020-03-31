package test1;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        boolean bool = false;
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strs = str.split(" ");
        if (strs.length == 1) {
            System.out.println("-1");
            return;
        }
        int[] nums = new int[strs.length];
        //初始化int数组
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.valueOf(strs[i]);
        }
        int max = nums[0];
        int secmax = 0;//第二大的
        int[] xiabiao = new int[nums.length];//记录满足元素的下标
        int k = 0;//记录下标数组空位子的索引
        //先看第二个元素
        if (nums[1] < max) {
            xiabiao[k] = 1;
            secmax = nums[1];
            k++;
        } else if (nums[1] == max) {
            bool = true;
        } else {
            max = nums[1];
            bool = false;
        }
        if (nums.length - 1 > 2) {
            for (int i = 2; i < nums.length; i++) {//从第3个元素开始
                if (nums[i - 1] > max) {
                    secmax = max;
                    max = nums[i - 1];
                    bool = false;//max重置，bool重置
                    if (max > nums[i] && nums[i] >= secmax && !bool) {
                        xiabiao[k] = i;
                        k++;
                    }
                } else if (nums[i - 1] == max) {
                    bool = true;//重复元素，说明不满足只有一个元素大
                }else {
                    if (max > nums[i] && nums[i] >= secmax && !bool) {
                        xiabiao[k] = i;
                        k++;
                    }
                }
            }
        }
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < xiabiao.length; i++) {
            if (xiabiao[i] != 0) {//不是空元素
                st.append(xiabiao[i] + " ");
            }
        }
        String s = st.toString();
        if (s == null || s.equals("")) {
            s = "-1";
        }
        System.out.println(s);
    }
}