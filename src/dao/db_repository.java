package dao;

import model.usfoodbeverage;

import java.sql.*;

public class db_repository {
    Connection db_connection = null;

    public db_repository() {
        db_connect my_connect = new db_connect();
        db_connection = my_connect.get_db_connection();

    }

    public ResultSet get_usfoodbeverages() {
        ResultSet fb_resultSet = null;
        try {
            Statement fb_statement = db_connection.createStatement();
            fb_resultSet = fb_statement.executeQuery("select * from usfoodbeverage");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fb_resultSet;


    }

    public Boolean insert_beverages(usfoodbeverage beverages) {

        try {
            String insert = "INSERT INTO usfoodbeverage(series_id,year,period,value) VALUES(?,?,?,?);";

            PreparedStatement insertStmt = db_connection.prepareStatement(insert);

            insertStmt.setString(1, beverages.getseries_id());
            insertStmt.setString(2, beverages.getYear());
            insertStmt.setString(3, beverages.getPeriod());
            insertStmt.setString(4, beverages.getValue());

            insertStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public Boolean update_beverages(usfoodbeverage beverages) {


        try {
            String update = "UPDATE usfoodbeverage SET value=? WHERE series_id=?;";
            PreparedStatement updateStmt = db_connection.prepareStatement(update);

            updateStmt = db_connection.prepareStatement(update);

            updateStmt.setString(1, beverages.getValue());
            updateStmt.setString(2, beverages.getseries_id());
            updateStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;


    }
    public Boolean delete_beverages(usfoodbeverage beverages) {

        try {
            String delete = "DELETE FROM usfoodbeverage WHERE series_id=?;";

            PreparedStatement deleteStmt = db_connection.prepareStatement(delete);

            deleteStmt = db_connection.prepareStatement(delete);
            deleteStmt.setString(1,beverages .getseries_id());
            deleteStmt.executeUpdate();

            System.out.println("Delete Successful!!");

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
            return true;
        }
    }


