/*
题目内容：
嗯，就是视频里说的那个井字棋。视频里说了它的基本思路，现在，需要你把它全部实现出来啦。
你的程序先要读入一个整数n，范围是[3,100]，这表示井字棋棋盘的边长。比如n=3就表示是一个3x3的棋盘。然后
，要读入n行，每行n个数字，每个数字是1或0，依次表示[0,0]到[n-1,n-1]位置上的棋子。1表示X，0表
示O（大写字母O）。
你的程序要判断其中是否存在某一方获胜，获胜的条件是存在整行或整列或整条对角线或整条反对角
线上是相同的棋子。如果存在，则输出代表获胜一方字母：X或O（大写字母X或O）；如果没有任何一方获胜
注意：所给的棋盘上的棋子分布可能出现同一个棋子有多处满足获胜的条件，但是不会出现两种棋子都获胜的情况。

输入格式:

一个代表棋盘大小的数字n，后面跟上nxn个0或1的数字。

输出格式：

三种输出之一：

    X
    O
    NIL

均为大写字母。


输入样例：

    4
    1 0 0 1
    0 1 0 0
    0 0 1 0
    1 0 0 1


输出样例：

    X


 */
import java.util.Scanner;

public class chess_final {

	public static void main(String[] args) {
			
		// TODO Auto-generated method stub
				Scanner in = new Scanner(System.in);
				
				int num_line;
				num_line = in.nextInt();
				int[][] qipan = new int[num_line][num_line];
				int[] tmp = new int[num_line];
				int status=2;
				
				for(int i=0; i<num_line;i++) //输入矩阵
				{
					for(int j=0;j<num_line;j++)
					{
						qipan[i][j]= in.nextInt();
					}
				}		
				
				if(horizontal(qipan)!=2)
				{
					System.out.println("horizontal");
					outprint(horizontal(qipan));
				}
				else if(vertical(qipan)!=2)
				{
					System.out.println("vertical");
					outprint(vertical(qipan));
				}
				else if(inclined(qipan)!=2)
				{
					System.out.println("inclined");
					outprint(inclined(qipan));
				}
				else
				{
					System.out.println("none");
					outprint(inclined(qipan));
				}
	}
	public static void outprint(int status)
	{
		switch (status)
		{
		case 0: System.out.print("O ");
				break;
		case 1:System.out.print("X ");
				break;
		case 2:System.out.print("NIL ");
		}
	}
	public static int horizontal(int[][] a) //判断横行
	{
		int flag_x;
		int flag_o;
		for(int i=0;i<a.length;i++)
		{
			flag_x =1;
			flag_o =0;
			for(int j=0;j<a.length;j++)
			{
				flag_x *= a[i][j];
				flag_o += a[i][j];
			}
			if(flag_x == 1)
			{
				return 1;
			}
			else if(flag_o == 0)
			{
				return 0;
			}				
		}
		return 2;
	}
	public static int vertical(int[][] a) //判断纵列
	{
		int flag_x;
		int flag_o;
		for(int j=0;j<a.length;j++)
		{
			flag_x =1;
			flag_o =0;
			for(int i=0;i<a.length;i++)
			{
				flag_x *= a[i][j];
				flag_o += a[i][j];
			}
			if(flag_x == 1)
			{
				return 1;
			}
			else if(flag_o == 0)
			{
				return 0;
			}				
		}
		return 2;
	}
	public static int inclined(int[][] a)
	{
		int flag_x_zheng,flag_o_zheng,flag_x_fan,flag_o_fan;
		
		flag_x_zheng =1;
		flag_o_zheng =0;
		flag_x_fan = 1;
		flag_o_fan = 0;
		
		for(int j=0;j<a.length;j++)
		{
			flag_x_zheng *= a[j][j];
			flag_o_zheng += a[j][j];
			flag_x_fan *= a[j][a.length-j-1];
			flag_o_fan += a[j][a.length-j-1];
			
		}
		
		if(flag_x_zheng == 1)
		{
//			System.out.println("1");
			return 1;
		}
		else if(flag_o_zheng == 0)
		{
//			System.out.println("2");
			return 0;
		}
		
		
		if(flag_x_fan == 1)
		{
//			System.out.println("3");
			return 1;
		}
		else if(flag_o_fan == 0)
		{
//			System.out.println("4");
			return 0;
		}	
	
	return 2;
		
		
		
	}
}
