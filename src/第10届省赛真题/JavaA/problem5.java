package 第10届省赛真题.JavaA;

import java.math.BigInteger;

/***
 * 【问题描述】 RSA 是一种经典的加密算法。它的基本加密过程如下。
 * 首先生成两个质数 p, q，令 n = p·q，设 d 与 (p−1)·(q−1) 互质，则可找到 e 使得 d·e 除 (p−1)·(q−1) 的余数为 1。
 * n, d, e 组成了私钥，n, d 组成了公钥。
 * 当使用公钥加密一个整数 X 时（小于 n），计算 C = X的d次方 mod n，则 C 是加 密后的密文。
 * 当收到密文 C 时，可使用私钥解开，计算公式为 X = C的e次方 mod n。
 * 例如，当 p = 5, q = 11, d = 3 时，n = 55, e = 27。
 * 若加密数字 24，得 24的3次方 mod 55 = 19。
 * 解密数字 19，得 19的27次方 mod 55 = 24。
 * 现在你知道公钥中 n = 1001733993063167141, d = 212353，同时你截获了 别人发送的密文 C = 20190324，请问，原文是多少？
 * 【答案提交】这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一 个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
 *
 * 答案：579706994112328949
 *
 *
 * 思路：要求原文，也就是X，根据公式X = C的e次方 mod n，其中C和n都已知了，问题就转化为求e。
 * 已知(p−1)·(q−1)%(d*e)==1,所以只要我们求出p、q问题就能得解。
 * 求得：
 * p:1123984201,q:891234941
 * k:174637
 * e:823816093931522017
 * X:579706994112328949
 * （如果真的比赛遇到这题，我觉得我应该放弃）
 */
public class problem5 {
    public static void main(String[] args){
        long n=new Long("1001733993063167141");
        //long c=20190324;
        long p=3;
        long q=3;
        long d=212353;
        //求p、q
        //首先我们知道2是质数，除此之外，所有正偶数都不是质数，为了减小计算量，我们只遍历奇数即可。
        for(;q<Math.sqrt(n);q+=2){
            if(n%q==0){
                p=n/q;
                break;
            }
        }
        System.out.println("p:"+String.valueOf(p)+",q:"+String.valueOf(q));

        //计算(p-1)*(q-1)
        long p_q=(p-1)*(q-1);
        //求e
        //d*e=k*p_q+1;k为某个正数
        long e=1;
        long k=1;
        BigInteger P_Q=new BigInteger(String.valueOf(p_q));
        BigInteger D=new BigInteger(String.valueOf(d));
        for(;k<d;k++){
            BigInteger K=new BigInteger(String.valueOf(k));
            if(K.multiply(P_Q).add(new BigInteger("1")).mod(D).equals(new BigInteger("0"))){
                e=K.multiply(P_Q).add(new BigInteger("1")).divide(D).longValue();
                k=K.longValue();
                break;
            }
        }
        System.out.println("k:"+String.valueOf(k));
        System.out.println("e:"+String.valueOf(e));
        //求X
        BigInteger C=new BigInteger("20190324");
        BigInteger E=new BigInteger(String.valueOf(e));
        BigInteger N=new BigInteger(String.valueOf(n));

        BigInteger X=C.modPow(E,N);

        System.out.println("X:"+X.toString());


    }
}
