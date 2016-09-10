
public class chess3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][][] chess = new int[][][]{{{0,0,0},{0,1,0},{1,0,1}},{{0,1,0},{0,1,1},{0,0,1}},{{0,1,0},{0,0,1},{1,0,0}},{{0,1,0},{0,1,1},{1,0,0}}};
//		int[] chess2 = new int[][]{0,1,0}{0,1,1}{0,0,1};
//		int[] chess3 = new int[][]{0,1,0}{0,1,1}{1,0,0};
		
		int isWinner = 2;
		for(int i=0;i<4;i++)
		{
			isWinner = horizontal(chess[i]);
			System.out.print("horizontal:");
			outprint(isWinner);
			isWinner = vertical(chess[i]);
			System.out.print("vertical:");
			outprint(isWinner);
			
		}		

	}
	public static void outprint(int status)
	{
		switch (status)
		{
		case 0: System.out.println("O");
				break;
		case 1:System.out.println("X");
				break;
		case 2:System.out.println("NIL");
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
}
