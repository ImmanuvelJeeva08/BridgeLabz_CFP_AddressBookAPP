package com.example.addressbookapp.repository;

import com.example.addressbookapp.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepository extends JpaRepository<Contact , Integer> {

}
