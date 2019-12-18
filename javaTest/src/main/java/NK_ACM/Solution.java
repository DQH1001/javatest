package NK_ACM;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
public class Solution {
    public boolean Find(int target, int [][] array) {
        boolean found=false;
        int hang=array.length;
        int lie=array[0].length;
        int row=hang-1;
        int col=0;
        while(row>=0&&col<=lie-1){
            if(target>array[row][col]){
                col++;
            }else if(target<array[row][col]){
                row--;
            }else{
                found=true;
                break;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        int[][] array = {{1,2,4},{2,4,5}};
        int target=3;
        Solution solution=new Solution();
        System.out.println(solution.Find(target,array));
    }
}
