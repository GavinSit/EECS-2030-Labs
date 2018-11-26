
public class ResidentStudent extends Student {
	private double premiumRate;
	
	ResidentStudent(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}

	void setPremiumRate(double d) {
		// TODO Auto-generated method stub
		this.premiumRate = d;		
	}

	double getPremiumRate() {
		// TODO Auto-generated method stub
		return this.premiumRate;
	}
	
	double getTuition() {
		double total = super.getTuition();
		return total*premiumRate;
	}

}
