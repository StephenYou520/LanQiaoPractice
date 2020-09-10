package 第9届省赛真题.JavaA;

import java.util.Scanner;

/***
 *
 标题：全球变暖

 你有一张某海域NxN像素的照片，"."表示海洋、"#"表示陆地，如下所示：

 .......
 .##....
 .##....
 ....##.
 ..####.
 ...###.
 .......

 其中"上下左右"四个方向上连在一起的一片陆地组成一座岛屿。例如上图就有2座岛屿。

 由于全球变暖导致了海面上升，科学家预测未来几十年，岛屿边缘一个像素的范围会被海水淹没。具体来说如果一块陆地像素与海洋相邻(上下左右四个相邻像素中有海洋)，它就会被淹没。

 例如上图中的海域未来会变成如下样子：

 .......
 .......
 .......
 .......
 ....#..
 .......
 .......

 请你计算：依照科学家的预测，照片中有多少岛屿会被完全淹没。

 【输入格式】
 第一行包含一个整数N。  (1 <= N <= 1000)
 以下N行N列代表一张海域照片。

 照片保证第1行、第1列、第N行、第N列的像素都是海洋。

 【输出格式】
 一个整数表示答案。


 【输入样例】
 7
 .......
 .##....
 .##....
 ....##.
 ..####.
 ...###.
 .......

 【输出样例】
 1



 资源约定：
 峰值内存消耗（含虚拟机） < 256M
 CPU消耗  < 1000ms


 请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
 不要使用package语句。不要使用jdk1.7及以上版本的特性。
 主类的名字必须是：Main，否则按无效代码处理。

 *思路：广度优先搜索，从.开始，相邻的#都要淹没，记录path，避免重复
 */
public class problem8 {
    public static int res=0;
    public  static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        char[][] graph=new char[n][n];
        for(int i=0;i<n;i++){
            String t=in.next();
            graph[i]=t.toCharArray();
        }
        boolean[][] path=new boolean[n][n];
        int init=0;
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                if(graph[i][j]=='.') bfs(graph,i,j,path);
                if(graph[i][j]=='#') init++;
            }
        }
        System.out.println(init-res);
    }
    public static void bfs(char[][] graph,int i,int j,boolean[][] path){
        //出界或者走过的不用管
        if(i<0 || i>=graph.length || j<0 || j>=graph[i].length || path[i][j]) return ;
        else{
            path[i][j]=true;
            if(graph[i][j]=='#'){
                res++;
            }
            else{
                bfs(graph,i+1,j,path);
                bfs(graph,i-1,j,path);
                bfs(graph,i,j+1,path);
                bfs(graph,i,j-1,path);
            }
        }
    }
}
