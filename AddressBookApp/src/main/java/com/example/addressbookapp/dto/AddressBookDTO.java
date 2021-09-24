package com.example.addressbookapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {

    @NotNull(message = "Please enter id")
    private int personId;

    @Pattern(regexp = "^[A-Z][a-zA-z]{2,}$", message = "First Name Invalid")
    private String firstName;

    @Pattern(regexp = "^[A-Z][a-zA-z]{2,}$", message = "Last Name Invalid")
    private String lastName;

    @Pattern(regexp = "^[a-zA-z0-9]{5,}$", message = "Contact Address Invalid")
    private String address;

    @NotBlank(message = "Note cannot be empty")
    private String city;

    @NotBlank(message = "Note cannot be empty")
    private String state;

    private int zip;

    @Pattern(regexp = "^[0-9]{10}$", message = "Contact Phone Number Invalid")
    private String phoneNumber;

    @Pattern(regexp = "^[a-z]{5,}[@][a-z]{5}[.][a-z]{3}$", message = "Contact Email Invalid")
    private String email;
}
