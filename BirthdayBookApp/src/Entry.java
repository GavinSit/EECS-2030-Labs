
public class Entry {

	private String name;
	private Birthday birthday;

	public Entry(String s, Birthday birthday) {
		name = s;
		this.birthday = birthday;
	}
	
	public Entry(String name, int month, int year) {
		this.name = name;
		this.birthday = new Birthday(month, year);
	}

	public String getName() {
		return name;
	}

	public Birthday getBirthday() {
		return birthday;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setBirthday(int m, int d) {
		//Birthday birthday = new Birthday(m,d);
		this.birthday = new Birthday(m,d);
	}
	
	public void setBirthday(Object obj) {
		this.birthday = (Birthday) obj;
	}
	
	public String toString() {
		return name + " was born on " + birthday.toString();
	}
	
	public boolean equals(Object obj) {
		if (this.birthday == obj) {
			return true;
		}else if (this.getClass() != obj.getClass() || obj == null) {
			return false;
		}
		
		Entry other = (Entry) obj;
		return this.birthday.getMonth() == other.birthday.getMonth() && this.birthday.getDay() == other.birthday.getDay() && this.name.equals(other.name);
	}


}
