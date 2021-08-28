package com.first.demo.Model;

import java.util.List;
import javax.persistence.*;
 
@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;
    private String name;
    private String address;
    private String email;

    @OneToMany(mappedBy = "employee")  // the referance refers to this table and this var(employee) is the forien key in job table
    private List<Job> job;
    public Employee(){
        super();
    }
    public Employee(int id ,String name, String address, String email) {
        super();
        this.name = name;
        this.address = address;
        this.setEmail(email);
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setId(Integer id){
        this.id=id;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    // public void setJob(List<Job> job){
    //     this.job = job;
    // }
    // public List<Job> getJob(){
    //     return job;
    // }
}
