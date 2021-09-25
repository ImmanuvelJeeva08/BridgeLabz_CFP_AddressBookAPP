package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.entity.Contact;

import java.util.List;

public interface IAddressBookService {
    AddressBookDTO addContact(AddressBookDTO addressBookDTO);
    List<AddressBookDTO> getContact();
    AddressBookDTO getContactByID(int id);
    AddressBookDTO updateContactDetails(int id, AddressBookDTO addressBookDTO);
    void deleteContact(int id);

    List<Contact> getContactByCity(String city);
    List<Contact> getContactByState(String state);

    List<Contact> getAllContacts(Integer pageNo, Integer pageSize, String sortBy);
}
