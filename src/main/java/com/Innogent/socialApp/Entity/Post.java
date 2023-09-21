package com.Innogent.socialApp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) private Long id;
    private String description;
    public String getDescription(){
        return description;
    }
    void setDescription(String description){
        this.description = description;
    }


}
