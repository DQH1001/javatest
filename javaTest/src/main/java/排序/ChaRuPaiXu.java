package 排序;

/**
 * 插入排序
 * 　  a、默认从第二个数据开始比较。
 * 　　b、如果第二个数据比第一个小，则交换。然后在用第三个数据比较，如果比前面小，则插入（狡猾）。否则，退出循环
 * 　　c、说明：默认将第一数据看成有序列表，后面无序的列表循环每一个数据，如果比前面的数据小则插入（交换）。否则退出。
 * 　　d、代码实现
 */
public class ChaRuPaiXu {
    public static void main(String[] args) {
        int[] nums={3,5,6,1,3,2};
        for (int i=1;i<nums.length;i++){
            //外层循环，从第二个开始比较
            for (int j=i;j>0;j--){
                //内存循环，与前面排好序的数据比较，如果后面的数据小于前面的则交换
                if(nums[j]<nums[j-1]){
                    int num=nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=num;
                }else{
                    //如果不小于，说明插入完毕，退出内层循环
                    break;
                }
            }

        }
        for (int i=0;i<nums.length;i++){
            System.out.print(nums[i]+"\t");
        }
    }
}
