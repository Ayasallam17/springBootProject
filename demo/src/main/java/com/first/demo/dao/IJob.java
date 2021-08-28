package com.first.demo.dao;

import com.first.demo.Model.Job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IJob extends JpaRepository<Job , Integer>{
    
    @Query(value = "insert into job (title , emp_fk) values (:title , :empId)" , nativeQuery = true)
    public void save(@Param("title") String title ,@Param("empId") Integer empId);
    
}
