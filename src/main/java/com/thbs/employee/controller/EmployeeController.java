package com.thbs.employee.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thbs.model.Employee;
import com.thbs.model.EmployeeList;

/**
 * Create Employee controller to manage employee data
 * 
 * @author pramitha_shenoy
 *
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
	static final Logger logger = Logger.getLogger(EmployeeController.class);
	
    Map<Integer, Employee> empData = new HashMap<Integer, Employee>();

    /**
     * Dummy insert method to insert test data.
     * 
     * @return Employee object
     */

    @RequestMapping(value = "/dummy", method = RequestMethod.GET,  produces = { "application/xml","application/json" })
    public Employee insertDummyData()
    {
        
        logger.debug("Debug Logger Inserting dummy data");
        logger.info("Info Logger Inserting dummy data");
        System.out.println("Inserting dummy data");
        
        Employee employee = new Employee();
        employee.setId(2289);
        
        employee.setLastname("Baliga");
        employee.setLocation("Bangalore");
        employee.setName("Pramitha");
        empData.put(employee.getId(), employee);
        
        return employee;
    }

    /**
     * Get method to fetch Employee data using employee Id
     * 
     * @param empId
     * @return Employee object
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/xml","application/json" })
    public Employee getEmployee(@PathVariable("id") int empId)
    {
        System.out.println("Getting empoyee :" + empId + " details");
        return empData.get(empId);
    }

    /**
     * Get all employee data which is in Cache
     * 
     * @return List of employee object
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/xml","application/json" })
    public EmployeeList getAllEmployees() 
    {
        System.out.println("Getting all empoyee details");

        EmployeeList employeeList = new EmployeeList();
        List<Employee> employees = new ArrayList<Employee>();
        Set<Integer> empIdKeys = empData.keySet();
        for (Integer i : empIdKeys) {
        	employees.add(empData.get(i));
        }
        employeeList.setEmployee(employees);
        return employeeList;
    }

    /**
     * Create method to insert employee data in Cache
     * 
     * @param emp
     *            is of type Employee
     * @return Success message
     */
    @RequestMapping(value = "/create",method = RequestMethod.POST, consumes= { "application/xml","application/json" })
    public String createEmployee(@RequestBody Employee emp) 
    {
        System.out.println("Creating empoyee details");
        
        empData.put(emp.getId(), emp);
        return "Employee details created successfully";
    }

    /**
     * Delete Employee data associated with employee Id
     * 
     * @param empId
     * @return
     */
    @RequestMapping(value = "/{id}/terminate", method = RequestMethod.DELETE, produces = { "application/xml", "text/xml", "application/json" })
    public Employee deleteEmployee(@PathVariable("id") int empId)
    {
        System.out.println("Deleting employee : " + empId);

        Employee emp = empData.get(empId);
        empData.remove(empId);
        return emp;
    }
}
