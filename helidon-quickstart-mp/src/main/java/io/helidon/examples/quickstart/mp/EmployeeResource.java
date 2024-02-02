package io.helidon.examples.quickstart.mp;

import java.util.Collection;

import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/hr")
public class EmployeeResource{
	@Inject
    @Repository
	EmployeeRepository database = new EmployeeRepository();
	@Path("/employees")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Employee> getAllEmployees() {
		return database.getAllEmployees();
	}
	@Path("/employees/{paramEmpId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getSingleEmployee(@PathParam("paramEmpId") Integer empId) {
		return database.getEmployeeById(empId);
	}
	@Path("/employees/{paramEmpId}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateSingleEmployee(@PathParam("paramEmpId") Integer empId) {
		Employee emp = database.getEmployeeById(empId);
		if(emp != null) {
			Response.ResponseBuilder builder = Response.ok().entity(emp);
			return builder.build();
		}else {
			Response.ResponseBuilder builder = Response.status(404).entity("Employee Not Found");
			return builder.build();
		}
	}
	@Path("/employees/find")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Employee> findEmployeesForSalary(@QueryParam("salary") Integer salary){
		return database.getAllEmployeesWithGivenSalary(salary);
	}
	@Path("/employees")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String createEmployee(Employee emp) {
		System.out.println("EmployeeResource.createEmployee: Employee Id - " + emp.getId());
		database.createEmployee(emp);
		return "Employee Created successfully";
	}
	@Path("/employees/{paramEmpId}")
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateEmployee(@PathParam("paramEmpId") Integer empId, Employee emp) {
		database.updateEmployee(empId, emp);
		return "Employee Updated successfully";
	}
	@Path("/employees/{paramEmpId}")
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteEmployee(@PathParam("paramEmpId") Integer empId) {
		database.deleteEmployee(empId);
		return "Employee deleted successfully";
	}


}