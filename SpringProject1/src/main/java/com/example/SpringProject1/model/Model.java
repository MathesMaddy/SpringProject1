package com.example.SpringProject1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table; import jakarta.persistence.GenerationType;

import jakarta.persistence.Column;
@Entity 

@Table(name="AllData")

public class Model {
    
    @Id    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="username")
    private String username;
    @Column(name="firstname")
    private String firstname;
    @Column(name="lastname")
    private String lastname; 
    @Column(name="age")
    private Long age;
    public Long getId() {
        return id;
    }    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Long getAge() {
        return age;
    }
    public void setAge(Long age) {
        this.age = age;
    }
    public Model() {
    }
    public Model(String username, String firstname, String lastname, Long age) {
        
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Model [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
                + ", age=" + age + "]";
    }

   
    

}
