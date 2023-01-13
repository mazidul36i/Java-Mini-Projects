package com.masai.mail.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {

    private String firstName;
    private String lastName;
    private String mobileNumber;
    private LocalDate dateOfBirth;
    private String password;

}
