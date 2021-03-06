package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Food;
import model.FoodNew;

import dao.FoodDao;


public class FoodNewDao {

	protected ConnectionManager connectionManager;

	// Single pattern: instantiation is limited to one object.
	private static FoodNewDao instance = null;

	protected FoodNewDao() {
		// TODO Auto-generated constructor stub

		connectionManager = new ConnectionManager();
	}

	public static FoodNewDao getInstance() {
		if (instance == null) {
			instance = new FoodNewDao();
		}
		return instance;
	}

	public FoodNew create(FoodNew food) throws SQLException {
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
			
			String id = food.getItem();
			id = id.substring(9);
			
			Food f = new Food(id, food.getYear(), food.getPeriod(), food.getValue());
			new FoodDao().create(f);
			
			
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

	
	public FoodNew getValueByItemId(String itemid) throws SQLException {
		String select = "SELECT item, value FROM food_new WHERE item=?;";

		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(select);
			selectStmt.setString(1, itemid);

			results = selectStmt.executeQuery();
			if (results.next()) {

				String id = results.getString("item");
				String val = results.getString("value");

				FoodNew f = new FoodNew(id, val);
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
	
	
	public FoodNew updateValue(FoodNew f, String newVal) throws SQLException {

		String update = "UPDATE food_new SET value=? WHERE item=?;";
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

	public FoodNew delete(FoodNew food) throws SQLException {
		String delete = "DELETE FROM food_new WHERE item=?;";
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
