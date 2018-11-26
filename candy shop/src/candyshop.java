import java.util.Scanner;
public class candyshop {

	public static void main(String[] args){
		double totalprice = 0;
		String [] candytype = {"M&M", "Areo", "Jawbreakers", "Twisters", "Jelly Beans", "Gummy Bears"}; 
		Double [] candyprice = {2.95, 0.99, 1.25, 3.44, 2.00, 3.00};
		Double tax = 0.13; //tax is 13%
		int selection = 0;
		boolean isnotfinished = true; //whether to continue or not
		String getfinished; 
		Scanner scan = new Scanner(System.in);

		System.out.println("Candies		Price");
		for (int i = 0; i < candytype.length; i ++) {
			System.out.println(i+1 + ". " + candytype[i] + "   " + candyprice[i]);
		}

		System.out.println("Welcome to Gavin's Candy Shop.");

		do {
			System.out.println("Please select the candy that you want by selecting the corresponding number.");
			isnotfinished = true;
			do { 

				selection = scan.nextInt();
				if (selection > candytype.length + 1 || selection < 1) {//if it is outside the range
					System.out.println("invalid selection, please try again");
					isnotfinished = false;
				}

			}while (!isnotfinished); 
			isnotfinished = true;
			totalprice = totalprice + candyprice[selection-1];
			System.out.println("Are there more selections? Y/N");
			do { //loop until correct input is provided
				getfinished = scan.next();
				if (getfinished.equals("Y") || getfinished.equals("y")) {
					isnotfinished = true;
				}else if (getfinished.equals("N") || getfinished.equals("n")) { //don't really need this line as it is true by default
					isnotfinished = false;
				}else { //any other input
					System.out.println("That wasnt a choice, please try again");
				}
			}while(!getfinished.equals("Y") && !getfinished.equals("y") && !getfinished.equals("N") && !getfinished.equals("n"));
		} while(isnotfinished);

		System.out.println("Your total is " + totalprice);
		System.out.println("Tax: " + Math.round(totalprice*tax*100.0)/100.0);
		System.out.println("Grand Total: " + Math.round(totalprice*(1+tax)*100.0)/100.0);
		scan.close();
	}
}
