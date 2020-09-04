package 第9届省赛真题.JavaA;

/***
 *
 *标题：星期一
 *整个20世纪（1901年1月1日至2000年12月31日之间），一共有多少个星期一？
 *(不要告诉我你不知道今天是星期几)
 *
 *注意：需要提交的只是一个整数，不要填写任何多余的内容或说明文字。
 *
 * 答案：5217
 *
 * 思路：计算出这之间有多少天，然后除以7算有多少周
 * 需要知道闰年的判断方法
 *
 *
 */
public class problem2 {
    public static void main(String[] args){
        int sum=0;
        for(int i=1901;i<=2000;i++){
            if(isleap(i)){
                sum+=366;
            }
            else sum+=365;
        }
        //看日历可以知道2000年12月25日是最后一个星期一，所以直接除以7就行
        int res=sum/7;
        System.out.println(res);
    }
    //判断是否为闰年
    public static boolean isleap(int x){
        return x%400==0 || (x%4==0 && x%100!=0);
    }
}
