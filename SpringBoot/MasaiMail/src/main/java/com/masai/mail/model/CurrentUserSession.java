package com.masai.mail.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class CurrentUserSession {

    @Id
    private String uuid;
    private String email;
    private LocalDateTime datetime;

}
