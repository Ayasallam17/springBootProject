package com.first.demo.dao;

import java.util.List;
import com.first.demo.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IEmployee extends JpaRepository<Employee , Integer>{
    public List<Employee> findByName(String name);  //custom method

    @Query(value="SELECT * FROM employees where id=:id" , nativeQuery = true)  // get employee by id
    public List<Employee> getById(@Param("id") int id);

    @Modifying
    @Transactional   // update an employee by id
    @Query(value = "update employees set name = :name,address = :address,email=:email where id=:id",nativeQuery = true)
    public int update(@Param("id") int id , @Param("name") String name, @Param("address") String address,
    @Param("email") String email);

    // selecte an employee'data from two joined table(employees and job)
    @Query(value = "select employees.id ,employees.name ,employees.address ,employees.email ,job.title, job.jid from employees join job on job.emp_fk = employees.id and employees.id=:empId",nativeQuery = true)
    public List<Object> getAllEmployeeData(@Param("empId") int empId);

    // delete an employee by id and also delete all his related data from job table
    @Modifying
    @Transactional
    @Query(value = "delete from job where emp_fk=:id ; delete from employees where id=:id" , nativeQuery = true)
    public void delete(@Param("id") Integer id);
}
