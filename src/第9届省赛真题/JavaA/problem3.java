package 第9届省赛真题.JavaA;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;

/***
 * 标题：复数幂

 设i为虚数单位。对于任意正整数n，(2+3i)^n 的实部和虚部都是整数。
 求 (2+3i)^123456 等于多少？ 即(2+3i)的123456次幂，这个数字很大，要求精确表示。



 答案写成 "实部±虚部i" 的形式，实部和虚部都是整数（不能用科学计数法表示），中间任何地方都不加空格，实部为正时前面不加正号。(2+3i)^2 写成: -5+12i，
 (2+3i)^5 的写成: 122-597i


 注意：需要提交的是一个很庞大的复数，不要填写任何多余内容。

 *答案：
 *
 *思路：该放弃时就得放弃
 *首先我们将(2+3i)^123456展开，可以得到res=(cnk)*(3^k)*(i^k)*(2^(n-k)),k=0,1,2,3,...
 *当k为奇数时，这一项是虚数
 *当k为偶数时，这一项为偶数
 *所以我们可以分开计算，用BigInteger避免溢出。
 *
 */
public class problem3 {
    public static void main(String[] args) throws FileNotFoundException{
        PrintStream ps=new PrintStream(new FileOutputStream("res.txt"));
        System.setOut(ps);  //文件输出

        BigInteger FU1=new BigInteger("-1");
        BigInteger TWO=new BigInteger("2");
        BigInteger THREE=new BigInteger("3");

        BigInteger xu=new BigInteger("0");
        BigInteger shi=new BigInteger("0");
        int n=123456;
        //当k为奇数 时，计算虚部
        for(int i=1;i<=n;i+=2){
            BigInteger temp=calc(i,n);
            temp=temp.multiply(THREE.pow(i)).multiply(TWO.pow(n-i));
            int x=n/2;
            if(x%2!=0) temp.multiply(FU1);
            xu=xu.add(temp);
        }
        //当k为偶数 时，计算实部
        for(int i=0;i<=n;i+=2){
            BigInteger temp=calc(i,n);
            temp=temp.multiply(THREE.pow(i)).multiply(TWO.pow(n-i));
            int x=n/2;
            if(x%2!=0) temp.multiply(FU1);
            shi=shi.add(temp);
        }
        System.out.println("虚部："+xu.toString());

        System.out.println("实部："+shi.toString());
    }
    //算cnk
    public static BigInteger calc(int k,int n){
        BigInteger np=new BigInteger("1");
        BigInteger kp=new BigInteger("1");
        BigInteger nkp=new BigInteger("1");
        //n的阶乘
        for(int i=1;i<=n;i++){
            np.multiply(BigInteger.valueOf(i));
            //k的阶乘
            if(i<=k){
                kp.multiply(BigInteger.valueOf(i));
            }
            //n-k的阶乘
            if(i<=n-k){
                nkp.multiply(BigInteger.valueOf(i));
            }
        }
        if(k==0) return np;
        else if(k==n) return new BigInteger("1");
        else return np.divide(kp.multiply(nkp));
    }
}
