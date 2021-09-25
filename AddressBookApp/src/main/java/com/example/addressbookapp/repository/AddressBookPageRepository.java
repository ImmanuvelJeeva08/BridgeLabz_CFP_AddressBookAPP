package com.example.addressbookapp.repository;

import com.example.addressbookapp.entity.Contact;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressBookPageRepository extends PagingAndSortingRepository<Contact, Integer> {

}
