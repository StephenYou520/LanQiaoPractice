package 第9届省赛真题.JavaA;
/***
 *
 *标题：分数
 *
 *1/1 + 1/2 + 1/4 + 1/8 + 1/16 + ....
 *每项是前一项的一半，如果一共有20项,
 *求这个和是多少，结果用分数表示出来。
 *类似：
 *3/2
 *当然，这只是加了前2项而已。分子分母要求互质。
 *注意：
 *需要提交的是已经约分过的分数，中间任何位置不能含有空格。
 *请不要填写任何多余的文字或符号。
 *
 *答案：1048575/524288
 *
 *思路：循环20次，每次将前一个数的分子分母*2，分子加1；
 *最后对结果进行约分，算出公式，用BigInteger的相关方法求也行
 *
 */

public class problem1 {
    public static void main(String args[]){
        long fenzi=1;
        long fenmu=1;
        for(int i=1;i<20;i++){
            fenzi*=2;
            fenmu*=2;
            fenzi+=1;
        }
        //约分
        for(long i=1;i<=fenmu;i++){
            if(fenzi%i==0 && fenmu%i==0){
                fenzi/=i;
                fenmu/=i;
            }
        }
        System.out.println(fenzi+"/"+fenmu);
    }
}
