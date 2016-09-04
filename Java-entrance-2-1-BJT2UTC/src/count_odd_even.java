import java.util.Scanner;

public class count_odd_even {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		int count_odd=0;
		int count_even=0;
		Scanner in =new Scanner(System.in);
		while(true)
		{
			num = in.nextInt();
			if (num==-1)
			{
				break;
			}
			if(num%2 ==0)
			{
				count_even++;
			}
			else
			{
				count_odd++;
			}
		}
		System.out.println(count_odd+" "+count_even);
	}

}
