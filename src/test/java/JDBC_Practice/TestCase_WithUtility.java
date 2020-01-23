package JDBC_Practice;

import Utility.DataBaseUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

public class TestCase_WithUtility {

    @Test
    public void test1() throws SQLException {
        ResultSet result = DataBaseUtility.getResult("select * from employees");

        while(result.next()){

            String lastName = result.getString("last_name");
            String firstName = result.getString("first_name");
            String fullName = firstName + " " + lastName;
            String salary = result.getString("salary");
            System.out.println(fullName + " ==> " + salary);
        }
    }

    @Test(description = "verify that steven king has the hihest salary")
    public void test2() throws SQLException {
        ResultSet result = DataBaseUtility.getResult("select * from employees");

        List<Integer> salaries = new ArrayList<Integer>();
        for (int i =0; result.next();)
           salaries.add(result.getInt("salary"));
           Collections.sort(salaries);
            int maxSalary = salaries.get(salaries.size()-1);
        System.out.println(maxSalary);

        String richestGuy = "";
        result =  DataBaseUtility.getResult("select * from employees");
        while (result.next()){
            int money = result.getInt("salary");
               String fullName = result.getString(2)+ " " + result.getString(3);
                if(money == maxSalary){
                    richestGuy = fullName;
            }
        }
        System.out.println(richestGuy);

        Assert.assertEquals(richestGuy, "Steven King");

         result = DataBaseUtility.getResult("select * from employees");
        ResultSetMetaData rsm = result.getMetaData();

        System.out.println("Total number of columns: " + rsm.getColumnCount());  // Total number of columns: 6
        System.out.println("First column name is: " + rsm.getColumnName(1));
        System.out.println("Second column name is: " + rsm.getColumnName(2));
        System.out.println("Third column name is: " + rsm.getColumnName(3));
        System.out.println("Forth column name is: " + rsm.getColumnName(4));
        System.out.println("Fifth column name is: " + rsm.getColumnName(5));
        System.out.println("Sixth column name is: " + rsm.getColumnName(6));
        System.out.println(rsm.getColumnDisplaySize(2));
        System.out.println(rsm.getColumnDisplaySize(1));
        System.out.println(rsm.getColumnDisplaySize(3));
        System.out.println(rsm.getColumnDisplaySize(6));

        String[] allColumnNamesOfEmployeeTable = new String[rsm.getColumnCount()];
        for(int i = 0; i < allColumnNamesOfEmployeeTable.length; i++){
            allColumnNamesOfEmployeeTable[i] = rsm.getColumnName(i+1);
        }
        System.out.println(Arrays.toString(allColumnNamesOfEmployeeTable));
        // [EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID]



    }


        @Test(description = "Get Meta Data information")
        public void testMetaData() throws SQLException {

        //===================================== META DATA ==============================================

        System.out.println("=================== METADATA ========================================");


        ResultSet result = DataBaseUtility.getResult("select * from locations");

        ResultSetMetaData rsm = result.getMetaData();

        System.out.println("Total number of columns: " + rsm.getColumnCount());  // Total number of columns: 6
        System.out.println("First column name is: " + rsm.getColumnName(1));  // First column name is: LOCATION_ID
        System.out.println("Second column name is: " + rsm.getColumnName(2));  // Second column name is: STREET_ADDRESS
        System.out.println("Thrid column name is: " + rsm.getColumnName(3));  // Thrid column name is: POSTAL_CODE
        System.out.println("Forth column name is: " + rsm.getColumnName(4));  // Forth column name is: CITY
        System.out.println("Fifth column name is: " + rsm.getColumnName(5));  // Fifth column name is: STATE_PROVINCE
        System.out.println("Sixth column name is: " + rsm.getColumnName(6));  // Sixth column name is: COUNTRY_ID
        System.out.println("get Column Display Size: " + rsm.getColumnDisplaySize(3));  // get Column Display Size: 12
        System.out.println("get Column Type: " + rsm.getColumnType(3));  // get Column Type: 12
        System.out.println("getTableName: " + rsm.getTableName(1));  // getTableName:


         String[] allColumnNames = new String[rsm.getColumnCount()];
         for(int i = 0; i< allColumnNames.length; i++){
//             allColumnNames[0] = rsm.getColumnName(1);
//             allColumnNames[1] = rsm.getColumnName(2);
//             allColumnNames[2] = rsm.getColumnName(3);  instaead of using this method

            allColumnNames[i] = rsm.getColumnName(i+1);

         }
            System.out.println(Arrays.toString(allColumnNames));
        }



}
