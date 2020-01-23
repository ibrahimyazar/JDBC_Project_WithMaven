package Utility;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties configFile;
    static{
        try{
            FileInputStream fileInputStream = new FileInputStream("configuration.properties");
            configFile = new Properties();
            configFile.load(fileInputStream);
            fileInputStream.close();
        }catch (IOException e){
        }
    }

    public static String getProperty(String key){
        return configFile.getProperty(key);
    }

    @Test(description = "Print the URL, UserName And Password")
    public static void main(String[] args) {
        System.out.println(getProperty("JDBC_URL"));        // jdbc:oracle:thin:@18.208.128.175:1521:xe
        System.out.println(getProperty("JDBC_UserName"));  // hr
        System.out.println(getProperty("JDBC_PassWord"));  // hr
    }




}
