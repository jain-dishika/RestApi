package com.Innogent.socialApp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

@Entity
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) private Long id;
    private String description;

    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @ManyToOne
    @JsonIgnore
    private User user;

    public void setUser(User user){
        this.user = user;
    }
    public User getUser(){
        return user;
    }

}
