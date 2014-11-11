
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
 
public class Servlet1 extends HttpServlet {
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/mydb"; //this can be any database

   static final String USER = "root";
   static final String PASS = "password";
   
   @Override
   public void doGet(HttpServletRequest inRequest, HttpServletResponse outResponse)
            throws ServletException, 
            IOException{
            
            PrintWriter out = null;
            Connection connection = null;
            Statement statement;
            ResultSet rs;
            
    try{
        
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DB_URL,USER,PASS);
        statement = connection.createStatement();
        outResponse.setContentType("test/html");
        out = outResponse.getWriter();
        rs = statement.executeQuery("Select card_id from Cards");
        out.println("<HTML><HEAD><TITLE>CARDS-ID</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<UL>");
        
        while(rs.next()){
            out.println("<LI>" + rs.getInt("Card_id") +"<LI>");
        }
        out.println("</UL>");
        out.println("</HTML>");
    }
    catch(ClassNotFoundException e){
        out.println("Driver error");
    }catch(SQLException e){
     out.println("SQL error" + e.getMessage());   
    }
        }
   @Override
    public void doPost(HttpServletRequest inRequest, HttpServletResponse outResponse) 
            throws ServletException, IOException{
        doGet(inRequest, outResponse);
    }
    
}