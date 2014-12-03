/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cody
 */
public class UserVerify extends HttpServlet {

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
            throws ServletException, IOException {
        String user = request.getParameter("username").toLowerCase();
        String pass = request.getParameter("password").toLowerCase();
        //Credentials are not case sensitive for now
        HttpSession session = request.getSession();

        if (!checkUserID(user) || !checkPass(user, pass)) {
            session.setAttribute("invalidFields", true);
            String url = request.getContextPath() + "/HomePage.jsp";
            response.sendRedirect(url);
        } else {
            session.setAttribute("currentUser", user);
            String url = request.getContextPath() + "/UserPage.jsp";
            response.sendRedirect(url);
        }
    }

    /**
     * Checks to see if the username matches a user in our database
     *
     * @param user the username provided
     * @return false if the user is not in the database
     */
    protected boolean checkUserID(String user) {
        //TODO EVERYTHINGGGGGGGGGGGGGGG!!!!!!!!!!!!!!!!!!!!
        return true;
    }

    /**
     * Checks to see if the password provided matches the user name in out
     * database
     *
     * @param user the username provided
     * @param pass the password provided
     * @return false if the password does not match the user
     */
    protected boolean checkPass(String user, String pass) {
        //Added this statement for testing. Enetering password as "test"
        //is equivilant to entering an incorrect password.
        if (pass.equals("test")) {
            return false;
        }
        return true;
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
        processRequest(request, response);
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
