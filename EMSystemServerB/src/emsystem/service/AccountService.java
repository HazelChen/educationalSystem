package emsystem.service;

import emsystem.dao.AccountDAO;
import emsystem.model.Account;


public class AccountService {
	private AccountDAO accountDAO;
	
	public AccountService() {
		accountDAO = new AccountDAO();
	}
	
	public boolean studentLogin(String id, String password) {
		return login(id, password, 0);
	}
	
	public boolean adminLogin(String id, String password) {
		return login(id, password, 1);
	}
	
	private boolean login(String pId, String pPassword, int competence) {
		Account account = accountDAO.getAccount(pId);
		boolean result = false;
		if (account != null) {
			if (account.getPassword().equals(pPassword) && account.getCompetence() == competence) {
				result = true;
			}
		}
		return result;
	}
	
	public boolean add(Account account) {
		return accountDAO.add(account);
	}
}
