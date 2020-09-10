package 第9届省赛真题.JavaA;

import java.util.Scanner;

/***
 *
 *
 标题：倍数问题

 【题目描述】
 众所周知，小葱同学擅长计算，尤其擅长计算一个数是否是另外一个数的倍数。但小葱只擅长两个数的情况，当有很多个数之后就会比较苦恼。现在小葱给了你 n 个数，希望你从这 n 个数中找到三个数，使得这三个数的和是 K 的倍数，且这个和最大。数据保证一定有解。

 【输入格式】
 从标准输入读入数据。
 第一行包括 2 个正整数 n, K。
 第二行 n 个正整数，代表给定的 n 个数。

 【输出格式】
 输出到标准输出。
 输出一行一个整数代表所求的和。

 【样例输入】
 4 3
 1 2 3 4

 【样例输出】
 9

 【样例解释】
 选择2、3、4。

 【数据约定】
 对于 30% 的数据，n <= 100。
 对于 60% 的数据，n <= 1000。
 对于另外 20% 的数据，K <= 10。
 对于 100% 的数据，1 <= n <= 10^5, 1 <= K <= 10^3，给定的 n 个数均不超过 10^8。


 资源约定：
 峰值内存消耗（含虚拟机） < 256M
 CPU消耗  < 1000ms


 请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
 不要使用package语句。不要使用jdk1.7及以上版本的特性。
 主类的名字必须是：Main，否则按无效代码处理。
 *
 *思路：可以使用回溯算法
 */
public class problem9 {
    public static int res=0;
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        int[] num=new int[n];
        for(int i=0;i<n;i++){
            num[i]=in.nextInt();
        }
        compute(num,0,0,k,0);
        System.out.println(res);
    }
    public static void compute(int[] num,int index,int sum,int k,int x){
        if(x==3){
            if(sum%k==0) res=Math.max(res,sum);
        }
        if(x>3) return ;
        if(x<3){
            for(int i=index;i<num.length;i++){
                compute(num,i+1,sum+num[i],k,x+1);
            }
        }
    }
}
