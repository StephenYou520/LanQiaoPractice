package 第8届决赛真题.JavaA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/***
 *
 标题：发现环


 小明的实验室有N台电脑，编号1~N。原本这N台电脑之间有N-1条数据链接相连，恰好构成一个树形网络。在树形网络上，任意两台电脑之间有唯一的路径相连。

 不过在最近一次维护网络时，管理员误操作使得某两台电脑之间增加了一条数据链接，于是网络中出现了环路。环路上的电脑由于两两之间不再是只有一条路径，使得这些电脑上的数据传输出现了BUG。

 为了恢复正常传输。小明需要找到所有在环路上的电脑，你能帮助他吗？

 输入
 -----
 第一行包含一个整数N。
 以下N行每行两个整数a和b，表示a和b之间有一条数据链接相连。

 对于30%的数据，1 <= N <= 1000
 对于100%的数据, 1 <= N <= 100000， 1 <= a, b <= N

 输入保证合法。

 输出
 ----
 按从小到大的顺序输出在环路上的电脑的编号，中间由一个空格分隔。


 样例输入：
 5
 1 2
 3 1
 2 4
 2 5
 5 3

 样例输出：
 1 2 3 5

 资源约定：
 峰值内存消耗 < 256M
 CPU消耗  < 1000ms


 请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
 注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
 注意：主类的名字必须是：Main，否则按无效代码处理。


 * 思路：该问题是一个无向图找环的问题
 * 深度遍历所有节点，使用哈希表记录访问过的节点，如果访问了多次，则说明该节点在环上。
 * 要注意的是jdk1.6与jdk1.8存在不同，它的HashMap的keySet存在基本值
 *
 */
public class problem4 {
    static ArrayList<Integer> res=new ArrayList();
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        HashMap<Integer,ArrayList<Integer>> map=new HashMap();
        //HashMap<Integer,Integer> path=new HashMap();
        for(int i=0;i<n;i++){
            int start=in.nextInt();
            int target=in.nextInt();
            ArrayList<Integer> list1=new ArrayList();
            //ArrayList<Integer> list2=new ArrayList();
            if(map.containsKey(start)) list1=map.get(start);
            list1.add(target);
            map.put(start,new ArrayList(list1));
//			if(map.containsKey(target)) list2=map.get(target);
//			list1.add(start);
//			map.put(target,list2);
        }
        for(int i:map.keySet()){
            HashMap<Integer,Integer> path=new HashMap();
            dfs(map,path,i);
        }
        Integer[] print=res.toArray(new Integer[0]);
        Arrays.sort(print);
        for(int i:print){
            System.out.print(i+" ");
        }
    }
    /***
     * 判断该点是否在环上
     * @param map
     * @param path
     * @param res
     * @param key
     * @return
     */
    public static void dfs(HashMap<Integer,ArrayList<Integer>> map,HashMap<Integer,Integer> path,int key){
        ArrayList<Integer> temp=map.get(key);
        //要判断是否为空
        if(temp==null) return ;
        //经过两次的点说明在环上
        //经过三次为程序遍历结束条件
        if(path.containsKey(key)){
            int c=path.get(key);
            c++;
            if(c==2 && !res.contains(key)) res.add(key);
            path.put(key,c);
            if(c==3) return ;

        }
        else path.put(key,1);
        for(int i:temp){
            dfs(map,path,i);
        }
    }
}
