package com.Innogent.socialApp.Repository;

import com.Innogent.socialApp.Entity.Post;
import com.Innogent.socialApp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
