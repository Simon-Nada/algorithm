import java.util.Scanner;
public class num_characteristic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int num;
		int tmp_num;
		int shuwei=1;
		int i=0;
		int[] bin;
		int bin2=1;
		int outcome=0;
		bin = new int[10];
		num = in.nextInt();
		
		while(num>0)
		{
			tmp_num = num%10;//取最低位
			if ((tmp_num%2==0 && shuwei%2==0)||(tmp_num%2!=0 && shuwei%2!=0)) //判断为偶数
			{
				bin[i]=1;
			}
			else		//判断为奇数
			{
				bin[i]=0;
			}
			num = num/10;
			shuwei++;
			i++;
		}
		for(int j=0;j<10;j++)
		{
		if (bin[j]==1)
				{
			outcome += bin2;
				}
		bin2 *=2;
		//System.out.print(bin[j]+" ");
		}
		System.out.print(outcome);
	}

}
