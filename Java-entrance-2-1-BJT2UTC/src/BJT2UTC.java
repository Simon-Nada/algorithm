import java.util.Scanner;
public class BJT2UTC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int BJT;
		int UTC;
		
		Scanner in = new Scanner(System.in);
		BJT = in.nextInt();
		if (BJT>800)
		{
			UTC = BJT - 800;
		}
		else
		{
			UTC = BJT +2400 - 800;
		}
		System.out.println(UTC);
	}

}
