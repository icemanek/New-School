package com.motorcycleschool.school.repository;

import com.motorcycleschool.school.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface UserRepository extends CrudRepository<User,Long> {


    User findUserById(Long id);

    User findByEmail(String email);

    User findUserByUsername(String username);

    User findUserByResetToken(String resetToken);

    @Query(value = "select username from User where username=?1")
    User findMyUser(String username);
}
