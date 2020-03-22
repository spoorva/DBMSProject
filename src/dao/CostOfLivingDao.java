package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.CostOfLiving;
import model.FoodNew;

public class CostOfLivingDao {
	
	protected ConnectionManager connectionManager;

	// Single pattern: instantiation is limited to one object.
	private static CostOfLivingDao instance = null;

	protected CostOfLivingDao() {
		// TODO Auto-generated constructor stub

		connectionManager = new ConnectionManager();
	}
	
	public static CostOfLivingDao getInstance() {
		if (instance == null) {
			instance = new CostOfLivingDao();
		}
		return instance;
	}



	public CostOfLiving create(CostOfLiving c) throws SQLException {
		String insert = "INSERT INTO cost_of_living( place,  meal,  water, "
				+ " milk,  whiteBread,  eggs, localCheese,  chicken,  apples,  oranges,  potato,  lettuce, cappuccino, "
				+ " rice,  tomato,  banana,  onion,  beef) VALUES(?,?,?,?,?,?,?,?, ?,?,?,?, ?,?,?,?, ?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insert);
			
			insertStmt.setString(1,c.getPlace());
			insertStmt.setString(2,c.getMeal());
			insertStmt.setString(3,c.getWater());
			insertStmt.setString(4,c.getMilk());
			insertStmt.setString(5,c.getWhiteBread());
			insertStmt.setString(6,c.getEggs());
			insertStmt.setString(7,c.getLocalCheese());
			insertStmt.setString(8,c.getChicken());
			insertStmt.setString(9,c.getApples());
			insertStmt.setString(10,c.getOranges());
			insertStmt.setString(11,c.getPotato());
			insertStmt.setString(12,c.getLettuce());
			insertStmt.setString(13,c.getCappuccino());
			insertStmt.setString(14,c.getRice());
			insertStmt.setString(15,c.getTomato());
			insertStmt.setString(16,c.getBanana());
			insertStmt.setString(17,c.getOnion());
			insertStmt.setString(18,c.getBeef());
			
			insertStmt.executeUpdate();

			return c;
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

	
	
	
}


