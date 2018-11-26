
public class StudentManagementSystem {
	Student[] roster;
	int studentCount = 0;

	StudentManagementSystem() {
		roster = new Student[10];
	}

	Student[] getStudents() {
		// TODO Auto-generated method stub
		Student[] temp = new Student[studentCount];
		for (int i = 0; i < studentCount; i++) {
			temp[i] = roster[i];
		}
		return temp;
	}

	void addStudent(Student student) {
		// TODO Auto-generated method stub
		roster[studentCount] = student;
		studentCount++;
	}

	public void registerAll(Course eecs2030) {
		// TODO Auto-generated method stub
		for (int i = 0; i < studentCount; i++) {
			roster[i].register(eecs2030);
		}
	}

}
