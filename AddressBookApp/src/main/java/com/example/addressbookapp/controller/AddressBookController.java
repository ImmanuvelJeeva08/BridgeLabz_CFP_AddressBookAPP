package com.example.addressbookapp.controller;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.dto.ResponseDTO;
import com.example.addressbookapp.entity.Contact;
import com.example.addressbookapp.service.AddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<ResponseDTO> addContactDetails(@Valid @RequestBody AddressBookDTO addressBookDTO) {
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

    @PutMapping(value = "/updateContactDetailsByID")
    public ResponseEntity<ResponseDTO> updateContactDetails(@RequestParam(name = "id") int id,
                                                      @Valid @RequestBody AddressBookDTO addressBookDTO) {
        log.info("Inside Update contact Details");
        AddressBookDTO updatedData = addressBookService.updateContactDetails(id,addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated by ID : contact Details",updatedData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose : Ability to delete contact details in AddressBook
     */

    @DeleteMapping(value = "/deleteContactDetailsByID")
    public ResponseEntity<ResponseDTO> deleteContactDetails(@RequestParam(name = "id") int id) {
        log.info("Inside delete Details");
        addressBookService.deleteContact(id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted by ID : contact Details", null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose : Ability to Fetch contact Details from AddressBook by Using City
     */

    @GetMapping("/getContactDetailsByCity")
    public ResponseEntity<ResponseDTO> getContactDetailsByCity(@RequestParam(name = "city") String city){
        log.info("Inside get contact Details By City");
        List<Contact> cityList = addressBookService.getContactByCity(city);
        ResponseDTO responseDTO = new ResponseDTO("Fetched given city contact Details",cityList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose : Ability to Fetch contact Details from AddressBook by Using State
     */

    @GetMapping("/getContactDetailsByState")
    public ResponseEntity<ResponseDTO> getContactDetailsByState(@RequestParam(name = "state") String state){
        log.info("Inside get contact Details By State");
        List<Contact> stateList = addressBookService.getContactByState(state);
        ResponseDTO responseDTO = new ResponseDTO("Fetched given state contact Details",stateList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose : Ability to Fetch contact Details from AddressBook by Using Page
     */

    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "personId") String sortBy) {

        List<Contact> list = addressBookService.getAllContacts(pageNo, pageSize, sortBy);
        return new ResponseEntity<List<Contact>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
