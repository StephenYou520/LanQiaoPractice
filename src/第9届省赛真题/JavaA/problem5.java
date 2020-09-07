package 第9届省赛真题.JavaA;

/***
 *
 *
 标题：打印图形

 如下的程序会在控制台绘制分形图（就是整体与局部自相似的图形）。

 当n=1,2,3的时候，输出如下：
 请仔细分析程序，并填写划线部分缺少的代码。

 n=1时：
 o
 ooo
 o

 n=2时：
 o
 ooo
 o
 o  o  o
 ooooooooo
 o  o  o
 o
 ooo
 o

 n=3时：
 o
 ooo
 o
 o  o  o
 ooooooooo
 o  o  o
 o
 ooo
 o
 o        o        o
 ooo      ooo      ooo
 o        o        o
 o  o  o  o  o  o  o  o  o
 ooooooooooooooooooooooooooo
 o  o  o  o  o  o  o  o  o
 o        o        o
 ooo      ooo      ooo
 o        o        o
 o
 ooo
 o
 o  o  o
 ooooooooo
 o  o  o
 o
 ooo
 o

 源程序：

 public class Main
 {
 static void show(byte[][] buf){
 for(int i=0; i<buf.length; i++){
 for(int j=0; j<buf[i].length; j++){
 System.out.print(buf[i][j]==0? ' ' : 'o');
 }
 System.out.println();
 }
 }

 static void draw(byte[][] buf, int x, int y, int size){
 if(size==1){
 buf[y][x] = 1;
 return;
 }

 int n = ________________________ ;  // 填空
 draw(buf, x, y, n);
 draw(buf, x-n, y ,n);
 draw(buf, x+n, y ,n);
 draw(buf, x, y-n ,n);
 draw(buf, x, y+n ,n);
 }

 public static void main(String[] args){
 final int N = 3;
 int t = 1;
 for(int i=0; i<N; i++) t *= 3;

 byte[][] buf = new byte[t][t];
 draw(buf, t/2, t/2, t);
 show(buf);
 }
 }

 注意：只提交划线部分缺少的代码，不要抄写任何已经存在的代码或符号。




 * @author 73833
 *
 */
public class problem5 {
    static void show(byte[][] buf){
        for(int i=0; i<buf.length; i++){
            for(int j=0; j<buf[i].length; j++){
                System.out.print(buf[i][j]==0? ' ' : 'o');
            }
            System.out.println();
        }
    }

    static void draw(byte[][] buf, int x, int y, int size){
        if(size==1){
            buf[y][x] = 1;
            return;
        }

        int n =  size/3;  // 填空
        draw(buf, x, y, n);
        draw(buf, x-n, y ,n);
        draw(buf, x+n, y ,n);
        draw(buf, x, y-n ,n);
        draw(buf, x, y+n ,n);
    }

    public static void main(String[] args){
        final int N = 3;
        int t = 1;
        for(int i=0; i<N; i++) t *= 3;

        byte[][] buf = new byte[t][t];
        draw(buf, t/2, t/2, t);
        show(buf);
    }
}
