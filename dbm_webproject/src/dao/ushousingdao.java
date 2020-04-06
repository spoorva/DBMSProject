package dao;
import model.ushousing;

import java.sql.*;

public class ushousingdao {
    Connection db_connection = null;

    public ushousingdao() {
        db_connect my_connect = new db_connect();
        db_connection = my_connect.get_db_connection();

    }
    public ResultSet get_ushousing(){
        ResultSet hb_resultSet = null;
        try {
            Statement hb_statement = db_connection.createStatement();
            hb_resultSet = hb_statement.executeQuery("select * from ushousing");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hb_resultSet;


    }
    public Boolean insert_ushousing(ushousing housing) {

        try {
            String insert = "INSERT INTO ushousing(series_id,year,period,value) VALUES(?,?,?,?);";

            PreparedStatement insertStmt = db_connection.prepareStatement(insert);

            insertStmt.setString(1, housing.getseries_id());
            insertStmt.setString(2, housing.getYear());
            insertStmt.setString(3, housing.getPeriod());
            insertStmt.setString(4, housing.getValue());

            insertStmt.executeUpdate();
            System.out.println("ushousing is inserted");

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public Boolean update_ushousing(ushousing housing) {


        try {
            String update = "UPDATE ushousing SET value=? WHERE series_id=?;";
            PreparedStatement updateStmt = db_connection.prepareStatement(update);

            updateStmt = db_connection.prepareStatement(update);

            updateStmt.setString(1, housing.getValue());
            updateStmt.setString(2, housing.getseries_id());
            updateStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;


    }
    public Boolean delete_ushousing(ushousing housing) {

        try {
            String delete = "DELETE FROM ushousing WHERE series_id=?;";

            PreparedStatement deleteStmt = db_connection.prepareStatement(delete);

            deleteStmt = db_connection.prepareStatement(delete);
            deleteStmt.setString(1,housing .getseries_id());
            deleteStmt.executeUpdate();

            System.out.println("Delete Successful!!");

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
        return true;
    }
}

