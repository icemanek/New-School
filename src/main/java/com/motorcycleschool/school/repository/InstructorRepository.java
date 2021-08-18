package com.motorcycleschool.school.repository;


import com.motorcycleschool.school.model.Instructor;
import com.motorcycleschool.school.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


//@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface InstructorRepository extends CrudRepository<Instructor, Long> {



    Instructor findInstructorByInstructorId(Long id);

    Instructor findInstructorByInstructorEmail(String emailInstructor);

    Instructor findInstructorByInstructorUsername(String usernameInstructor);
}
