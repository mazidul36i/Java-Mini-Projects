package com.masai.app.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				(auth) -> auth.requestMatchers("/welcomeP").authenticated().requestMatchers("/welcome").permitAll())
				.httpBasic();
		return http.build();
	}

	@Bean
	public InMemoryUserDetailsManager userDetails() {
		InMemoryUserDetailsManager detailsManager = new InMemoryUserDetailsManager();
		UserDetails admin = User.withUsername("mazidul").password("12345").authorities("admin").build();
		detailsManager.createUser(admin);
		return detailsManager;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance(); // Not recommended
	}

}
