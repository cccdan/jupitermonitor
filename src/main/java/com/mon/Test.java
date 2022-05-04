package com.mon;


import com.mon.data.BAERepository;
import com.mon.data.BopsAppError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class Test {

    @Autowired
    BAERepository repo;

    @Autowired
    EmailSender emailSender;

    @Value("${page.refresh}")
    private int abc;

    @Bean
     CommandLineRunner abc() {
        return (x -> {
            System.out.println(Utils.getFormattedCurrentTime());
//            try {
//                emailSender.sendEmail("cmdline.ro", "test cmd", "ceva txt", "zu.ro", "gu.ro");
//            } catch (Exception ex) {
//                System.out.println("can't send email");
//                ex.printStackTrace();
//            }
        });
    }
}
