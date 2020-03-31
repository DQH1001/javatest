package test1;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = new int[4];
        for(int i = 0;i<nums.length&&in.hasNext();i++){
            nums[i] = in.nextInt();
        }
        int[] count={0,0,0,0};//存储四个数字每一种可以存在多少个
        //城镇可以有多少个
        for (int i = 0;i<nums[0];i++){

            count[0]++;
        }
        //街道可以有多少个
        for (int i = 0;i<nums[1];i++){

            count[1]++;
        }
        //楼房可以有多少个
        for (int i = 0;i<nums[2];i++){

            count[2]++;
        }
        //公寓可以有多少个
        for (int i = 0;i<nums[3];i++){

            count[3]++;
        }
        System.out.println(count[0]*count[1]*count[2]*count[3]);
    }
}
