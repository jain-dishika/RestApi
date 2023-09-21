package com.Innogent.socialApp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) private Long id;
    private String name;
    private String email;
    private LocalDate dateOfBirth;
    public String getName(){
        return name;
    }
    public Long getId(){
        return id;
    }
    public String getEmail(){
        return email;
    }
    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setId(Long id){
        this.id = id;
    }
    public void setDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }
    public void setName(String name){
        this.name = name;
    }
}
