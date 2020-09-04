package 第10届省赛真题.JavaA;


import java.math.BigInteger;

/***
 * 【问题描述】 小明对数位中含有 2、0、1、9 的数字很感兴趣，
 *      在 1 到 40 中这样的数包括 1、2、9、10 至 32、39 和 40，共 28 个，他们的和是 574，平方和是 14362。
 *      注意，平方和是指将每个数分别平方后求和。 请问，在 1 到 2019 中，所有这样的数的平方和是多少？
 * 【答案提交】这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
 * 提示：如果你编写程序计算，发现结果是负的，请仔细检查自己的程序， 不要怀疑考场的编程软件
 *
 * 答案：2658417853
 *
 * 思路：暴力遍历,需要注意的是因为Integer能表示的最大范围是2147483647,即2的31次方减1，用int会打印负数
 * 所以需要使用Long
 */
public class problem1 {
    public static void main(String[] args) {
        Long res=new Long(0);
        for(int i=1;i<=2019;i++){
            if(isinclude2019(i)) res+=i*i;
        }
        System.out.println(res);
        //System.out.println(Integer.MAX_VALUE);
    }
    public static boolean isinclude2019(int num){
        int n=num;
        while(n>0){
            int c=n%10;
            if(c==2 || c==0 || c==1 || c==9) return true;
            n/=10;
        }
        return false;
    }
}
