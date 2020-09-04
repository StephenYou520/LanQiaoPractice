package 第10届省赛真题.JavaA;

import java.util.LinkedList;
import java.util.Scanner;

/***
 *试题 F: 完全二叉树的权值
 *时间限制: 1.0s 内存限制: 512.0MB 本题总分：15 分
 *【问题描述】 给定一棵包含 N 个节点的完全二叉树，树上每个节点都有一个权值，按从 上到下、从左到右的顺序依次是 A1, A2, ··· AN，如下图所示：
 *现在小明要把相同深度的节点的权值加在一起，他想知道哪个深度的节点 权值之和最大？如果有多个深度的权值和同为最大，请你输出其中最小的深度。
 *注：根的深度是 1。
 *【输入格式】
 *第一行包含一个整数 N。 第二行包含 N 个整数 A1, A2, ··· AN 。
 *【输出格式】
 *输出一个整数代表答案。
 *【样例输入】 7 1 6 5 4 3 2
 *【样例输出】 2
 *【评测用例规模与约定】 对于所有评测用例，1≤ N ≤100000，−100000≤ Ai ≤100000。
 *思路：层级遍历的问题，每遍历一层，就计算该层的权值和。
 *因为是完全二叉树，所以深度为d的一层，除非为最后一层，则节点数为2的d-1次方
 *所以记录遍历的节点数，当达到2的d-1次方时重新计数。
 */
public class problem6 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

        int n=in.nextInt();
        int[] numA=new int[n];
        for(int i=0;i<n;i++){
            numA[i]=in.nextInt();
        }
        int res=1;
        int d=1;
        int sum=0;
        int count=0;
        int max=0;
        for(int i=0;i<n;i++){
            //遍历完一层
            if(count==(int)Math.pow(2,d-1)){
                if(sum>max){
                    res=d;
                }
                //下一层
                d++;
                sum=0;
                count=0;
            }
            else {
                sum+=numA[i];
                count++;
            }
        }
        System.out.println(res);
    }

}
