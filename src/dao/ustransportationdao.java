package dao;

import model.ustransportation;

import java.sql.*;

public class ustransportationdao {
    Connection db_connection = null;

    public ustransportationdao() {
        db_connect my_connect = new db_connect();
        db_connection = my_connect.get_db_connection();

    }
    public ResultSet get_ustransportation(){
        ResultSet hb_resultSet = null;
        try {
            Statement hb_statement = db_connection.createStatement();
            hb_resultSet = hb_statement.executeQuery("select * from ustransportation");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hb_resultSet;


    }
    public Boolean insert_ustransportation(ustransportation trans) {

        try {
            String insert = "INSERT INTO ustransportation(series_id,year,period,value) VALUES(?,?,?,?);";

            PreparedStatement insertStmt = db_connection.prepareStatement(insert);

            insertStmt.setString(1, trans.getseries_id());
            insertStmt.setString(2, trans.getYear());
            insertStmt.setString(3, trans.getPeriod());
            insertStmt.setString(4, trans.getValue());

            insertStmt.executeUpdate();
            System.out.println("ushousing is inserted");

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public Boolean update_ustransportation(ustransportation trans) {


        try {
            String update = "UPDATE ustransportation SET value=? WHERE series_id=?;";
            PreparedStatement updateStmt = db_connection.prepareStatement(update);

            updateStmt = db_connection.prepareStatement(update);

            updateStmt.setString(1, trans.getValue());
            updateStmt.setString(2, trans.getseries_id());
            updateStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;


    }
    public Boolean delete_ustransportation(ustransportation trans) {

        try {
            String delete = "DELETE FROM ustransportation WHERE series_id=?;";

            PreparedStatement deleteStmt = db_connection.prepareStatement(delete);

            deleteStmt = db_connection.prepareStatement(delete);
            deleteStmt.setString(1,trans .getseries_id());
            deleteStmt.executeUpdate();

            System.out.println("Delete Successful!!");

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
        return true;
    }
}
