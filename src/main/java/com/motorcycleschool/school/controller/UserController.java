package com.motorcycleschool.school.controller;

import com.motorcycleschool.school.SchoolApplication;
import com.motorcycleschool.school.model.User;
import com.motorcycleschool.school.repository.ConfirmationTokenRepository;
import com.motorcycleschool.school.repository.UserRepository;
import com.motorcycleschool.school.util.ConfirmationToken;
import com.motorcycleschool.school.util.EmailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Base64;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    private final EmailSender emailSender;

    private final ConfirmationTokenRepository confirmationTokenRepository;

    UserController(UserRepository userRepository, EmailSender emailSender, ConfirmationTokenRepository confirmationTokenRepository) {
        this.userRepository = userRepository;
        this.emailSender = emailSender;
        this.confirmationTokenRepository = confirmationTokenRepository;
    }



    @PostMapping(value = "/add" , produces = {MediaType.APPLICATION_JSON_VALUE})
    public void createUser(@RequestBody @Valid User user) throws SQLIntegrityConstraintViolationException {

        Logger logger = LoggerFactory.getLogger(SchoolApplication.class);

        User duplicateEmailUser = userRepository.findByEmail(user.getEmail());
        User duplicateUsernameUser = userRepository.findUserByUsername(user.getUsername());

        if (duplicateUsernameUser != null){

            throw new SQLIntegrityConstraintViolationException("Istnieje taki user w bazie! ");

        }
        if(duplicateEmailUser != null){

            throw new SQLIntegrityConstraintViolationException("Istnieje taki email w bazie! ");

        }

        userRepository.save(user);

        logger.debug("user saved succesfully " + user);

            ConfirmationToken confirmationToken = new ConfirmationToken(user);

            logger.debug("token created");

//            emailSender.sendRegistrationMail(user.getEmail(), confirmationToken.getConfirmationToken());

            logger.debug("mail send");

            confirmationToken.setExpiryDate(24);

            confirmationTokenRepository.save(confirmationToken);

            logger.trace("user creating complete");
    }

    @GetMapping("/all")
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @RequestMapping(value = "/confirm-account", method = {RequestMethod.GET, RequestMethod.PUT})
    public void confirmUserAccount(@RequestParam("token") String confirmationToken) {

        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if (token != null) {
           userRepository.findById(token.getUser().getId());
            token.getUser().setEnabled(true);
            userRepository.save(token.getUser());

            System.out.println("konto aktywowane");
        }
    }

    @RequestMapping(value = "/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public User updateUser(@PathVariable Long id){
         User updateUserInformation = userRepository.findUserById(id);
        return userRepository.save(updateUserInformation);
    }

    @RequestMapping(value = "/show/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public User showUser(@PathVariable Long id){
        return userRepository.findUserById(id);
    }

    @RequestMapping(value = "/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }

}
