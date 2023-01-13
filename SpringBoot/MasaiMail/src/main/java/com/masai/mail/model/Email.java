package com.masai.mail.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String content;
    private String subject;
    private LocalDateTime datetime = LocalDateTime.now();

    @JsonIgnore
    @ManyToOne
    private User sender;

    @JsonIgnore
    @ManyToMany(mappedBy = "receivedEmails")
    private List<User> receivers;
}
