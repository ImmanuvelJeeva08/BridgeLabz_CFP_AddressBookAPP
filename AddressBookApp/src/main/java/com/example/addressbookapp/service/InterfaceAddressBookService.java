package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;

import java.util.List;

public interface InterfaceAddressBookService {
    AddressBookDTO addContact(AddressBookDTO addressBookDTO);
    List<AddressBookDTO> getContact();
    AddressBookDTO getContactByID(int id);
    AddressBookDTO updateContactDetails(int id, AddressBookDTO addressBookDTO);
    void deleteContact(int id);

}
