
public class Student {
	final int MAX_COURSES = 5;
	Course[] courses;
	String name;
	int courseCount = 0;

	
	Student (String name){
		this.name = name;
		courses = new Course[MAX_COURSES];
	}
	
	
	Course[] getCourses() {
		// TODO Auto-generated method stub
		Course[] temp = new Course[courseCount];
		
		for (int i = 0; i < courseCount; i ++) {
			temp[i] = courses[i];
		}
		return temp;
	}

	void register(Course eecs2030) {
		// TODO Auto-generated method stub
		courses[courseCount] = eecs2030;
		courseCount ++;
	}


	double getTuition() {
		// TODO Auto-generated method stub
		double total = 0;
		for (int i = 0; i < courseCount; i++) {
			total += courses[i].getFee();
		}
		return total;
	}


	void drop(Course eecs2030) {
		// TODO Auto-generated method stub
		for(int i = 0; i < courseCount; i ++) {
			if(courses[i].getName().equals(eecs2030.getName())) {
				for(int j = i; j < courseCount - 1; j ++) {
					courses[j] = courses[j+1];
				}
				courses[courseCount] = null;
			}
		}
		courseCount --;
	}

}
