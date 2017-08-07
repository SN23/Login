package login;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Sukhjinder
 */

public class DBAccess {
    
    private static Connection conn;
    private static final String QUOTE = "\"";  
    

    /**
       * Inserts a User into the database
       * @param username
       * @param password
       * @return inserts user into database (returns true)
       */
      public static Boolean addUser(String username, String password)
      {
          int result;
          String valueString = QUOTE + username + QUOTE + "," 
            + QUOTE + password + QUOTE + ",";
            
          String query=("insert into credentials (USERNAME, PASSWORD) values (" + valueString + ")");
          System.out.println("addUser query is " + query);
                  
          try{
                conn = DBConnection.getMyConnection();
                Statement stmt = conn.createStatement();
                result = stmt.executeUpdate(query);
          }
          
          catch (SQLException sql){ 
                return false;
          }
          
        return result != 0;
      }
      
      
      /**
        * Deletes the selected user
        * If no user is deleted will return false
        * If SQLException occurs, exception is logged (returns false)
        * @param username
        * @return 
        */
        public static Boolean deleteUser(String username)
         {

          int result;
          
          String query = "delete from credentials where username= "+QUOTE+username+QUOTE;
          System.out.println("delete from car query= " + query);
          try{
          conn = DBConnection.getMyConnection();
          Statement stmt = conn.createStatement();
          result = stmt.executeUpdate(query);
          }
          catch (SQLException sql){
              return false;
          }
              

        return result != 0;
      }
        
     
        
      /**
        * Updates the users credentials
        * If no user is found will return false
        * If SQLException occurs, exception is logged (returns false)
        * @param username
        * @param newUsername
        * @param password
        * @return 
        */
        public static Boolean updateCar(String username, String newUsername, String password)
        {

          int result;
          
          String query = ("UPDATE credentials "
                  + "SET USERNAME =" + QUOTE + newUsername + QUOTE + ", PASSWORD =" + QUOTE + password  
                  + "WHERE USERNAME =" + QUOTE + username + QUOTE );
          System.out.println("update car query= " + query);
          try{
          conn = DBConnection.getMyConnection();
          Statement stmt = conn.createStatement();
          result = stmt.executeUpdate(query);
          }
          catch (SQLException sql){
              return false;
          }
              
         
        return result != 0;
      }  
        
        
        
        
}