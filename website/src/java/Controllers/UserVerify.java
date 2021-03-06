package Controllers;

import Models.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This class checks the user provided credentials with our database
 *
 * @author 160 Zaibatsu
 */
public class UserVerify extends HttpServlet {

    Queries dbAccessor = new Queries();

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, NoSuchAlgorithmException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        HttpSession session = request.getSession();
        if (checkUser(user) || !checkPass(user, pass)) {
            session.setAttribute("invalidFields", "Incorrect Username or Password");
            String url = request.getContextPath() + "/HomePage.jsp";
            response.sendRedirect(url);
        } else {
            ResultSet set = dbAccessor.collectionJoin(user);
            CardSet cardSet = dbAccessor.getUserCollection(user);
            session.setAttribute("currentUser", user);
            session.setAttribute("userCards", cardSet);
            String url = request.getContextPath() + "/UserPage.jsp";
            response.sendRedirect(url);
        }
    }
    
    protected boolean checkUser(String name) throws SQLException {
        return dbAccessor.userExists(name);
    }

    /**
     * Checks to see if the password provided matches the user name in out
     * database
     *
     * @param user the username provided
     * @param pass the password provided
     * @return false if the password does not match the user
     */
    protected boolean checkPass(String user, String pass) throws SQLException, NoSuchAlgorithmException {

        if (pass.isEmpty()) {
            return false;
        }
        String hashed = dbAccessor.hashPassword(pass);
        String dbPass = dbAccessor.retrievePassword(user);
        return (hashed.equals(dbPass));
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
                    try {
                        processRequest(request, response);
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(UserVerify.class.getName()).log(Level.SEVERE, null, ex);
                    }
        } catch (SQLException ex) {
            Logger.getLogger(UserVerify.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
                    try {
                        processRequest(request, response);
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(UserVerify.class.getName()).log(Level.SEVERE, null, ex);
                    }
        } catch (SQLException ex) {
            Logger.getLogger(UserVerify.class.getName()).log(Level.SEVERE, null, ex);
        }
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
