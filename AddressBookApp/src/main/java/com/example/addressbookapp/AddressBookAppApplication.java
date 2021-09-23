package com.example.addressbookapp;

import org.springframework.boot.SpringApplication;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AddressBookAppApplication {

    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();
    }

    public static void main(String[] args) {

        SpringApplication.run(AddressBookAppApplication.class, args);
    }
}
