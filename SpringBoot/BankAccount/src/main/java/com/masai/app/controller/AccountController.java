package com.masai.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.masai.app.model.Account;
import com.masai.app.model.AccountDTO;
import com.masai.app.service.AccountService;

import jakarta.validation.Valid;

@Controller
public class AccountController {

	@Autowired
	private AccountService aService;
	
	@PostMapping("/accounts/open")
	public ResponseEntity<Account> openAccountHandler(@RequestBody @Valid Account acc) {
		Account account = aService.openAccount(acc);
		return new ResponseEntity<Account>(account, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/accounts/close")
	public ResponseEntity<Account> closeAccountHandler(@RequestParam("accountno") Integer accno) {
		Account account = aService.closeAccount(accno);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
	

	@PutMapping("/accounts/deposite/{accno}")
	public ResponseEntity<Account> depositeAccountHandler(@PathVariable("accno") Integer accno, @RequestParam("amount") Integer amount) {
		Account account = aService.depositAmount(accno, amount);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
	
	@PutMapping("/accounts/withdraw/{accno}")
	public ResponseEntity<Account> withdrawAccountHandler(@PathVariable("accno") Integer accno, @RequestParam("amount") Integer amount) {
		Account account = aService.withdrawAmount(accno, amount);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
	
	@PutMapping("/accounts/transfer")
	public ResponseEntity<String> transferAccountHandler(@RequestBody @Valid AccountDTO dto) {
		String msg = aService.transferAmount(dto);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
