package com.Innogent.socialApp.Repository;

import com.Innogent.socialApp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<User, Long> {

}
