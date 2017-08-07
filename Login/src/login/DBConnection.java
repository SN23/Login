/*
@Author Sukhjinder 
 */
package login;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    
    private static Connection conn=null;
    private static final String DBSTRING = "jdbc:mysql://localhost:3306/credentials";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    
  public static void init() throws ClassNotFoundException{  
        Class.forName("com.mysql.jdbc.Driver");   
    }
    
    /**
        * Creates connection to database
        * @return connection connected
        * @throws SQLException connection is not established
        */
      
    public static Connection getMyConnection() throws SQLException{
        if (conn == null)
          conn=DriverManager.getConnection(DBSTRING,USERNAME, PASSWORD);  
        return conn;
    }
    
    public static void close()
    {
        if (conn != null)
            try {
                conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}