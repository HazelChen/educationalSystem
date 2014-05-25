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
		daoHelper = new DaoHelper();
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
			daoHelper.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userAccount;
	}
}
