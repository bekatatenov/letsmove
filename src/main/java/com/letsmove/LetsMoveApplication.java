package com.letsmove;

import com.letsmove.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LetsMoveApplication {
    public static void main(String[] args) {
        SpringApplication.run(LetsMoveApplication.class, args);
    }

}
