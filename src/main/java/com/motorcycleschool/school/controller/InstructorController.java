package com.motorcycleschool.school.controller;


import com.motorcycleschool.school.SchoolApplication;
import com.motorcycleschool.school.model.Instructor;
import com.motorcycleschool.school.repository.ConfirmationTokenRepository;
import com.motorcycleschool.school.repository.InstructorRepository;
import com.motorcycleschool.school.util.ConfirmationToken;
import com.motorcycleschool.school.util.EmailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/instructor")
public class InstructorController {

    private EmailSender emailSender;

    private ConfirmationTokenRepository confirmationTokenRepository;

    private InstructorRepository instructorRepository;

    public InstructorController(EmailSender emailSender, InstructorRepository instructorRepository, ConfirmationTokenRepository confirmationTokenRepository){
        this.emailSender = emailSender;
        this.instructorRepository = instructorRepository;
        this.confirmationTokenRepository = confirmationTokenRepository;
    }

//        @PostMapping(value = "/add" , produces = {MediaType.APPLICATION_JSON_VALUE})
//        public void createInstructor(@RequestBody @Valid Instructor instructor){
//
//            Logger logger = LoggerFactory.getLogger(SchoolApplication.class);
//
//            instructorRepository.save(instructor);
//
//            logger.debug("instructor created start");
//
//            ConfirmationToken confirmationToken = new ConfirmationToken(instructor);
//
//            emailSender.sendRegistrationMail(instructor.getInstructorEmail(), confirmationToken.getConfirmationToken());
//
//            logger.debug("mail send");
//
//            confirmationToken.setExpiryDate(24);
//
//            confirmationTokenRepository.save(confirmationToken);
//
//            logger.debug("instructor created succesfully");
//        }
//

        @GetMapping(value = "/all")
    public List<Instructor> findAllInstructors(){
        return (List<Instructor>) instructorRepository.findAll();
        }

        @RequestMapping(value = "/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
        public Instructor updateInstructor(@PathVariable Long id){
        Instructor updateInstructor = instructorRepository.findInstructorByInstructorId(id);

        return instructorRepository.save(updateInstructor);
        }

        @RequestMapping(value = "/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public void deleteInstructor(@PathVariable Long id, Instructor deleteInstructorFromDb){
        instructorRepository.delete(deleteInstructorFromDb);
        }
}
