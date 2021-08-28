package com.first.demo.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.first.demo.Model.Employee;
import com.first.demo.Model.Job;
import com.first.demo.dao.EmployeeDAO;
import com.first.demo.dao.JobDAO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @Autowired
    EmployeeDAO employeeDAO;

    @Autowired
    JobDAO JobDAO;

    @GetMapping("/getallemployees")  //get all employees data in employees table.
    public List<Employee> getAllEmployees(){
        return employeeDAO.getEmployees();
    }
    @GetMapping("/name/{name}")  // search in employees table by name
    public List<Employee> findEmployeeByName(@PathVariable String name){
        return employeeDAO.findByName(name);
    }

    @PostMapping("/add")  // add new employee with name,address,email
    public Employee addEmployee(@RequestBody Employee newEmployee){
        employeeDAO.addEmployee(newEmployee);
        return newEmployee;
    }

    @PostMapping("/addjob")  // add a new job to a particular employee using employee id
    public String addJob(@RequestBody Job job){
        JobDAO.addJob(job.getTitle() , job.getEmployee().getId());
        return "saved employee job";
    }

    @GetMapping("/getone/{id}")  // get one employee by id. get only name ,address and email without his jobs 
    public List<Employee>getEmployee(@PathVariable Integer id){
        return employeeDAO.getEmployeeById(id);
    }
    
    @PutMapping("/update/{id}")  // update employee by his id
    public Employee update(@RequestBody Employee data , @PathVariable Integer id){
        employeeDAO.updateEmployee(id, data.getName(), data.getAddress(), data.getEmail());
        return data;
    }
     
    @GetMapping("/getallemployeedata/{id}")  // get employee data from two joined table (employees,job)
    public List<Object> getAllEmployeeData(@PathVariable Integer id){
        return employeeDAO.getAllEmployeeData(id);
    }
    @DeleteMapping("/delete/{id}")  // delete employee's data from two table(employees,job)
    public String delete(@PathVariable Integer id){
        employeeDAO.delete(id);
        return "deleted";
    }

}
