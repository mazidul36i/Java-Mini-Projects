package com.masai.mail.repository;

import com.masai.mail.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailDao extends JpaRepository<Email, Integer> {
}
