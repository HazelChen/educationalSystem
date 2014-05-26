package emsystem.service;

import emsystem.dao.AccountDAO;
import emsystem.model.Account;


public class AccountService {
	private AccountDAO accountDAO;
	
	public AccountService() {
		accountDAO = new AccountDAO();
	}
	
	public boolean login(String pId, String pPassword) {
		Account account = accountDAO.getAccount(pId);
		boolean result = false;
		if (account != null) {
			if (account.getPassword().equals(pPassword)) {
				result = true;
			}
		}
		return result;
	}
	
	public boolean add(Account account) {
		return accountDAO.add(account);
	}
}
