package test1;
/*
杨辉三角
数
     1
    1 1
   1 2 1
  1 3 3 1
 1 4 6 4 1
1 5 10 10 5 1
数量关系
1 1
2 3
3 6
4 10
5 15
6 21
累加 n n（n+1）/2
int数组索引与数值关系
     0
    1 2
   3 4 5
  6 7 8 9
10 11 12 13 14
 */
public class YHsanjiao {
    //打印
    public void yanghui(int num,int[] x){
        int m=0;
        for (int i=0;i<num;i++){
            for (int j=0;j<num;j++){
                if(j<num-i-1){
                    System.out.print(" ");
                }else{
//                    System.out.print(x[m]+" ");
//                    m++;
                    if(j==num-i-1||j==num-1){
                        System.out.print("1 ");
                    }else if(j==num-i||j==num-2){
                        System.out.print(i+" ");
                    }else if(j==num-i+1||j==num-3){
                        System.out.print(i==4?6+" ":2*i+" ");
                    }
                }
            }
            System.out.println();
        }
    }
    //初始化数组
    public int[] chushihua(int num){
        int[] x = new int[num*(num+1)/2];
        //找出索引关系就成了
        return x;
    }

    public static void main(String[] args) {
        YHsanjiao yHsanjiao = new YHsanjiao();
        int[] x = yHsanjiao.chushihua(6);
        yHsanjiao.yanghui(6,x);
    }
}
