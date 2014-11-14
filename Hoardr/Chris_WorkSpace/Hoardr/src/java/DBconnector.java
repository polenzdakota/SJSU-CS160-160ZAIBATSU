/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author chris
 */
import java.sql.*;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.io.Serializable;
public class DBconnector implements Serializable{
    Statement statement;
    Connection conn;
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/mydb"; //this can be any database

   static final String USER = "root";
   static final String PASS = "hachiman24";
   
   public DBconnector(){
            PrintWriter out = null;
            conn = null;
            ResultSet rs;
         try{
        
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        System.out.println("Database connected");
        //rs = statement.executeQuery("Select card_id,card_name from Cards where card_id=0");
         }
        catch(ClassNotFoundException e){
            out.println("Driver error");
        }catch(SQLException e){
            out.println("SQL error" + e.getMessage());   
        }
         out.close();
   }
   
}
