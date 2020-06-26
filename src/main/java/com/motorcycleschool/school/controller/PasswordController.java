package com.motorcycleschool.school.controller;

import com.motorcycleschool.school.model.User;
import com.motorcycleschool.school.repository.UserRepository;
import com.motorcycleschool.school.util.EmailSender;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/password")
public class PasswordController {

    private UserRepository userRepository;

    private EmailSender emailSender;

    PasswordController(UserRepository userRepository, EmailSender emailSender){
        this.userRepository = userRepository;
        this.emailSender = emailSender;
    }

    @RequestMapping(value = "/forgot", method = {RequestMethod.GET, RequestMethod.POST})
    public void forgotPasswordProcess( @RequestBody User user){
        User userForgotPassword = userRepository.findByEmail(user.getEmail());
        userForgotPassword.setResetToken(String.valueOf(UUID.randomUUID()));
        userRepository.save(userForgotPassword);
        emailSender.sendResetPasswordMail(userForgotPassword.getEmail(), userForgotPassword.getResetToken());
    }

    @RequestMapping(value = "/reset", method = {RequestMethod.GET, RequestMethod.POST})
    public void resetPasswordProcess(@RequestParam Map<String, String> requestParams){
        User resetPasswordUser = userRepository.findUserByResetToken(requestParams.get("resetToken"));
        if(resetPasswordUser != null){
                resetPasswordUser.setPassword(requestParams.get("password"));
                resetPasswordUser.setResetToken(null);
                userRepository.save(resetPasswordUser);
        }
    }

}
