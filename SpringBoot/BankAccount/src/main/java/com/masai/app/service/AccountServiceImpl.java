package com.masai.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.app.exception.AccountException;
import com.masai.app.exception.InsufficientFundException;
import com.masai.app.model.Account;
import com.masai.app.model.AccountDTO;
import com.masai.app.repository.AccountDao;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao adao;
	
	@Override
	public Account openAccount(Account acc) throws AccountException {
		Account account = adao.save(acc);
		if (account != null) return account;
		throw new AccountException("Failed to open account with the given details!");
	}

	@Override
	public Account closeAccount(Integer accno) throws AccountException {
		Account account = adao.findById(accno).orElseThrow(() -> new AccountException("No account exists with the account no: " + accno));
		adao.delete(account);
		return account;
	}

	@Override
	public Account depositAmount(Integer accno, Integer amount) throws AccountException {
		Account account = adao.findById(accno).orElseThrow(() -> new AccountException("No account exists with the account no: " + accno));
		account.setBalance(account.getBalance() + amount);
		adao.save(account);
		return account;
	}

	@Override
	public Account withdrawAmount(int accno, Integer amount) throws AccountException, InsufficientFundException {
		Account account = adao.findById(accno).orElseThrow(() -> new AccountException("No account exists with the account no: " + accno));
		if (account.getBalance() < amount) throw new InsufficientFundException("Insufficient Balance!");
		account.setBalance(account.getBalance() - amount);
		adao.save(account);
		return account;
	}

	@Override
	public String transferAmount(AccountDTO dto) throws AccountException, InsufficientFundException {
		Account srcAccount = adao.findById(dto.getSrcAccno()).orElseThrow(() -> new AccountException("No account exists with the account no: " + dto.getSrcAccno()));
		Account destAccount = adao.findById(dto.getSrcAccno()).orElseThrow(() -> new AccountException("No account exists with the account no: " + dto.getDesAccno()));
		
		if (srcAccount.getBalance() < dto.getAmount()) throw new InsufficientFundException("Insufficient Balance!");
		
		srcAccount.setBalance(srcAccount.getBalance() - dto.getAmount());
		destAccount.setBalance(destAccount.getBalance() + dto.getAmount());
		
		adao.save(srcAccount);
		adao.save(destAccount);
		
		return "Transaction successful!";
	}

}
