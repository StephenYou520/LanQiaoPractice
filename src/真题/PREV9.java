package 真题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/***
 * 问题描述
 * 很久以前，T王国空前繁荣。为了更好地管理国家，王国修建了大量的快速路，用于连接首都和王国内的各大城市。
 *
 * 为节省经费，T国的大臣们经过思考，制定了一套优秀的修建方案，使得任何一个大城市都能从首都直接或者通过其他大城市间接到达。同时，如果不重复经过大城市，从首都到达每个大城市的方案都是唯一的。
 *
 * J是T国重要大臣，他巡查于各大城市之间，体察民情。所以，从一个城市马不停蹄地到另一个城市成了J最常做的事情。他有一个钱袋，用于存放往来城市间的路费。
 *
 * 聪明的J发现，如果不在某个城市停下来修整，在连续行进过程中，他所花的路费与他已走过的距离有关，在走第x千米到第x+1千米这一千米中（x是整数），他花费的路费是x+10这么多。也就是说走1千米花费11，走2千米要花费23。
 *
 * J大臣想知道：他从某一个城市出发，中间不休息，到达另一个城市，所有可能花费的路费中最多是多少呢？
 *
 * 输入格式
 * 输入的第一行包含一个整数n，表示包括首都在内的T王国的城市数
 *
 * 城市从1开始依次编号，1号城市为首都。
 *
 * 接下来n-1行，描述T国的高速路（T国的高速路一定是n-1条）
 *
 * 每行三个整数Pi, Qi, Di，表示城市Pi和城市Qi之间有一条高速路，长度为Di千米。
 *
 * 输出格式
 * 输出一个整数，表示大臣J最多花费的路费是多少。
 *
 * 样例输入1
 * 5
 * 1 2 2
 * 1 3 1
 * 2 4 5
 * 2 5 4
 * 样例输出1
 * 135
 * 输出格式
 * 大臣J从城市4到城市5要花费135的路费。
 *
 * 思路：有n-1条高速公路，且两两相连。问题本质上是求图中任意两点的最大加权距离，即多源最大路径问题。
 * 答案：最后只能通过75%的用例，其余超时
 */
public class PREV9 {
    public static int res=0;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        HashMap<Integer, ArrayList<int[]>> map=new HashMap<>();
        for(int i=0;i<n-1;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            int c=in.nextInt();
            ArrayList<int[]> t1=map.getOrDefault(a,new ArrayList<int[]>());
            int[] tx1=new int[2];
            tx1[0]=b;
            tx1[1]=c;
            t1.add(tx1);
            map.put(a,t1);
            ArrayList<int[]> t2=map.getOrDefault(b,new ArrayList<int[]>());
            int[] tx2=new int[2];
            tx2[0]=a;
            tx2[1]=c;
            t2.add(tx2);
            map.put(b,t2);
        }

        for(Integer i:map.keySet()) {
            boolean[] path=new boolean[n+1];
            dfs(map, path, 0, i);
            //System.out.println(map.get(i));
        }
        //System.out.println(res);
        System.out.println(cost(res));
    }

    /***
     * 计算最远里程
     * @param map
     * @param path
     * @param sum
     * @param i
     */
    public static void dfs(HashMap<Integer, ArrayList<int[]>> map,boolean[] path,int sum,int i){
            path[i]=true;
            ArrayList<int[]> t=map.get(i);
            for(int[] lt:t){
                //System.out.println(lt);
                if(path[lt[0]]) continue;
                sum+=lt[1];
                res=Math.max(sum,res);
                dfs(map,path,sum,lt[0]);
                sum-=lt[1];
            }
            path[i]=false;
    }

    /***
     * 计算花费
     * @param x
     * @return
     */
    public static int cost(int x){
        int res=0;
        for(int i=1;i<=x;i++) res+=i+10;
        return res;
    }
}
