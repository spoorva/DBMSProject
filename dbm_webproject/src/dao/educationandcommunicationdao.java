package dao;
import model.educationandcommunication;

import java.sql.*;

public class educationandcommunicationdao {
    Connection db_connection = null;

    public educationandcommunicationdao() {
        db_connect my_connect = new db_connect();
        db_connection = my_connect.get_db_connection();

    }
    public ResultSet get_educationandcommunication(){
        ResultSet pb_resultSet = null;
        try {
            Statement pb_statement = db_connection.createStatement();
            pb_resultSet = pb_statement.executeQuery("select * from educationandcommunication");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pb_resultSet;


    }
    public Boolean insert_educationandcommunicationdao(educationandcommunication edu) {

        try {
            String insert = "INSERT INTO educationandcommunication(series_id,year,period,value) VALUES(?,?,?,?);";

            PreparedStatement insertStmt = db_connection.prepareStatement(insert);

            insertStmt.setString(1, edu.getseries_id());
            insertStmt.setString(2, edu.getYear());
            insertStmt.setString(3, edu.getPeriod());
            insertStmt.setString(4, edu.getValue());

            insertStmt.executeUpdate();
            System.out.println("educationandcommunication is inserted");

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public Boolean update_educationandcommunicationdao(educationandcommunication edu) {


        try {
            String update = "UPDATE educationandcommunication SET value=? WHERE series_id=?;";
            PreparedStatement updateStmt = db_connection.prepareStatement(update);

            updateStmt = db_connection.prepareStatement(update);

            updateStmt.setString(1, edu.getValue());
            updateStmt.setString(2, edu.getseries_id());
            updateStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;


    }
    public Boolean delete_educationandcommunicationdao(educationandcommunication edu) {

        try {
            String delete = "DELETE FROM educationandcommunication WHERE series_id=?;";

            PreparedStatement deleteStmt = db_connection.prepareStatement(delete);

            deleteStmt = db_connection.prepareStatement(delete);
            deleteStmt.setString(1,edu .getseries_id());
            deleteStmt.executeUpdate();

            System.out.println("Delete Successful!!");

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
        return true;
    }
}
