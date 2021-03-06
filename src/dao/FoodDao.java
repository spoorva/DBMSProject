package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ConnectionManager;
import model.Food;
import model.FoodNew;


public class FoodDao {

	protected ConnectionManager connectionManager;

	// Single pattern: instantiation is limited to one object.
	private static FoodDao instance = null;

	protected FoodDao() {
		// TODO Auto-generated constructor stub

		connectionManager = new ConnectionManager();
	}

	public static FoodDao getInstance() {
		if (instance == null) {
			instance = new FoodDao();
		}
		return instance;
	}

	public Food create(Food food) throws SQLException {
		
		
		String insert = "INSERT INTO food_new(item,year,period,value) VALUES(?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insert);

			insertStmt.setString(1, food.getItem());
			insertStmt.setString(2, food.getYear());
			insertStmt.setString(3, food.getPeriod());
			insertStmt.setString(4, food.getValue());
			
			insertStmt.executeUpdate();

			return food;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (insertStmt != null) {
				insertStmt.close();
			}
		}

	}

	
	public Food getValueByItemId(String itemid) throws SQLException {
		String select = "SELECT item_id, value FROM food_new WHERE item_id=?;";

		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(select);
			selectStmt.setString(1, itemid);

			results = selectStmt.executeQuery();
			if (results.next()) {

				String id = results.getString("item_id");
				String val = results.getString("value");

				Food f = new Food(id, val);
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
	
	
	public Food updateValue(Food f, String newVal) throws SQLException {

		String update = "UPDATE food SET value=? WHERE item=?;";
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

	public Food delete(Food food) throws SQLException {
		String delete = "DELETE FROM food WHERE item=?;";
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
