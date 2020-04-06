package dao;


import dao.*;
import model.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main{
    public static void main(String[] args){


            /*db_repository fb_repository=new db_repository();
            usfoodbeverage foodbev= new usfoodbeverage("CCCW709","2020","M4","15");
            Boolean insertresult = fb_repository.insert_beverages(foodbev);
            System.out.println("values inserted");
            usfoodbeverage updatebev= new usfoodbeverage("CCCW709","100");
            Boolean updateresult = fb_repository.update_beverages(updatebev);
            usfoodbeverage deletebev= new usfoodbeverage("CCCW709");
            Boolean deleteresult = fb_repository.delete_beverages(deletebev);

            ResultSet resultSet = fb_repository.get_usfoodbeverages();
            while(true){
                try {
                    if (!resultSet.next()) break;
                    String series_id = resultSet.getString(1);
                    int year=resultSet.getInt(2);
                    String period=resultSet.getString( 3);
                    int value=resultSet.getInt(4);
                    System.out.println(series_id+" "+value);
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }*/
            populationsizedao pb_repository= new populationsizedao();
            populationsize population = new populationsize("CCW1234","2020","M4","150");
            Boolean insertresult =pb_repository.insert_population(population);
            populationsize updatepopulation = new populationsize("CCW1234","15");
            Boolean updateresult =pb_repository.update_population(updatepopulation);
            populationsize deletepopulation = new populationsize("AAA","15");
            Boolean deleteresult =pb_repository.delete_population(deletepopulation);
            System.out.println(insertresult);

            ResultSet resultSet = pb_repository.get_populationsize();
            while(true){
                try {
                    if (!resultSet.next()) break;
                    String series_id = resultSet.getString(1);
                    int year=resultSet.getInt(2);
                    String period=resultSet.getString( 3);
                    int value=resultSet.getInt(4);
                    System.out.println(series_id+" "+value);
                }   catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        /*ushousingdao fb_repository= new ushousingdao();
        ushousing housing = new ushousing("AAA","2020","M4","150");
        Boolean insertresult =fb_repository.insert_ushousing(housing);
        ushousing updateushousing = new ushousing("AAA","15");
        Boolean updateresult =fb_repository.update_ushousing(updateushousing);
        ushousing deleteushousing = new ushousing("CWUSS000SEHF02","188");
        Boolean deleteresult =fb_repository.delete_ushousing(deleteushousing);
        System.out.println(insertresult);

        ResultSet resultSet = fb_repository.get_ushousing();
        while(true){
            try {
                if (!resultSet.next()) break;
                String series_id = resultSet.getString(1);
                int year=resultSet.getInt(2);
                String period=resultSet.getString( 3);
                int value=resultSet.getInt(4);
                System.out.println(series_id+" "+value);
            }   catch (SQLException e) {
                e.printStackTrace();
            }
        }*/






    }
}
