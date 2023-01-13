package com.masai.mail.repository;

import com.masai.mail.model.CurrentUserSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentUserSessionDao extends JpaRepository<CurrentUserSession, String> {
}
