package com.cinocms.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class CinoCmsApplication {
    private static Logger logger = LogManager.getLogger(CinoCmsApplication.class.getName());
    public static void main(String[] args) {
        logger.info("run application");
        SpringApplication.run(CinoCmsApplication.class, args);
    }

}
