/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.*;
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
 * This class will update the user's information and collections
 *
 * @author 160 Zaibatsu
 */
public class UpdateUser extends HttpServlet {

    Queries dbAccessor = new Queries();
    HttpSession session;

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
        session = request.getSession();
        String user = (String) session.getAttribute("currentUser");
        String action = (String) request.getParameter("action");
        String cardId = (String) request.getParameter("id");
        String quantity = (String) request.getParameter("quantity");
        int id = Integer.parseInt(cardId);
        int quant = Integer.parseInt(quantity);
        if (action.equals("add-card")) {
					addCardToCollection(id, quant);
					response.sendRedirect("ViewCollection.jsp");
				}
        //dbAccessor.closeData();
    }

    /**
     * Adds a card to the user's collection,
     *
     * @param cardId The id of the card to add
     * @return true if the card is added
     * @throws SQLException
     */
    protected boolean addCardToCollection(int cardId, int quantity) throws SQLException {
        dbAccessor.addCards(cardId, (String) session.getAttribute("user"), quantity);
        CardSet cardSet = dbAccessor.getUserCollection((String) session.getAttribute("user"));
        session.setAttribute("userCards", cardSet);
        return true;
    }

    /**
     * Deletes a card from the user's collection
     *
     * @param name the name of the card
     * @return true if the card was deleted
     */
    protected boolean deleteCardFromCollection(int cardId) throws SQLException {
        String table = (String) session.getAttribute("currentUser");
        dbAccessor.decrementCard(cardId, 1, table);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateUser.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UpdateUser.class.getName()).log(Level.SEVERE, null, ex);
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
