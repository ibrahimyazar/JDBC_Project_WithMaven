package JDBC_Practice;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.*;

public class JDBC_TestCases {

    Connection connection;
    Statement statement;

    @BeforeMethod
    public void setup() throws SQLException {
        String url = "jdbc:oracle:thin:@18.208.128.175:1521:xe";
        String username = "hr";
        String password = "hr";

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (Exception e) {
        }
    }


    @Test(description = "Verify that seyfo salary grater tahn hakn salary")
    public void test1() throws SQLException {

        int seyfoSalary = 0,
                hakanSalary = 0;

        String query = "select * from testers";

        ResultSet result = statement.executeQuery(query);

        while (result.next()) {

            String name = result.getString(2);
            int salary = result.getInt(3);

            if (name.equals("Seyfo")) {
                seyfoSalary = salary;
            }
            if (name.equals("Hakan")) {
                hakanSalary = salary;
            }
        }

        System.out.println("Seyfo salary: " + seyfoSalary);
        System.out.println("Hakan salary: " + hakanSalary);
          /*
          Seyfo salary: 110000
          Hakan salary: 105000
           */
        Assert.assertTrue(seyfoSalary > hakanSalary);
        sleepForNow(5);
    }

    public void sleepForNow(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception ne) {
        }
    }


    // System.out.println(name + " ==> " + salary);
          /*
            Seyfo ==> 110000
            Hakan ==> 105000
            ibrohim ==> 100000

           */
}
