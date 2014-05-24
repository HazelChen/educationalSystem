package edu.nju.educationSystem.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

public class DatabaseUtils {

	/**
	 * 可执行增加删除等不需要返回数据的命令
	 */
	public boolean excute(String pOrder) {
		try {
			Connection connection = ConnectionFactory.getInstance()
					.getConnection();
			Statement statement = connection.createStatement();
			statement.execute(pOrder);
			statement.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 返回调用 数据库查询语句的结果集(完全匹配)
	 */
	public ResultSet getResultSetByWholeWord(String pTableName, String keyword,
			String matchword) {
		ResultSet rs = null;
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			String sql = "select * from " + pTableName + " where " + keyword
					+ "='" + matchword + "'";
			System.out.println(sql);
			PreparedStatement pstm = connection.prepareStatement(sql);
			rs = pstm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}
	
	/**
	 * 返回调用 数据库查询语句的结果集（前缀匹配）
	 */
	public ResultSet getResultSetByPrefix(String pTableName, String keyword,
			String prefix) {
		ResultSet rs = null;
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			
			String sql = "SELECT * FROM " + pTableName + " WHERE " + keyword + " like '" + prefix + "%'";
			PreparedStatement pstm = connection.prepareStatement(sql);
			rs = pstm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}
	
/*
	public ResultSet pdSearch(String sql) {
		ResultSet rs = null;
		try {
			Connection connection = ConnectionFactory.getConnection();

			PreparedStatement pstm = connection.prepareStatement(sql);
			rs = pstm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}
	
	

	public static PreparedStatement pd(String sql) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement pd = null;
		try {
			pd = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pd;
	}

	/**
	 * 公共search接口
	 * 
	 * @param tableName
	 * @param pOrder
	 * @param pColumnNumber
	 *            要search的列 的编号
	 * @return
	 */
/*	public static POJO[] search(String tableName, String pOrder, int pBegin,
			int pEnd) {
		try {
			if (pEnd < pBegin - 1)
				throw new IllegalArgumentException(
						"pEnd should not be less than pBegin!");

			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement psmt = connection.prepareStatement(pOrder);
			ResultSet resultSet = psmt.executeQuery();
			// 在索要下标之前的不要的先丢掉
			int i = 0;
			while (i < pBegin && resultSet.next()) {
				i++;
			}
			// 各找各妈加入链表
			LinkedList<POJO> pojoLinkedList = null;
			POJO[] pojoArrays = null;
			int length = pEnd - pBegin + 1;
			if (tableName.equals(OrderDBData.TABLE_NAME)) {
				pojoLinkedList = toOrderPOJO(resultSet, pBegin, pEnd);
				pojoArrays = new OrderPOJO[length];
			} else if (tableName.equals(PromotionDBData.TABLE_NAME)) {
				pojoLinkedList = toPromotionItemPOJO(resultSet, pBegin, pEnd);
				pojoArrays = new PromotionItemPOJO[length];
			}

			// 将链表转化为数组并填补空的部分
			pojoArrays = pojoLinkedList.toArray(pojoArrays);
			for (int j = pojoArrays.length - 1; j > pojoLinkedList.size() - 1; j--) {
				pojoArrays[j] = null;// 所有空的都指向一个引用，似乎不大好，但只是暂存和显示，应该没事吧
			}

			psmt.close();
			return pojoArrays;

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 实现不翻页的search 因为只有promotionIterm需要。。就先实现promotion的
	 */
/*	public static PromotionItemPOJO[] searchPromotion(String pOrder) {
		try {
			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement psmt = connection.prepareStatement(pOrder);
			ResultSet resultSet = psmt.executeQuery();

			LinkedList<PromotionItemPOJO> pojoLinkedList = null;
			PromotionItemPOJO[] pojoArrays = null;
			pojoLinkedList = toPromotionItemPOJO(resultSet);

			pojoArrays = new PromotionItemPOJO[pojoLinkedList.size()];
			pojoArrays = pojoLinkedList.toArray(pojoArrays);

			psmt.close();
			return pojoArrays;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static LinkedList<PromotionItemPOJO> toPromotionItemPOJO(
			ResultSet pResultSet) throws SQLException {
		LinkedList<PromotionItemPOJO> promotionItemPOJOs = new LinkedList<>();
		while (pResultSet.next()) {
			String id = pResultSet.getString(PromotionDBData.INDEX_ID + 1);
			String date = pResultSet.getString(PromotionDBData.INDEX_DATE + 1);
			String grade = pResultSet
					.getString(PromotionDBData.INDEX_GRADE + 1);
			String discountCoupons = pResultSet
					.getString(PromotionDBData.INDEX_DISCOUNTCOUPON + 1);
			String equalCoupons = pResultSet
					.getString(PromotionDBData.INDEX_EQUALCOUPON + 1);
			PromotionItemPOJO promotionItemPOJO = new PromotionItemPOJO(id,
					date, grade, discountCoupons, equalCoupons);
			promotionItemPOJOs.add(promotionItemPOJO);
		}
		return promotionItemPOJOs;
	}

	private static LinkedList<POJO> toPromotionItemPOJO(ResultSet pResultSet,
			int pBegin, int pEnd) throws SQLException {
		LinkedList<POJO> promotionItemPOJOs = new LinkedList<>();
		int i = pBegin;
		while (pResultSet.next() && i <= pEnd) {
			String id = pResultSet.getString(PromotionDBData.INDEX_ID + 1);
			String date = pResultSet.getString(PromotionDBData.INDEX_DATE + 1);
			String grade = pResultSet
					.getString(PromotionDBData.INDEX_GRADE + 1);
			String discountCoupons = pResultSet
					.getString(PromotionDBData.INDEX_DISCOUNTCOUPON + 1);
			String equalCoupons = pResultSet
					.getString(PromotionDBData.INDEX_EQUALCOUPON + 1);
			PromotionItemPOJO promotionItemPOJO = new PromotionItemPOJO(id,
					date, grade, discountCoupons, equalCoupons);
			promotionItemPOJOs.add(promotionItemPOJO);
			i++;
		}
		return promotionItemPOJOs;
	}

	private static LinkedList<POJO> toOrderPOJO(ResultSet pResultSet,
			int pBegin, int pEnd) throws SQLException {
		LinkedList<POJO> orderPojos = new LinkedList<>();
		int i = pBegin;
		while (pResultSet.next() && i < pEnd) {
			String[] column = new String[OrderDBData.NUM_OF_COLUMN - 2];
			for (int tempI = 0; tempI < OrderDBData.NUM_OF_COLUMN - 2; tempI++) {
				column[tempI] = pResultSet.getString(tempI + 1);
			}
			double discount = pResultSet
					.getDouble(OrderDBData.INDEX_DISCOUNT + 1);
			double price = pResultSet.getDouble(OrderDBData.NUM_OF_COLUMN);
			OrderPOJO orderPOJO = new OrderPOJO(column[0], column[1],
					column[2], column[3], column[4], column[5], discount, price);
			orderPojos.add(orderPOJO);
			i++;
		}
		return orderPojos;
	}

	

	public static ArrayList<UserPOJO> getUser(String pTableName,
			String keyword, String matchword, int pBegin, int pEnd) {
		ArrayList<UserPOJO> usersPOJO = new ArrayList<UserPOJO>();
		if (pEnd < pBegin - 1)
			throw new IllegalArgumentException(
					"pEnd should be not less than pBegin");
		try {
			ResultSet rs = getResultSet(pTableName, keyword, matchword);
			int i = 0;
			while (i < pBegin && rs.next()) {
				i++;
			}
			while (rs.next() && i <= pEnd) {
				String account = rs
						.getString(UserCommonData.INDEX_USER_ACCOUNT + 1);
				String password = rs.getString(UserCommonData.INDEX_PW + 1);
				String identification = rs
						.getString(UserCommonData.INDEX_IDENTIFY + 1);
				usersPOJO.add(new UserPOJO(account, password, identification));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return usersPOJO;
	}

	public static ArrayList<CustomerPOJO> getCustomer(String pTableName,
			String keyword, String matchword, int pBegin, int pEnd) {
		ArrayList<CustomerPOJO> customersPOJO = new ArrayList<CustomerPOJO>();
		if (pEnd < pBegin - 1)
			throw new IllegalArgumentException(
					"pEnd should not be less than pBegin");
		try {
			ResultSet rs = getResultSet(pTableName, keyword, matchword);
			int i = 0;
			while (i < pBegin && rs.next()) {
				i++;
			}
			while (rs.next() && i <= pEnd) {
				String account = rs
						.getString(CustomerCommonData.INDEX_CUSTOMER_ACCOUNT + 1);
				String name = rs.getString(CustomerCommonData.INDEX_NAME + 1);
				String cellNumber = rs
						.getString(CustomerCommonData.INDEX_CELLNUMBER + 1);
				String address = rs
						.getString(CustomerCommonData.INDEX_ADDRESS + 1);
				String collectionBooks = rs
						.getString(CustomerCommonData.INDEX_BOOKS + 1);
				double creditPoints = rs
						.getDouble(CustomerCommonData.INDEX_CREDITS + 1);
				String euqalCoupons = rs
						.getString(CustomerCommonData.INDEX_EQAUL + 1);
				String discountCoupons = rs
						.getString(CustomerCommonData.INDEX_DISCOUNT + 1);

				customersPOJO.add(new CustomerPOJO(account, name, cellNumber,
						address, collectionBooks, creditPoints, euqalCoupons,
						discountCoupons));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return customersPOJO;
	}

	public static ArrayList<String> getCustomersAccounts() {
		ArrayList<String> accounts = new ArrayList<String>();
		Connection connection = ConnectionFactory.getConnection();
		String sql = "select * from " + CustomerCommonData.CUSTOMER_TABLE;
		PreparedStatement pstm;
		ResultSet resultSet;
		try {
			pstm = connection.prepareStatement(sql);
			resultSet = pstm.executeQuery();
			while (resultSet.next()) {
				accounts.add(resultSet
						.getString(CustomerCommonData.INDEX_CUSTOMER_ACCOUNT + 1));
			}
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	public static Object getSingleObject(String pTableName, String keyword,
			String matchword, int columnIndex) {
		ResultSet rs = getResultSet(pTableName, keyword, matchword);
		try {
			while (rs.next()) {
				return rs.getObject(columnIndex + 1);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static OrderPOJO[] getAllOrders(int pBegin, int pEnd) {
		Connection connection = ConnectionFactory.getConnection();
		LinkedList<OrderPOJO> pojoList = new LinkedList<>();
		if (pEnd < pBegin - 1)
			throw new IllegalArgumentException(
					"pEnd should not be less than pBegin");
		try {
			String sql = "select * from " + OrderDBData.TABLE_NAME;
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet resultSet = pstm.executeQuery();
			int i = 0;
			int rsNum = resultSet.getRow();
			while (i < pBegin && i < rsNum) {
				i++;
			}
			while (resultSet.next() && i <= pEnd) {
				String id = resultSet.getString(OrderDBData.INDEX_ID + 1);
				String user = resultSet.getString(OrderDBData.INDEX_USER + 1);
				String date = resultSet.getString(OrderDBData.INDEX_DATE + 1);
				String books = resultSet.getString(OrderDBData.INDEX_BOOKS + 1);
				String state = resultSet.getString(OrderDBData.INDEX_STATE + 1);
				String eqivalent = resultSet
						.getString(OrderDBData.INDEX_EQIVALENT + 1);
				double discount = resultSet
						.getDouble(OrderDBData.INDEX_DISCOUNT + 1);
				double price = resultSet.getDouble(OrderDBData.INDEX_PRICE + 1);
				pojoList.add(new OrderPOJO(id, user, date, books, state,
						eqivalent, discount, price));
			}
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		OrderPOJO[] pojos = new OrderPOJO[pojoList.size()];
		pojos = pojoList.toArray(pojos);
		return pojos;
	}
*/
}
