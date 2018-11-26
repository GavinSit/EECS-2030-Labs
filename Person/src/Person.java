
//A template for creating Person objects
public class Person {
	
	//Attributes
	int age;
	double weight; //assume in kg 
	double height; //assume in metre
	
	public Person(double weight, double height) {
		this.weight = weight;
		this.height = height;
		
	}
	
	public double getBMI() {
		double bmi = this.weight/(this.height*this.weight);
		return bmi;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	

}
