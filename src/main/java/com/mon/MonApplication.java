package com.mon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;

@SpringBootApplication
public class MonApplication {
    static final Logger log = LoggerFactory.getLogger(MonApplication.class);

    public static void main(String[] args) throws InterruptedException {


        try {
            ConfigurableApplicationContext springContext = SpringApplication.run(MonApplication.class, args);
            DataSource ds = springContext.getBean(DataSource.class);
            System.out.println("login timeout " + ds.getLoginTimeout());
        }
        catch (Exception ex) {

            if (ex.getClass().getCanonicalName().contains("BeanCreation")) {
                log.info("jupmoninfo: eroare pornire BeanCreationException");
            } else {
                log.info("jupmoninfo: " + ex.getClass().getCanonicalName());
            }


        }

    }

}
