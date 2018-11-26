
public class Birthday {

	private int month;
	private int day;

	public Birthday(int m, int d) {
		if (m >= 1 && m <= 12 && d >= 1 && m <= 31) {
			month = m;
			day = d;
		}else {
			throw new IllegalArgumentException();
		}
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	@Override
	public String toString() {
		String date = "";
		switch (month) {
		case 1:
			date = "January";
			break;
		case 2:
			date = "February";
			break;
		case 3:
			date = "March";
			break;
		case 4:
			date = "April";
			break;
		case 5:
			date = "May";
			break;
		case 6:
			date = "June";
			break;
		case 7:
			date = "July";
			break;
		case 8:
			date = "August";
			break;
		case 9:
			date = "September";
			break;
		case 10:
			date = "October";
			break;
		case 11:
			date = "November";
			break;
		case 12:
			date = "December";
			break;
		default:
			date = "Invalid Month";
			break;
		}

		date = date + " " + day;

		return date;
	}

	public boolean equals(Object obj) {	
		if (this == obj) { //same object different name
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) { //null or not the same class
			return false;
		}
		
		Birthday other = (Birthday) obj;
		return this.getMonth() == other.getMonth() && this.getDay() == other.getDay();
	}
}
