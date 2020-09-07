package 第9届省赛真题.JavaA;

import java.math.BigInteger;

/***
 *
 标题：方格计数

 如图p1.png所示，在二维平面上有无数个1x1的小方格。


 我们以某个小方格的一个顶点为圆心画一个半径为 50000 的圆。
 你能计算出这个圆里有多少个完整的小方格吗？

 注意：需要提交的是一个整数，不要填写任何多余内容。

 *
 *答案：7853781044
 *
 *思路：暴力遍历点的坐标，以（0,0）作为圆心，计算第一个象限内
 *对于第一象限内有多少个正方形，我们可以从y=1开始，这一行有多少个点在圆内，就有多少个小方格
 *以此类推
 *
 */
public class problem4 {
    public static void main(String[] args){
        long r=50000;
        long r2=r*r;
        long res=0;
        //计算一个象限内小方格数
        for(long y=1;y<=50000;y++){
            for(long x=1;x<=50000;x++){
                if(x*x+y*y>r2) break;
                else res++;
            }
        }
        res=res*4;
        System.out.println(res);
    }
}
