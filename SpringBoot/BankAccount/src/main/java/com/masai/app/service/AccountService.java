package com.masai.app.service;

import com.masai.app.exception.AccountException;
import com.masai.app.exception.InsufficientFundException;
import com.masai.app.model.Account;
import com.masai.app.model.AccountDTO;

public interface AccountService {

	public Account openAccount(Account acc) throws AccountException;

	public Account closeAccount(Integer accno) throws AccountException;

	public Account depositAmount(Integer accno, Integer amount) throws AccountException;

	public Account withdrawAmount(int accno, Integer amount) throws AccountException, InsufficientFundException;

	public String transferAmount(AccountDTO dto) throws AccountException, InsufficientFundException;
	
}