package JDBC_Practice;

import java.sql.*;

public class SimpleConnection {

    public static void main(String[] args) throws SQLException {

        /*
        hostname =  18.208.128.175
        port = 1521
        SID = xi
        URL formula =
         */

        String url = "jdbc:oracle:thin:@18.208.128.175:1521:xe";
        String username = "hr";
        String password = "hr";


        // Step 1:
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("connection");

        // Step 2:
        Statement statement = connection.createStatement();
        // select * from .............
        ResultSet result = statement.executeQuery("select * from countries");

        while(result.next()){
            String countryName = result.getString("country_name");
            int region_id = result.getInt("region_id");

            System.out.println(countryName);
            System.out.println(region_id);


        }



    }



}
