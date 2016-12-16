package percolation;

import java.util.Random;
import java.lang.*;

import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStats {
	private int count_in;
//	private int count_out;
	private int n;
	private int trials;
	private double[] array;
	
	private Random random  = new Random();
//	private Percolation a = new Percolation(n);
	
	public PercolationStats(int n, int trials)    // perform trials independent experiments on an n-by-n grid
	{  
		array = new double[trials];
		this.n = n;
		this.trials = trials;
		for(int i=0;i<trials;i++)
		{
			Percolation a = new Percolation(n);
			count_in = 0;
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
			array[i] = (double)count_in/(n*n);
			
		}
	}
		
		public double mean()                          // sample mean of percolation threshold
		{
			return StdStats.mean(array);
		}
		
		public double stddev()                        // sample standard deviation of percolation threshold
		{
			return StdStats.stddev(array);
		}
		
		public double confidenceLo()                  // low  endpoint of 95% confidence interval
		{
			return this.mean()-1.96*this.stddev()/Math.sqrt(this.trials);
		}
		public double confidenceHi()                  // high endpoint of 95% confidence interval
		{
			return this.mean()+1.96*this.stddev()/Math.sqrt(this.trials);
		}

		public static void main(String[] args)    // test client (described below)
		{
			Stopwatch timer = new Stopwatch();
			
			PercolationStats test = new PercolationStats(200,100);  //n,T
			
			double time = timer.elapsedTime();
			System.out.println("elapsedTime:"+time);
			System.out.println("mean							=	"+test.mean());
			System.out.println("stddev							=	"+test.stddev());
			System.out.println("95% confidence interval	= 	"+test.confidenceLo()+", "+test.confidenceHi());
		}

}
