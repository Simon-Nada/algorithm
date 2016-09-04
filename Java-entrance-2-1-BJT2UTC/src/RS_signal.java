import java.util.Scanner;

public class RS_signal {

	public static void main(String[] args) 
	{
		int n;
		int Readablity;
		int Strength;
		String string_RE = new String("");
		String string_ST = new String(""); 
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		Readablity= n/10;
		Strength = n%10;
		
		switch (Readablity)
		{
		case 1: 
			string_RE = new String("unreadable");
			break;
		case 2:
			string_RE = new String("Barely readable, occasional words distinguishable");
			break;
		case 3:
			string_RE = new String("Readable with considerable difficulty");
			break;
		case 4:
			string_RE = new String("Readable with practically no difficulty");
			break;
		case 5:
			string_RE = new String("Perfectly readable");
			break;	
		}		
		
		switch (Strength)
		{
		case 1: 
			string_ST = new String("Faint signals, barely perceptible");
			break;
		case 2:
			string_ST = new String("Very weak signals");
			break;
		case 3:
			string_ST = new String("Weak signals");
			break;
		case 4:
			string_ST = new String("Fair signals");
			break;
		case 5:
			string_ST = new String("Fairly good signals");
			break;	
		case 6: 
			string_ST = new String("Good signals");
			break;
		case 7:
			string_ST = new String("Moderately strong signals");
			break;
		case 8:
			string_ST = new String("Strong signals");
			break;
		case 9:
			string_ST = new String("Extremely strong signals");
			break;
		}
		
	System.out.println(string_ST +", "+string_RE+".");
		
	}
}