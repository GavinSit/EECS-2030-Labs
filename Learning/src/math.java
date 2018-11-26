import java.util.Scanner;

public class math {
	public static void main(String[] args) {
		int x, y;
		
		Scanner inputTaker = new Scanner(System.in);
		
		x = 9;
		y = 4;
		
		int j;
		
		j = inputTaker.nextInt();
		
		//add them together
		int z = x + y;
		System.out.println(z);
		//right now z is 13
		z = z + 7;
		System.out.println(z);
		//z = 20
		z = y - x;
		System.out.println(z);
		//z = -5
		z = x*y;
		System.out.println(z);
		//z = 36
		z = x/3;
		System.out.println(z);
		//3
		z = 10 % 3;
		System.out.println(z);
		//1
		
		double a, b, g;
		a = 12.34;
		b = 3.1111;

		g = a + b;
		System.out.println(g);

	}

}
