package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db_connect {
    private static Connection connect=null;

    private static String url = null;
    private static String user = null , password = null;

    public db_connect(){
        url= "jdbc:mysql://localhost:3306/dbm_project";
        user="root" ;
        password = "Jam@1339";
    }
    public Connection get_db_connection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connect;
    }
}
