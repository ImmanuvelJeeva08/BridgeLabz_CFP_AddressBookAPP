package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.entity.Contact;
import com.example.addressbookapp.exception.AddressBookException;
import com.example.addressbookapp.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService {

    @Autowired
    AddressBookRepository addressBookRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Purpose : Ability to add contact details in AddressBook
     * @param addressBookDTO
     * @return
     */

    @Override
    public AddressBookDTO addContact(AddressBookDTO addressBookDTO) {
        log.info("Inside addContact()");
        Contact contactRequest = modelMapper.map(addressBookDTO, Contact.class);
        addressBookRepository.save(contactRequest);
        return addressBookDTO;
    }

    /**s
     * Purpose : Ability to fetch all Contact details from AddressBook
     * @return
     */

    @Override
    public List<AddressBookDTO> getContact() {
        log.info("Inside getContact()");
        return addressBookRepository.findAll().stream().map(Contact -> {
            return new AddressBookDTO(Contact.getPersonId(),Contact.getFirstName(),Contact.getLastName(),
                    Contact.getAddress(),Contact.getCity(),Contact.getState(), Contact.getZip(),
                    Contact.getPhoneNumber(),Contact.getEmail());
        }).collect(Collectors.toList());
    }

    /**
     * Purpose : Ability to fetch contact details from AddressBook using ID
     * @param id
     * @return contactResponse
     */

    @Override
    public AddressBookDTO getContactByID(int id) {
        log.info("Inside getContactByID()");
        Contact contact = findContactById(id);
        AddressBookDTO contactResponse = modelMapper.map(contact, AddressBookDTO.class);
        return contactResponse;
    }

    /**
     * Purpose : Ability to update Contact details in AddressBook using ID
     * @param id
     * @return contact
     */

    private Contact findContactById(int id) {
        log.info("Inside findContactById()");
        return addressBookRepository.findById(id)
                .orElseThrow(() -> new AddressBookException("Unable to find any Person contact detail!"));
    }

    /**
     * Purpose : Ability to update Contact details in AddressBook using ID
     * @param id
     * @param addressBookDTO
     * @return contactResponse
     */

    @Override
    public AddressBookDTO updateContactDetails(int id, AddressBookDTO addressBookDTO) {
        log.info("Inside updateContactDetails()");
        AddressBookDTO contactResponse = null;
        if (id > 0) {
            Contact contactDetails = findContactById(id);
            String[] ignoreFields = {"personId", "firstName", "lastName"};
            BeanUtils.copyProperties(addressBookDTO, contactDetails, ignoreFields);
            addressBookRepository.save(contactDetails);
            contactResponse = modelMapper.map(contactDetails, AddressBookDTO.class);
        }
        return contactResponse;
    }

    /**
     * Purpose : Ability to delete contact details from AddressBook using ID
     * @param id
     */

    @Override
    public void deleteContact(int id) {
        log.info("Inside deleteContact()");
        if (id > 0) {
                Contact contact = findContactById(id);
                addressBookRepository.delete(contact);
        }
    }

    /**
     * Purpose : Ability to Fetch contact details from AddressBook using City
     * @param city
     */

    @Override
    public List<Contact> getContactByCity(String city) {
        return addressBookRepository.getContactByCity(city);
    }

    /**
     * Purpose : Ability to Fetch contact details from AddressBook using City
     * @param state
     */

    @Override
    public List<Contact> getContactByState(String state) {
        return addressBookRepository.getContactByState(state);
    }
}
