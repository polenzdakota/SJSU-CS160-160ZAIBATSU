/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 *
 * @author chris
 */
@WebServlet(urlPatterns = {"/DataAccess"},loadOnStartup =1)
public class DataAccess extends HttpServlet {
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/mydb"; //this can be any database

   static final String USER = "root";
   static final String PASS = "hachiman24";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            processRequest(request, response);
            PrintWriter out = null;
            Connection connection = null;
            Statement statement;
            ResultSet rs;
         try{
        
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DB_URL,USER,PASS);
        statement = connection.createStatement();
        response.setContentType("test/html");
        out = response.getWriter();
        rs = statement.executeQuery("Select card_id,card_name from Cards");
        
        out.println("<html><head><tile>CARDS-ID</title></head>");
        out.println("<body>");
        
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>Card-Int</th>");
        out.println("<th>Card_Name</th>");
        out.println("</tr>");
        
        while(rs.next()){
            
            out.println("<tr>"+"<td>" + rs.getInt("Card_id")+"</td>");
            out.println("<td>" +rs.getString("card_name") + "</td>" +"</tr>");
        
        }
        
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
    catch(ClassNotFoundException e){
        out.println("Driver error");
    }catch(SQLException e){
     out.println("SQL error" + e.getMessage());   
    }
         out.close();
         String url = "viewer.jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        }
 

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
