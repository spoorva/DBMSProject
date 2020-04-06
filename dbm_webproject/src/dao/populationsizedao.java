package dao;
import model.populationsize;

import java.sql.*;

public class populationsizedao {
    Connection db_connection = null;

    public populationsizedao() {
        db_connect my_connect = new db_connect();
        db_connection = my_connect.get_db_connection();

    }
    public ResultSet get_populationsize(){
        ResultSet pb_resultSet = null;
        try {
            Statement pb_statement = db_connection.createStatement();
            pb_resultSet = pb_statement.executeQuery("select * from populationsize");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pb_resultSet;


    }
    public Boolean insert_population(populationsize population) {

        try {
            String insert = "INSERT INTO populationsize(series_id,year,period,value) VALUES(?,?,?,?);";

            PreparedStatement insertStmt = db_connection.prepareStatement(insert);

            insertStmt.setString(1, population.getseries_id());
            insertStmt.setString(2, population.getYear());
            insertStmt.setString(3, population.getPeriod());
            insertStmt.setString(4, population.getValue());

            insertStmt.executeUpdate();
            System.out.println("populationsize is inserted");

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public Boolean update_population(populationsize population) {


        try {
            String update = "UPDATE populationsize SET value=? WHERE series_id=?;";
            PreparedStatement updateStmt = db_connection.prepareStatement(update);

            updateStmt = db_connection.prepareStatement(update);

            updateStmt.setString(1, population.getValue());
            updateStmt.setString(2, population.getseries_id());
            updateStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;


    }
    public Boolean delete_population(populationsize population) {

        try {
            String delete = "DELETE FROM populationsize WHERE series_id=?;";

            PreparedStatement deleteStmt = db_connection.prepareStatement(delete);

            deleteStmt = db_connection.prepareStatement(delete);
            deleteStmt.setString(1,population .getseries_id());
            deleteStmt.executeUpdate();

            System.out.println("Delete Successful!!");

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
        return true;
    }
}


