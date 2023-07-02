package org.example;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class Main {
    @Bean

    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext resp = SpringApplication.run(Main.class, args);
    }

}