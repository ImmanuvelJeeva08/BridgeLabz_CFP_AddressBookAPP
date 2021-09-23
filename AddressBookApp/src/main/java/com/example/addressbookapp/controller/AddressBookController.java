package com.example.addressbookapp.controller;

import com.example.addressbookapp.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressBook")
@Slf4j
public class AddressBookController {

    /**
     * Purpose : Ability to add contact details in AddressBook
     */

    @PostMapping(value = "/addContactDetails")
    public ResponseEntity<String> addContactDetails( ) {
        log.info("Inside add contact Details");
        ResponseDTO responseDTO = new ResponseDTO("Added contact Details",null);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose : Ability to fetch all contact details in AddressBook
     */

    @GetMapping(value = "/getContactDetails")
    public ResponseEntity<String> getContactDetails() {
        log.info("Inside get contact Details");
        ResponseDTO responseDTO = new ResponseDTO("Fetched all contact Details",null);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose : Ability to update contact details in AddressBook
     */

    @PutMapping(value = "/updateContactDetails")
    public ResponseEntity<String> updateContactDetails() {
        log.info("Inside Update contact Details");
        ResponseDTO responseDTO = new ResponseDTO("Updated by ID : contact Details",null);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose : Ability to delete contact details in AddressBook
     */

    @DeleteMapping(value = "/deleteContactDetails")
    public ResponseEntity<String> deleteContactDetails() {
        log.info("Inside delete Details");
        ResponseDTO responseDTO = new ResponseDTO("Deleted by ID : contact Details", null);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }
}
