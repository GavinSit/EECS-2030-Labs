
public class NonResidentStudent extends Student {
	private double discountRate;

	NonResidentStudent(String name) {
		super(name);
	}

	double getDiscountRate() {
		return discountRate;
	}

	void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	double getTuition() {
		double total = super.getTuition();
		return total * discountRate;
	}

}
