package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Food;
import model.FoodEtl;
import model.FoodNew;

import dao.FoodDao;


public class FoodEtlDao {

	protected ConnectionManager connectionManager;

	// Single pattern: instantiation is limited to one object.
	private static FoodEtlDao instance = null;

	protected FoodEtlDao() {
		// TODO Auto-generated constructor stub

		connectionManager = new ConnectionManager();
	}

	public static FoodEtlDao getInstance() {
		if (instance == null) {
			instance = new FoodEtlDao();
		}
		return instance;
	}

	
	
	public FoodEtl getNameByItemId(String itemid, String year, String period) throws SQLException {
		String select = "SELECT item, item_name, year, period FROM etl_food WHERE item=? AND year=? AND period=?;";

		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(select);
			selectStmt.setString(1, itemid);
			selectStmt.setString(2, year);
			selectStmt.setString(3, period);

			results = selectStmt.executeQuery();
			if (results.next()) {

				String id = results.getString("item");
				String name = results.getString("item_name");
				String y = results.getString("year");
				String per = results.getString("period");

				FoodEtl f = new FoodEtl(id, name, y, per);
				return f;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (selectStmt != null) {
				selectStmt.close();
			}
			if (results != null) {
				results.close();
			}
		}
		return null;
	}
	
	
	public FoodEtl updateValue(FoodEtl f, String newVal) throws SQLException {

		String update = "UPDATE etl_food SET value=? WHERE item=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(update);

			updateStmt.setString(1, newVal);
			updateStmt.setString(2, f.getItem());
			updateStmt.executeUpdate();

			f.setValue(newVal);

			return f;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (updateStmt != null) {
				updateStmt.close();
			}
		}

	}

	public FoodEtl delete(FoodNew food) throws SQLException {
		String delete = "DELETE FROM etl_food WHERE item=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(delete);
			deleteStmt.setString(1, food.getItem());
			deleteStmt.executeUpdate();

			System.out.println("Delete Successful!!");
			// Return null so the caller can no longer operate on the Persons instance.
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (deleteStmt != null) {
				deleteStmt.close();
			}
		}
	}

}
