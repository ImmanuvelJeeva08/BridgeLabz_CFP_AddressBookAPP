package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AddressBookService implements InterfaceAddressBookService{

    static ArrayList<AddressBookDTO> ContactDetails = new ArrayList<>();

    /**
     * Purpose : Ability to add contact details in AddressBook
     * @param addressBookDTO
     * @return
     */

    @Override
    public AddressBookDTO addContact(AddressBookDTO addressBookDTO) {
        log.info("Inside addContact()");
        ContactDetails.add(addressBookDTO);
        return addressBookDTO;
    }

    /**
     * Purpose : Ability to fetch all Contact details from AddressBook
     * @return
     */

    @Override
    public List<AddressBookDTO> getContact() {
        log.info("Inside getContact()");
        return ContactDetails;
    }

    /**
     * Purpose : Ability to fetch contact details from AddressBook using ID
     * @param
     * @return
     */

    @Override
    public AddressBookDTO getContactByID(int id) {
        log.info("Inside getContactByID()");
        return findContactById(id);
    }

    /**
     * Purpose : Ability to update Contact details in AddressBook using ID
     * @param id
     * @return
     */

    private AddressBookDTO findContactById(int id) {
        log.info("Inside findContactById()");
        for (AddressBookDTO i: ContactDetails) {
            if(i.getPersonId() == id){
                return i;
            }
        }
        return null;
    }

    /**
     * Purpose : Ability to update Contact details in AddressBook using ID
     * @param id
     * @param
     * @return
     */

    @Override
    public AddressBookDTO updateContactDetails(int id, AddressBookDTO addressBookDTO) {
        log.info("Inside updateContactDetails()");
        if (id > 0) {
            AddressBookDTO employeeDetails = findContactById(id);
            for (AddressBookDTO i: ContactDetails) {
                if(i.getPersonId() == id){
                    int index = i.getPersonId();
                    ContactDetails.add(index-1,employeeDetails);
                }
            }
        }
        return addressBookDTO;
    }

    /**
     * Purpose : Ability to delete contact details from AddressBook using ID
     * @param id
     * @return
     */

    @Override
    public void deleteContact(int id) {
        log.info("Inside deleteContact()");
        if (id > 0) {
            for (AddressBookDTO i: ContactDetails) {
                if(i.getPersonId() == id){
                    ContactDetails.remove(i);
                }
            }
        }
    }
}
