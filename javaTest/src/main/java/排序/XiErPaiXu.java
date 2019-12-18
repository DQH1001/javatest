package 排序;

/**
 * 希尔排序(插入排序变种版)
 *     a、基本上和插入排序一样的道理
 * 　　b、不一样的地方在于，每次循环的步长，通过减半的方式来实现
 * 　　c、说明：基本原理和插入排序类似，不一样的地方在于。通过间隔多个数据来进行插入排序。
 * 　　d、代码实现
 */
public class XiErPaiXu {
    public static void main(String[] args) {
        int[] nums={8,9,1,7,2,3,5,4,6,0};
        //希尔排序（插入排序变种版）
        for (int i=nums.length/2;i>0;i/=2){
            //i层循环控制步长
            for (int j=i;j<nums.length;j++){
                //j控制无序端的起始位置
                for (int k=j;k>0&&k-i>=0;k-=i){
                    if(nums[k]<nums[k-i]){
                        int num=nums[k-i];
                        nums[k-i]=nums[k];
                        nums[k]=num;
                    }else{
                        //如果不小于，说明插入完毕，退出内层循环
                        break;
                    }
                }
            }
        }
        for (int i=0;i<nums.length;i++){
            System.out.print(nums[i]+"\t");
        }
    }
}
