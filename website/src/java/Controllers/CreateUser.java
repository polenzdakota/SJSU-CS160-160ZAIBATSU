/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Card;
import Models.Queries;
import Models.Users;
import java.io.IOException;
import java.io.PrintWriter;
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
 *
 * @author cody
 */
public class CreateUser extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        Queries dbAccessor = new Queries();
        HttpSession session = request.getSession();
        String user = (String) request.getAttribute("user");
        String pass = (String) request.getAttribute("pass");
        boolean canCreate = checkAndCreate(user, pass);
        if (canCreate) {
            ResultSet set = dbAccessor.collectionJoin(user);
            ArrayList<Card> cardSet = dbAccessor.setCards(set);
            session.setAttribute("currentUser", user);
            session.setAttribute("userCards", cardSet);
            String url = request.getContextPath() + "/UserPage.jsp";
            dbAccessor.closeData();
            response.sendRedirect(url);
        } else {
            session.setAttribute("invalidFields", "User Already Exists");
            String url = request.getContextPath() + "/HomePage.jsp";
            response.sendRedirect(url);
        }

    }

    protected boolean checkAndCreate(String username, String pass) throws SQLException {

        if (dbAccessor.userExists(username)) {
            Users user = new Users(username);
            user.setUserPassword(pass);
            dbAccessor.createUser(user);
            return true;
        } else {
            return false;
        }
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
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
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
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
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
