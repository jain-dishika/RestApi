package com.Innogent.socialApp.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


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
    public void setDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setId(Long id){
        this.id = id;
    }
    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    public void setPosts(List<Post> posts){
        this.posts = posts;
    }
    public List<Post> getPosts(){
        return posts;
    }
}
