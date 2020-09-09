package 第9届省赛真题.JavaA;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/***
 *
 标题：航班时间

 【问题背景】
 小h前往美国参加了蓝桥杯国际赛。小h的女朋友发现小h上午十点出发，上午十二点到达美国，于是感叹到“现在飞机飞得真快，两小时就能到美国了”。

 小h对超音速飞行感到十分恐惧。仔细观察后发现飞机的起降时间都是当地时间。由于北京和美国东部有12小时时差，故飞机总共需要14小时的飞行时间。

 不久后小h的女朋友去中东交换。小h并不知道中东与北京的时差。但是小h得到了女朋友来回航班的起降时间。小h想知道女朋友的航班飞行时间是多少。

 【问题描述】
 对于一个可能跨时区的航班，给定来回程的起降时间。假设飞机来回飞行时间相同，求飞机的飞行时间。

 【输入格式】
 从标准输入读入数据。

 一个输入包含多组数据。

 输入第一行为一个正整数T，表示输入数据组数。

 每组数据包含两行，第一行为去程的 起降 时间，第二行为回程的 起降 时间。

 起降时间的格式如下

 h1:m1:s1 h2:m2:s2
 或
 h1:m1:s1 h3:m3:s3 (+1)
 或
 h1:m1:s1 h4:m4:s4 (+2)
 表示该航班在当地时间h1时m1分s1秒起飞，

 第一种格式表示在当地时间 当日 h2时m2分s2秒降落

 第二种格式表示在当地时间 次日 h3时m3分s3秒降落。

 第三种格式表示在当地时间 第三天 h4时m4分s4秒降落。

 对于此题目中的所有以 h:m:s 形式给出的时间, 保证 ( 0<=h<=23, 0<=m,s<=59 ).

 【输出格式】
 输出到标准输出。

 对于每一组数据输出一行一个时间hh:mm:ss，表示飞行时间为hh小时mm分ss秒。

 注意，当时间为一位数时，要补齐前导零。如三小时四分五秒应写为03:04:05。

 【样例输入】
 3
 17:48:19 21:57:24
 11:05:18 15:14:23
 17:21:07 00:31:46 (+1)
 23:02:41 16:13:20 (+1)
 10:19:19 20:41:24
 22:19:04 16:41:09 (+1)

 【样例输出】
 04:09:05
 12:10:39
 14:22:05

 【限制与约定】
 保证输入时间合法，飞行时间不超过24小时。

 资源约定：
 峰值内存消耗（含虚拟机） < 256M
 CPU消耗  < 1000ms


 请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
 不要使用package语句。不要使用jdk1.7及以上版本的特性。
 主类的名字必须是：Main，否则按无效代码处理。



 * 思路：对于每一次行程，先要判断是否跨时区
 * 我们可以设时差为gap,北京时间为x，中东时间为y，所以y对应的北京时间为y-gap
 * 因为往返飞行时间一样，我们都用北京时间来算飞行时间，可以得到：y1-gap-x1=x2-(y2-gap),可以得到，gap=(y1+y2-x1-x2)/2=(y1-x1-(x2-y2))/2
 *	飞行时间=y1-gap-x1=(y1-x1+x2-y2)/2,即我们直接算每次起降的时间差，相加除以二就可以得到飞行时间
 *	隔m天，就在y上加m*24
 *	考虑使用Date和SimpleDate相关类进行计算
 */
public class problem6 {
    public static SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
    public static void main(String[] args) throws ParseException{
        Scanner in=new Scanner(System.in);
        String z=in.nextLine();
        int n=Integer.valueOf(z);
        //in.nextLine();
        for(int i=0;i<n;i++){
            String time1=in.nextLine();
            String time2=in.nextLine();
            long t1=compute(time1);
            long t2=compute(time2);
            long res=(t2+t1)/2;
            //System.out.println(time1);
            System.out.printf("%02d:%02d:%02d\n",res/3600,res/60%60,res%60);

        }


    }
    public static long compute(String time) throws ParseException{
        String[] temp=time.split(" ");
        SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
        Date t1=format.parse(temp[0]);
        Date t2=format.parse(temp[1]);
        //判断是否跨天
        int d=0;
        if(temp.length==3){
            if(temp[2].contains("2")) d=2;
            if(temp[2].contains("1")) d=1;
        }

        return d*24*3600+t2.getTime()/1000-t1.getTime()/1000;
    }
}
