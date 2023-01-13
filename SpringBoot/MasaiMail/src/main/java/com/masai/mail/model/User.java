package com.masai.mail.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class User {

    @Id
//    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$\n", message = "Invalid email address!")
    private String email;
    @Pattern(regexp = "[a-zA-Z ]*", message = "First Name must contain only alphabetic characters and spaces!")
    private String firstName;
    @Pattern(regexp = "[a-zA-Z ]*", message = "Last Name must contain only alphabetic characters and spaces!")
    private String lastName;
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile Number must contain exactly 10 digits!")
    private String mobileNumber;
    private LocalDate dateOfBirth;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,12}$", message = "Password should be alphanumeric and must contain 6-12 characters having at least one special character, one upper case, one lowercase, and one digit.")
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "sender")
    private List<Email> sentEmails;

    @JsonIgnore
    @ManyToMany
    private List<Email> receivedEmails;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Email> startedEmails;

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date of birth cannot be in the future");
        }
        this.dateOfBirth = dateOfBirth;
    }

}
