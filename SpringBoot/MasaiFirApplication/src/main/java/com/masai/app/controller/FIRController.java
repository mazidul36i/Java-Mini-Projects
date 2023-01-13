package com.masai.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.model.FIR;
import com.masai.app.service.FIRService;

@RestController
@RequestMapping("/masaifir/user")
public class FIRController {

	@Autowired
	private FIRService firService;

	@PostMapping("/fir")
	public ResponseEntity<FIR> filFIRHandler(@RequestBody FIR fir, @RequestParam("uuid") String uuid) {
		return new ResponseEntity<FIR>(firService.fileFIR(uuid, fir), HttpStatus.CREATED);
	}

	@GetMapping("/{userId}/fir")
	public ResponseEntity<List<FIR>> getFIRListHandler(@PathVariable() Integer userId) {
		return new ResponseEntity<List<FIR>>(firService.getListOfFIRs(userId), HttpStatus.OK);
	}

	@DeleteMapping("/fir")
	public ResponseEntity<FIR> withdrawFIRHandler(@RequestParam("uuid") String uuid,
			@RequestParam("firid") Integer firId) {
		return new ResponseEntity<FIR>(firService.withdrawFIR(uuid, firId), HttpStatus.ACCEPTED);
	}

}
