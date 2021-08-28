package com.first.demo.dao;

import java.util.List;
import com.first.demo.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeDAO {
    @Autowired
    IEmployee IEmployee;

    public List<Employee> getEmployees(){
        return IEmployee.findAll();
    }

    public List<Employee> findByName(String name){
        return IEmployee.findByName(name);
    }

    public void addEmployee(Employee newEmployee){
        IEmployee.save(newEmployee);
    }
     
    public List<Employee> getEmployeeById(Integer id){
       return IEmployee.getById(id);
    }

    public int updateEmployee(Integer id , String name , String address , String email){
        return IEmployee.update(id , name , address , email);
    }

    public List<Object> getAllEmployeeData(Integer empId){
        return IEmployee.getAllEmployeeData(empId);
    }

    public void delete(Integer id){
        IEmployee.delete(id);
    }

     
    
     

}
