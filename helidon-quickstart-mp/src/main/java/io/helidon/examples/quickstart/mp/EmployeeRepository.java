package io.helidon.examples.quickstart.mp;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import java.util.*;

@Repository
@ApplicationScoped
public class EmployeeRepository {
	private static Map<Integer, Employee> database;
	public EmployeeRepository(){
		System.out.println("EmployeeRepositiory.constructor created");
	}
	static {
		database = new HashMap<>();
		database.put(100, new Employee(100, "James Cooper", 2134));
		database.put(200, new Employee(200, "Steven King", 1234));
		database.put(300, new Employee(300, "Neena Kocchar", 1234));
	}
	
	public Collection<Employee> getAllEmployees(){
		return database.values();
	}
	
	public Employee getEmployeeById(Integer empId) {
		return database.get(empId);
	}
	
	public void createEmployee(Employee emp) {
		System.out.println("EmployeeRepository.createEmployee: Employee Id - " + emp.getId());
		database.put(emp.getId(), emp);
	}
	
	public Collection<Employee> getAllEmployeesWithGivenSalary(Integer salary){
		ArrayList employees = new ArrayList();
		Iterator<Employee> it = database.values().iterator();
		while(it.hasNext()) {
			Employee emp = it.next();
			if(emp.getSalary().equals(salary))
				employees.add(emp);
		}
		return employees;
	}
	
	public void updateEmployee(Integer empId, Employee emp) {
		database.put(empId, emp);
	}
	
	public void deleteEmployee(Integer empId) {
		database.remove(empId);
	}

	@PostConstruct
	public void initialized(){
		System.out.println("EmployeeRepositiory.initialized called");
	}

	@PreDestroy
	public void destory(){
		System.out.println("EmployeeRepositiory.destroy called");
	}
}



