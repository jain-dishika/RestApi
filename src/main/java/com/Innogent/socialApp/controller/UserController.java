package com.Innogent.socialApp.controller;
import com.Innogent.socialApp.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Innogent.socialApp.Entity.User;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/entry")
    public User create(@RequestBody User user){
        return userRepository.save(user);
    }
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }
    @DeleteMapping("/{id}")
    public boolean deletedById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            userRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
    @PutMapping("/{id}")
    public User updateById(@PathVariable Long id, @RequestBody User user){
        User update = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        update.setName(user.getName());
        update.setEmail(user.getEmail());
        update.setDateOfBirth(user.getDateOfBirth());
        return userRepository.save(update);
    }
}
