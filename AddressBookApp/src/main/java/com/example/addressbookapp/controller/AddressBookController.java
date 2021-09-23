package com.example.addressbookapp.controller;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.dto.ResponseDTO;
import com.example.addressbookapp.service.AddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressBook")
@Slf4j
public class AddressBookController {

    @Autowired
    AddressBookService addressBookService;

    /**
     * Purpose : Ability to add contact details in AddressBook
     */

    @PostMapping(value = "/addContactDetails")
    public ResponseEntity<ResponseDTO> addContactDetails(@RequestBody AddressBookDTO addressBookDTO) {
        log.info("Inside add contact Details");
        AddressBookDTO addData = addressBookService.addContact(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Added contact Details",addData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose : Ability to fetch all contact details in AddressBook
     */

    @GetMapping(value = "/getContactDetails")
    public ResponseEntity<ResponseDTO> getContactDetails() {
        log.info("Inside get contact Details");
        List<AddressBookDTO> contactList = addressBookService.getContact();
        ResponseDTO responseDTO = new ResponseDTO("Fetched all contact Details",contactList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    /**
     * Purpose : Ability to fetch Contact details from AddressBook using ID
     * @param id
     * @return
     */

    @GetMapping(value = "/getContactDetailsByID")
    public ResponseEntity<ResponseDTO> getEmployeeDetailsByID(@RequestParam(name = "id") int id) {
        log.info("Inside getContactDetailsByID()");
        AddressBookDTO addressBookDTO = addressBookService.getContactByID(id);
        ResponseDTO responseDTO = new ResponseDTO("Fetched by ID : Contact Details", addressBookDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose : Ability to update contact details in AddressBooks
     */

    @PutMapping(value = "/updateContactDetails")
    public ResponseEntity<ResponseDTO> updateContactDetails(@RequestParam(name = "id") int id,
                                                        @RequestBody AddressBookDTO addressBookDTO) {
        log.info("Inside Update contact Details");
        AddressBookDTO updatedData = addressBookService.updateContactDetails(id,addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated by ID : contact Details",updatedData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose : Ability to delete contact details in AddressBook
     */

    @DeleteMapping(value = "/deleteContactDetails")
    public ResponseEntity<ResponseDTO> deleteContactDetails(@RequestParam(name = "id") int id) {
        log.info("Inside delete Details");
        addressBookService.deleteContact(id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted by ID : contact Details", null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
