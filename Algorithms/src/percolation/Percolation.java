package percolation;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.Stopwatch;
import java.util.*;


public class Percolation {

	private int[] status;
	private int N;
	private int row,col;
	private WeightedQuickUnionUF m;
	public Percolation(int n)  	//初始化数组，每个格子表示符为自己的顺序
	{

		this.status = new int[n*n];
		this.N = n;
		m = new WeightedQuickUnionUF(N*N);
	}
	public void open (int row, int col)      //打开格子
	{
//		System.out.printf("open row:%d col:%d\n",row,col);
//		System.out.println("open site:"+(row*N+col));
		this.status[row*N+col] = 1;
		this.row = row;
		this.col = col;
	}
	
	private int setRC(int i)
	{
		if(i<0) return 0;
		else	if(i>N-1) return N-1;
		else return i;
	}
	public boolean isOpen(int row, int col)	//格子是打开的
	{
		if(this.status[row*N+col] == 1)
		{
			return true;
		}
		else return false;
	}
	public boolean isFull(int row, int col)	//格子是关闭的
	{
		if(this.status[row*N+col] == 0)
		{
			return true;
		}
		else return false;
	}
	private void display()
	{
		System.out.println("###########root start############");
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(this.m.find(i*N+j)+" ");
			}
			System.out.printf("\n");
		}
		System.out.println("#########root end#######");
		System.out.println("#########status start#######");
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(this.status[i*N+j]+" ");
			}
			System.out.printf("\n");
		}
		System.out.println("#########status end#######");
		
	}
//	public boolean is
	public boolean percolates() //检查是否联通            //断点记录：判断新增的格子周围的格子是否是空的，如果是，则联通
	{
		if  (this.isOpen(setRC(row-1),col))   m.union(row*N+col, setRC(row-1)*N+col);
		if  (this.isOpen(setRC(row+1),col))   m.union(row*N+col, setRC(row+1)*N+col);
		if  (this.isOpen(row,setRC(col+1)))   m.union(row*N+col, row*N+setRC(col+1));
		if  (this.isOpen(row,setRC(col-1)))   m.union(row*N+col, row*N+setRC(col-1));

		for (int i=0;i<N;i++)       //判断是否导通
		{	
			int tmp = this.m.find(i);
			for(int j=0;j<N;j++)
			{
				if(tmp == this.m.find(N*(N-1)+j))
				{
//					System.out.println("root is "+tmp);
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
		int n;
		int repeat = 20;
		int count_in = 0;
		int count_out = 0;
		Random random  = new Random();
		
		
		for(n=50;true; n+=n){
			Stopwatch timer = new Stopwatch();
			for(int i=0;i<repeat;i++)
			{	
				Percolation a = new Percolation(n);
				while(true)
				{
	
					int row= random.nextInt(n);
					int col = random.nextInt(n);
					if(a.isOpen(row, col))          
					{
						continue;
					}
					a.open(row, col);
					count_in++;	
								  
					if(a.percolates())
					{
						break;
					}
				}
				a.display();
//				System.out.println("count_in:"+count_in);
				count_out +=count_in;
				count_in = 0;
//				System.out.println("count_out:"+count_out);

			}
			double time = timer.elapsedTime();
			
			System.out.println("n:"+n);
			System.out.println((float)count_out/(n*n*repeat));
			System.out.println("elapsedTime:"+time);
		}
		
//		System.out.println("count_out:"+count_out);
//		System.out.println((float)count_out/(n*n*repeat));
	}
}
