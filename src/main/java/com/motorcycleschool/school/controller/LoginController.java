package com.motorcycleschool.school.controller;

import com.motorcycleschool.school.model.User;
import com.motorcycleschool.school.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

//    public PasswordEncoder passwordEncoder;
//    private final UserRepository userRepository;
//
//    LoginController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }

//    @RequestMapping(value = "/login")
//    @ResponseBody
//    public boolean login(@RequestBody User user, HttpServletResponse response) {
//
//        User userInDb = userRepository.findUserByUsername(user.getUsername());
//
//        if (user.getUsername().equals(userInDb.getUsername()) && BCrypt.checkpw(user.getPassword(), (userInDb.getPassword()))){
//
//            Cookie cookie = new Cookie("platform","mobile");
//
//            cookie.setMaxAge(7 * 24 * 60 * 60);
//
//            cookie.setHttpOnly(false);
//
//            response.addCookie(cookie);
//
//            return  true;
//        } else {
//            return false;
//        }
//    }

    }


