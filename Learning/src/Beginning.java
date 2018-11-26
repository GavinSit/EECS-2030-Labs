import java.util.Scanner; //this imports the tool that gets user input

public class Beginning {
	public static void main(String args[]) { //main method
		Scanner scan = new Scanner(System.in); //declares the scanner

		//variabletype variable name = variable value
		String output = ""; 
		int integer = 9; 
		double decimalpoints = 0.23; 
		boolean trueorfalse = true; 

		do {
			System.out.println("type a b or c");
			output = scan.nextLine(); 

			System.out.println("You typed " + output); 


			if (output.equals("a")) { 
				System.out.println("apple");

			}else if (output.equals("b")) {
				System.out.println("banana");

			}else if (output.equals("c")) {
				System.out.println("car");

			}else {
				System.out.println("that wasnt a choice");
			}
		}while(!output.equals("d")); 

		scan.close(); 
	}
}
