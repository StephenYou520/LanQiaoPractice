package 第11届第一次校内模拟真题;

/***
 * 【问题描述】1200000有多少个约数（只计算正约数）
 * 【答案提交】这是一道结果填空的题，你只需要算出结果后提交即可。
 * 本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
 *
 * 答案：96
 *
 * 思路：暴力遍历，从1到1200000，余数为0，则res++
 */
public class problem2 {
    public static void main(String[] args) {
        int res=0;
        for(int i=1;i<=1200000;i++){
            if(1200000%i==0) res++;
        }
        System.out.println(res);
    }
}
