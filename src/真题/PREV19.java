package 真题;

import java.util.HashMap;
import java.util.Scanner;

/***
 * 九宫重排
 * 问题描述
 * 　　如下面第一个图的九宫格中，放着 1~8 的数字卡片，还有一个格子空着。与空格子相邻的格子中的卡片可以移动到空格中。经过若干次移动，可以形成第二个图所示的局面。
 *
 * 　　我们把第一个图的局面记为：12345678.
 * 　　把第二个图的局面记为：123.46758
 * 　　显然是按从上到下，从左到右的顺序记录数字，空格记为句点。
 * 　　本题目的任务是已知九宫的初态和终态，求最少经过多少步的移动可以到达。如果无论多少步都无法到达，则输出-1。
 * 输入格式
 * 　　输入第一行包含九宫的初态，第二行包含九宫的终态。
 * 输出格式
 * 　　输出最少的步数，如果不存在方案，则输出-1。
 * 样例输入
 * 12345678.
 * 123.46758
 * 样例输出
 * 3
 * 样例输入
 * 13524678.
 * 46758123.
 * 样例输出
 * 22
 *
 * 思路：回溯+剪枝
 * 对于每次的状态都进行记录，如果走到了已有的状态，就剪掉
 *
 */
public class PREV19 {
    public static int res=Integer.MAX_VALUE;
    public static String target;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String start=in.next();
        target=in.next();
        char[][] graph=new char[3][3];
        int x=0;
        int y=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) {
                graph[i][j]=start.charAt(i*3+j);
                if(graph[i][j]=='.') {
                    x=i;
                    y=j;
                }
            }
        }
        HashMap<String,Integer> map=new HashMap<String, Integer>();
        map.put(start,1);
        boolean r=false;
        if(dfs(graph,map,x-1,y,x,y,0)) r=true;
        if(dfs(graph,map,x+1,y,x,y,0)) r=true;
        if(dfs(graph,map,x,y+1,x,y,0)) r=true;
        if(dfs(graph,map,x,y-1,x,y,0)) r=true;
        //System.out.println(r);
        if(r) System.out.println(res);
        else System.out.println(-1);
    }
    public static String graph_tostring(char[][] graph){
        StringBuilder res=new StringBuilder();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++)
                res.append(graph[i][j]);
        }
        return res.toString();
    }
    public static boolean dfs(char[][] graph,HashMap<String,Integer> map,int i,int j,int si,int sj,int sum){
        String t=graph_tostring(graph);
        if(map.containsKey(t)) return false;
        else map.put(t,1);
        if(t.equals(target)) return true;
        if(i<0 || j<0 || i>=graph.length || j>=graph[0].length || si<0 || sj<0 || si>=graph.length || sj>=graph[0].length) return false;
        else{
            char temp=graph[i][j];
            graph[i][j]=graph[si][sj];
            graph[si][sj]=temp;
            sum++;
            boolean r=false;
            if(dfs(graph,map,i-1,j,i,j,sum)) {
                res=Math.min(res,sum);
                r=true;
            }
            if(dfs(graph,map,i+1,j,i,j,sum)) {
                res=Math.min(res,sum);
                r=true;
            }
            if(dfs(graph,map,i,j+1,i,j,sum)) {
                res=Math.min(res,sum);
                r=true;
            }
            if(dfs(graph,map,i,j-1,i,j,sum)) {
                res=Math.min(res,sum);
                r=true;
            }
            graph[si][sj]=graph[i][j];
            graph[i][j]=temp;
            return r;
        }
    }
}
