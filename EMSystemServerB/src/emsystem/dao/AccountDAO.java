package emsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import emsystem.model.Account;

public class AccountDAO {
	private static final String TABLE_NAME = "account";
	
	private DaoHelper daoHelper;

	public AccountDAO() {
		daoHelper = DaoHelper.getInstance();
	}

	public Account getAccount(String id) {
		PreparedStatement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		Account userAccount = null;

		try {
			connection = daoHelper.getConnection();
			statement = connection.prepareStatement("select * from " + TABLE_NAME + " where ’Àªß = ?");
			statement.setString(1, id);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				userAccount = new Account();
				userAccount.setName(id);
				userAccount.setPassword(resultSet.getString(2));
				userAccount.setCompetence(Integer.parseInt(resultSet.getString(3)));
			}

			daoHelper.closePreparedStatement(statement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userAccount;
	}
	
	public boolean add(Account account) {
		try {
			Connection connection = daoHelper.getConnection();
			PreparedStatement statement = connection.prepareStatement("insert into ’Àªß±Ì values(?,?,?)");
			statement.setString(1, account.getName());
			statement.setString(2, account.getPassword());
			statement.setInt(3, account.getCompetence());
			statement.execute();
		
			daoHelper.closePreparedStatement(statement);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
