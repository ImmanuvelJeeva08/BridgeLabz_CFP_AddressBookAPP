package com.example.addressbookapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {

    private int personId;

    @Pattern(regexp = "^[A-Z][a-zA-z]{2,}$", message = "First Name Invalid")
    private String firstName;

    @Pattern(regexp = "^[A-Z][a-zA-z]{2,}$", message = "Last Name Invalid")
    private String lastName;

    @Pattern(regexp = "^[a-zA-z0-9]+$", message = "Contact Address Invalid")
    private String address;

    private String city;
    private String state;

    @Pattern(regexp = "^[0-9]{6}$", message = "Zip Number Invalid")
    private int zip;

    @Pattern(regexp = "^[0-9]{10}$", message = "Contact Phone Number Invalid")
    private long phoneNumber;

    @Pattern(regexp = "^[A-Z][a-z]{5,}[@][a-z]{5}[.][a-z]{3}$", message = "Contact Email Invalid")
    private String email;
}
