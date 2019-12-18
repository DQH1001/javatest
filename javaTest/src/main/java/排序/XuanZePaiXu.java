package 排序;

/**
 * 选择排序
 *     a、将第一个值看成最小值
 * 　　b、然后和后续的比较找出最小值和下标
 * 　　c、交换本次遍历的起始值和最小值
 * 　　d、说明：每次遍历的时候，将前面找出的最小值，看成一个有序的列表，后面的看成无序的列表，然后每次遍历无序列表找出最小值。
 * 　　e、代码实现
 */
public class XuanZePaiXu {
    public static void main(String[] args) {
        int[] nums={3,5,6,1,3};
        for (int i=0;i<nums.length;i++){
            //默认第一个是最小的。
            int min=nums[i];
            //记录最小的下标
            int index=i;
            //通过与后面的数据进行比较得出，最小值和下标
            for (int j=i+1;j<nums.length;j++){
                if(min>nums[j]){
                    min=nums[j];
                    index=j;
                }
            }
            //然后将最小值与本次循环的，开始值交换
            nums[index]=nums[i];
            nums[i]=min;
        }
        for (int i=0;i<nums.length;i++){
            System.out.print(nums[i]+"\t");
        }
    }
}
