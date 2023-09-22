package com.Innogent.socialApp.controller;
import com.Innogent.socialApp.Entity.Post;
import com.Innogent.socialApp.Repository.PostRepository;
import com.Innogent.socialApp.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Innogent.socialApp.Entity.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    //  1
    @GetMapping("/")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //    2
    @PostMapping("/entry")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    //    3
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    //    4
    @DeleteMapping("/{id}")
    public boolean deletedById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    //    5
    @PutMapping("/{id}")
    public User updateById(@PathVariable Long id, @RequestBody User user) {
        User update = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        update.setName(user.getName());
        update.setEmail(user.getEmail());
        update.setDateOfBirth(user.getDateOfBirth());
        return userRepository.save(update);
    }
//    Started Mapping
//    6
    @GetMapping("/{id}/posts")
    public List<Post> getAllPost(@PathVariable Long id) {
        Optional<User> post = userRepository.findById(id);
        if (post.isPresent()) {
            User user = post.get();
            return user.getPosts();
        }
        return null;
    }

    //    7
    @GetMapping("/{id}/posts/{idPost}")
    public Post getPostById(@PathVariable Long id, @PathVariable Long idPost) {
        Optional<User> inUse = userRepository.findById(id);
        if (inUse.isPresent()) {
            List<Post> p1 = inUse.get().getPosts();
            Optional<Post> matchingPost = p1.stream().filter(post -> post.getId().equals(idPost)).findFirst();
            return matchingPost.orElse(null);
        }
        return null;
    }

    //    8
    @PostMapping("/{id}/posts")
    public Post create(@RequestBody Post post, @PathVariable Long id) {
        Optional<User> user1 = userRepository.findById(id);
        if (user1.isPresent()) {
            User user2 = user1.get();
            post.setUser(user2);
            return postRepository.save(post);
        }
        return null;
    }

//    9
    @DeleteMapping("/{id}/posts/{postId}")
    public boolean deletedByIdPost(@PathVariable Long id, @PathVariable Long postId) {
        Optional<User> inUse = userRepository.findById(id);
        if(inUse.isPresent()){
            List<Post> p1 = inUse.get().getPosts();
            Optional<Post> matchingPost = p1.stream().filter(post -> post.getId().equals(postId)).findFirst();
            if (matchingPost.isPresent()){
                postRepository.deleteById(postId);
                return true;
            }
            else{
                return false;
            }

        }else{
            return false;
        }
    }
//    10
@PutMapping("/{id}/posts/{postId}")
public Post updateByPostId(@PathVariable Long id, @PathVariable Long postId,@RequestBody Post post) {
    Optional<User> user1 = userRepository.findById(id);
    if (user1.isPresent()){
        User user2 = user1.get();
        post.setUser(user2);
        Post update = postRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        update.setDescription(post.getDescription());
        return postRepository.save(update);
    }
    return null;
}

}





