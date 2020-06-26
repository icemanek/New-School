package com.motorcycleschool.school.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;


@Controller
public class GeneralController {


    @GetMapping(value = "/mytest")
    @ResponseBody
    public String hello(){
        return "hello";
    }


    @GetMapping("/home")
//    @Scheduled(fixedDelay = 259200000 )
    public void indexPage() throws IOException {

        URL url;

        {
            try {
                url = new URL("http://develop.ms.codingtree.pl/api/meetings/sorted");


                HttpURLConnection con = null;
                try {
                    con = (HttpURLConnection) url.openConnection();

                    System.out.println(con.getContent());

                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    con.setRequestMethod("GET");

                    System.out.println(con.getContent()  + " ver 2");



                } catch (ProtocolException | NullPointerException e) {
                    e.printStackTrace();
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

}
