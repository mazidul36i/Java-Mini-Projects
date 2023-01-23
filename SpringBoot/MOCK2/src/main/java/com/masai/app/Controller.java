package com.masai.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	public ResponseEntity<String> welcome() {
		return new ResponseEntity<String>("Wecole to MOCK Application", HttpStatus.OK);
	}
	
}
