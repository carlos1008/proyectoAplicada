package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import utility.myLog;

public class myConnection {
    public static String dbName = "db_proyecto";
    public static String dbUser = "pepe";
    public static String dbPass = "pepe123";
    public static Connection ConectToMysql(){
        Connection con = null;
        try {
            String strCon = "jdbc:mysql://192.168.64.2/"+dbName;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(strCon,dbUser,dbPass);
        } catch (Exception e) {
            myLog.message(e.toString(), 0, "ConectToMysql()" , "myConnection");
        }
        return con;
    }
}
