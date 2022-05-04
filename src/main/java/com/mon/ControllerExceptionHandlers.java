package com.mon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandlers {

    @Autowired
    EmailSender emailSender;

    @Value("${dbdisconnection.email.enabled:false}")
    private boolean sendEmailEnabled;

    @ExceptionHandler(Exception.class)
    void handleException(Exception ex) {
        System.out.println("exceptie prinsa pt metoda findall " + ex.getClass().getCanonicalName());
        if (sendEmailEnabled) {
            emailSender.sendEmailOnDbDisconnection();
        }

   //     System.exit(1);
    }

}
