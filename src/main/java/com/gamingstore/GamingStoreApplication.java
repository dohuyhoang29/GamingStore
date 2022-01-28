package com.gamingstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GamingStoreApplication {
    public static final String LOCK = "Lock";
    public static final String UN_LOCK = "Un-Lock";

    public static void main(String[] args) {
        SpringApplication.run(GamingStoreApplication.class, args);
    }

}
