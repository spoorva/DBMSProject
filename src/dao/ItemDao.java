package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Item;

public class ItemDao {

	protected ConnectionManager connectionManager;
	
	// Single pattern: instantiation is limited to one object.
	private static ItemDao instance = null;
	protected ItemDao() {
		connectionManager = new ConnectionManager();
	}
	public static ItemDao getInstance() {
		if(instance == null) {
			instance = new ItemDao();
		}
		System.out.println("Instance created");
		return instance;
	}

	
	 public Item create(Item item) throws SQLException {
		String insert = "INSERT INTO item(item,item_name,display_level, selectable, sort_sequence) VALUES(?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insert);
			
			insertStmt.setString(1, item.getItem());
			insertStmt.setString(2, item.getItem_name());
			insertStmt.setString(3, item.getDisplay_level());
			insertStmt.setString(4, item.getSelectable());
			insertStmt.setString(5, item.getSort_sequence());
				
			insertStmt.executeUpdate();
			
			return item;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(insertStmt != null) {
				insertStmt.close();
			}
		}


	
}
	 
	 public Item getItemByItemId(String item) throws SQLException {
		 String select = "SELECT item,item_name FROM item WHERE item=?;";
		 
			Connection connection = null;
			PreparedStatement selectStmt = null;
			ResultSet results = null;
			try {
				connection = connectionManager.getConnection();
				selectStmt = connection.prepareStatement(select);
				selectStmt.setString(1, item);
				
				results = selectStmt.executeQuery();
				if(results.next()) {
					
					String itemId = results.getString("item");
					String itemDetails = results.getString("item_name");
					

					Item i = new Item(itemId, itemDetails);
					return i;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			} finally {
				if(connection != null) {
					connection.close();
				}
				if(selectStmt != null) {
					selectStmt.close();
				}
				if(results != null) {
					results.close();
				}
			}
			return null;
		}
	 
	 
	 
	 public Item updateItemDetails(Item item, String newDetails) throws SQLException {
		 
		 
		 String update = "UPDATE item SET item_name=? WHERE item=?;";
			Connection connection = null;
			PreparedStatement updateStmt = null;
			try {
				connection = connectionManager.getConnection();
				updateStmt = connection.prepareStatement(update);
				
				updateStmt.setString(1, newDetails);
				updateStmt.setString(2, item.getItem());
				updateStmt.executeUpdate();

				item.setItem_name(newDetails);
				
				return item;
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			} finally {
				if(connection != null) {
					connection.close();
				}
				if(updateStmt != null) {
					updateStmt.close();
				}
			}


		 
	 }
	 

	 public Item delete(Item item) throws SQLException {
			String delete = "DELETE FROM item WHERE item=?;";
			Connection connection = null;
			PreparedStatement deleteStmt = null;
			try {
				connection = connectionManager.getConnection();
				deleteStmt = connection.prepareStatement(delete);
				deleteStmt.setString(1, item.getItem());
				deleteStmt.executeUpdate();

				System.out.println("Delete Successful!!");
				// Return null so the caller can no longer operate on the Persons instance.
				return null;
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			} finally {
				if(connection != null) {
					connection.close();
				}
				if(deleteStmt != null) {
					deleteStmt.close();
				}
			}
		}

	 
	 

	 }

