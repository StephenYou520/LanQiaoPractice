package 第8届决赛真题.JavaA;

import java.util.Arrays;

/**
 * 标题：图书排列

 将编号为1~10的10本书排放在书架上，要求编号相邻的书不能放在相邻的位置。
 请计算一共有多少种不同的排列方案。

 注意，需要提交的是一个整数，不要填写任何多余的内容。

 * 答案：479306
 * 思路：组合数学的问题，暴力一点可以使用全排列，然后每个判断是否符合要求
 *
 */
public class problem1 {
    static int[] a=new int[]{1,2,3,4,5,6,7,8,9,10};
    public static void main(String[] args){
        int res=0;
        while(next()){
            if(isok()) res++;
        }

        System.out.println(res);
    }

    //下一个排列
    /***
     * 最后一个排列返回false
     */
    public static boolean next(){
        int x=-1;
        //从后往前找第一个下降的序列
        for(int i=a.length-1;i>0;i--){
            if(a[i]>a[i-1]){
                x=i-1;
                break;
            }
        }
        if(x==-1) return false;
        //从后往前找第一个比a[x]大的数，两个调换
        int y=-1;
        for(int i=a.length-1;i>x;i--){
            if(a[i]>a[x]){
                y=i;
                break;
            }
        }
        int t=a[x];
        a[x]=a[y];
        a[y]=t;
        Arrays.sort(a,x+1,a.length);
        return true;
    }

    public static  boolean isok(){
        for(int i=0;i<a.length-1;i++){
            if(Math.abs(a[i]-a[i+1])==1) return false;
        }
        return true;
    }
}
