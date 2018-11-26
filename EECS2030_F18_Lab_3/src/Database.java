import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* READ THE PDF INSTRUCTION BEFORE GETTING STARTED!
 * 
 * Resources:
 * 	- Tutorial Series on Java Collections (ArrayList and HashMap):
 * 		https://www.eecs.yorku.ca/~jackie/teaching/tutorials/index.html#java_collections
 *	- Recording of lecture on implementing compareTo and using Arrays.sort(...):
 *		https://youtu.be/mDpDRLEy-7Y
 */

public class Database {
	/*
	 * Each entry in a 'departments' map contains a unique department id and its
	 * associated information object.
	 */
	HashMap<Integer, DepartmentInfo> departments;

	int count;
	/*
	 * Each entry in a 'employees' map contains a unique employee id and its
	 * associated information object.
	 */
	HashMap<String, EmployeeInfo> employees;

	/**
	 * Initialize an empty database.
	 */
	public Database() {
		/* Your Task */
		departments = new HashMap<Integer, DepartmentInfo>();
		employees = new HashMap<String, EmployeeInfo>();
	}

	/**
	 * Add a new employee entry.
	 * 
	 * @param id
	 *            id of the new employee
	 * @param info
	 *            information object of the new employee
	 * @throws IdAlreadyExistsExceptoin
	 *             if 'id' is an existing employee id
	 */
	public void addEmployee(String id, EmployeeInfo info) throws IdAlreadyExistsExceptoin {
		/* Your Task */
		if (employees.get(id) != null) {
			throw new IdAlreadyExistsExceptoin(null);
		}
		employees.put(id, info);
	}

	/**
	 * Remove an existing employee entry.
	 * 
	 * @param id
	 *            id of some employee
	 * @throws IdNotFoundException
	 *             if 'id' is not an existing employee id
	 */
	public void removeEmployee(String id) throws IdNotFoundException {
		/* Your Task */
		if (employees.get(id) == null) {
			throw new IdNotFoundException(null);
		}
		employees.remove(id);
	}

	/**
	 * Add a new department entry.
	 * 
	 * @param id
	 *            id of the new department
	 * @param info
	 *            information object of the new department
	 * @throws IdAlreadyExistsExceptoin
	 *             if 'id' is an existing department id
	 */
	public void addDepartment(Integer id, DepartmentInfo info) throws IdAlreadyExistsExceptoin {
		/* Your Task */
		DepartmentInfo obj = (DepartmentInfo) info;
		if (departments.get(id) != null) {
			throw new IdAlreadyExistsExceptoin(null);
		}
		departments.put(id, info);
	}

	/**
	 * Remove an existing department entry.
	 * 
	 * @param id
	 *            id of some employee
	 * @throws IdNotFoundException
	 *             if 'id' is not an existing employee id
	 */
	public void removeDepartment(Integer id) throws IdNotFoundException {
		/* Your Task */
		if (departments.get(id) == null) {
			throw new IdNotFoundException(null);
		}
		departments.remove(id);
	}

	/**
	 * Change the department of employee with id 'eid' to a new department with id
	 * 'did'.
	 * 
	 * You can assume that 'did' denotes a department different from the current
	 * department of the employee denoted by 'eid'.
	 * 
	 * @param eid
	 *            id of some employee
	 * @param did
	 *            id of some department
	 * @throws IdNotFoundException
	 *             if either eid is a non-existing employee id or did is a
	 *             non-existing department id.
	 */
	public void changeDepartment(String eid, Integer did) throws IdNotFoundException {
		/* Your Task */
		if (departments.get(did) == null || employees.get(eid) == null) {
			throw new IdNotFoundException(null);
		}

		employees.get(eid).setDepartmentId(did);
	}

	/**
	 * Retrieve the name of employee with id 'id'.
	 * 
	 * @param id
	 *            id of some employee
	 * @return name of the employee with id 'id'
	 * @throws IdNotFoundException
	 *             if 'id' is not an existing employee id
	 */
	public String getEmployeeName(String id) throws IdNotFoundException {
		/* Your Task */
		if (employees.get(id) == null) {
			throw new IdNotFoundException(null);
		}

		EmployeeInfo einfo = employees.get(id);
		return einfo.getName();
	}

	/**
	 * Retrieve the names of all employees of the department with id 'id'. If 'id' a
	 * non-existing department id, then return an empty list.
	 * 
	 * @param id
	 *            id of some department
	 * @return List of names of employees whose home department has id 'id'
	 */
	public ArrayList<String> getEmployeeNames(Integer id) {
		/* Your Task */
		// get the names given the department id
		ArrayList<String> list = new ArrayList<String>();

		for (String key : employees.keySet()) {
			EmployeeInfo e = employees.get(key);
			if (e.getDepartmentId() == id) {
				list.add(e.getName());
			}
		}
		return list;
	}

	/**
	 * Retrieve an employee's department's information object.
	 * 
	 * @param id
	 *            id of some existing employee
	 * @return The information object of the employee's home department
	 * @throws IdNotFoundException
	 *             if 'id' is not an existing employee id
	 */
	public DepartmentInfo getDepartmentInfo(String id) throws IdNotFoundException {
		/* Your Task */
		if (employees.get(id) == null) {
			throw new IdNotFoundException(null);
		}

		EmployeeInfo e = employees.get(id);
		DepartmentInfo d = departments.get(e.getDepartmentId());
		return d;
	}

	/**
	 * Retrieve a list, sorted in increasing order, the information objects of all
	 * stored employees.
	 * 
	 * Hints: 1. Override the 'comareTo' method in EmployeeInfo class. 2. Look up
	 * the Arrays.sort method in Java API.
	 * 
	 * @return A sorted list of information objects of all employees.
	 */
	public EmployeeInfo[] getSortedEmployeeInfo() {
		/* Your Task */
		EmployeeInfo[] einfo = new EmployeeInfo[employees.size()];
		int count = 0;

		for (String key : employees.keySet()) {
			einfo[count] = employees.get(key);
			System.out.println("einfo: " + einfo[count] + " employees: " + employees.get(key));
			count++;
		}

		// selection sort
		int smallestindex;
		for (int i = 0; i < einfo.length; i++) {
			smallestindex = i;
			for (int j = i; j < einfo.length; j++) {
				if (einfo[j].compareTo(einfo[smallestindex]) < 0) {
					smallestindex = j;
				}
			}
			EmployeeInfo temp;
			temp = einfo[i];
			einfo[i] = einfo[smallestindex];
			einfo[smallestindex] = temp;
		}

		return einfo;
	}

	/**
	 * Retrieve the average salary of all employees in department with id 'id'.
	 * 
	 * @param id
	 *            id of some department
	 * @return average salary of all employees in department with id 'id'
	 * @throws IdNotFoundException
	 *             if id is not an existing department id
	 */
	public double getAverageSalary(Integer id) throws IdNotFoundException {
		/* Your Task */
		int count = 0;
		double average = 0;
		boolean idFound = false;
		for (String key : employees.keySet()) {
			EmployeeInfo e = employees.get(key);
			if (e.getDepartmentId() == id) {
				count++;
				average += e.getSalary();
				idFound = true;
			}
		}
		if (!idFound) {
			throw new IdNotFoundException(null);
		}

		average /= count;
		return average;
	}

	/**
	 * Retrieve the information object of the department with the highest average
	 * salary among its employees.
	 * 
	 * @return the information object of the department with the highest average
	 *         salary among its employees
	 * 
	 *         Hint: Use 'getAverageSalary(Integer id)' as a helper method.
	 * @throws IdNotFoundException
	 */
	public DepartmentInfo getDepartmentOfHighestAverageSalary() {
		/* Your Task */
		int depID = 0;
		double highestAVG = 0;

		for (int key : departments.keySet()) {
			try {
				if (getAverageSalary(key) > highestAVG) {
					highestAVG = getAverageSalary(key);
					depID = key;
				}
			} catch (IdNotFoundException e) {
			}
		}

		return departments.get(depID);
	}
}
