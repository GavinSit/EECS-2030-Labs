
public class PersonTester {
	public static void main(String [] args) {
		//develop executable test case for person
		
		Person jim = new Person(45.0,175.4);
		System.out.println(jim.age);
		System.out.println(jim.weight);
		System.out.println(jim.height);
		Person Janet = jim;
				
		System.out.println(jim.getBMI());
		System.out.println(Janet.getBMI());
		
		Person Gavin = new Person(80, 150);
		jim = Gavin; 
		Gavin.setAge(20);
		System.out.println(Gavin.getAge());
		System.out.println(jim.getAge());
		
		
		
	}
}
