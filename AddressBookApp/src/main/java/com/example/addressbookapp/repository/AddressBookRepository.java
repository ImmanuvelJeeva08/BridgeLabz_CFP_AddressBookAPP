package com.example.addressbookapp.repository;

import com.example.addressbookapp.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepository extends JpaRepository<Contact , Integer> {

    @Query(value = "select * from contact where city = :city", nativeQuery = true)
    List<Contact> getContactByCity(String city);

    @Query(value = "select * from contact where state = :state", nativeQuery = true)
    List<Contact> getContactByState(String state);
}
