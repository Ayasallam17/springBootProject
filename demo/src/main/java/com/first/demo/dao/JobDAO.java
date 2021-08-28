package com.first.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class JobDAO {
    @Autowired
    IJob IJob;
    
    public void addJob(String title , Integer empId){  // add new job to a particular employee by the id
        IJob.save(title , empId);
    }
}
