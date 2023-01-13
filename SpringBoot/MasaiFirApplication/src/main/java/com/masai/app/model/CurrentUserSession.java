package com.masai.app.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class CurrentUserSession {

	@Id
	private String uuid;
	private LocalDateTime datetime = LocalDateTime.now();
	private Integer userId;

}
