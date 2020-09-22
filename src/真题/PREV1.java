package 真题;

import java.util.Scanner;

/***
 * 核桃的数量
 * 问题描述
 * 小张是软件项目经理，他带领3个开发组。工期紧，今天都在加班呢。为鼓舞士气，小张打算给每个组发一袋核桃（据传言能补脑）。他的要求是：
 *
 * 1. 各组的核桃数量必须相同
 *
 * 2. 各组内必须能平分核桃（当然是不能打碎的）
 *
 * 3. 尽量提供满足1,2条件的最小数量（节约闹革命嘛）
 *
 * 输入格式
 * 输入包含三个正整数a, b, c，表示每个组正在加班的人数，用空格分开（a,b,c<30）
 * 输出格式
 * 输出一个正整数，表示每袋核桃的数量。
 * 样例输入1
 * 2 4 5
 * 样例输出1
 * 20
 * 样例输入2
 * 3 1 1
 * 样例输出2
 * 3
 *
 * 思路：题目的难点在与求3个数的最小公倍数
 * 一般来说可以通过辗转相除法来求最大公约数和最小公倍数；
 * 对a和b：
 * 1.计算r=a%b;
 * 2.a=b,b=r;
 * 3.若r==0,则最大公约数为a；否则重复1、2步
 * 最小公倍数=a*b/最大公约数；
 * 顺带一提，两个数互质=最大公约数==1；
 */
public class PREV1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
        int c=in.nextInt();

        int x=Toss_and_divide(a,b);//求a、b的最大公约数
        x=a*b/x;//求a、b的最小公倍数
        int y=Toss_and_divide(x,c);
        int res=x*c/y;//求a、b、c的最小公倍数
        System.out.println(res);
    }

    /***
     * 辗转相除法求最大公约数
     * @param a
     * @param b
     * @return a和b的最大公约数
     */
    public  static  int Toss_and_divide(int a,int b){
        int r=a%b;
        a=b;
        b=r;
        while(r!=0){
            r=a%b;
            a=b;
            b=r;
        }
        return a;
    }


}
