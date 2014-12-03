package Controllers;

import Models.Card;
import Models.Queries;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class searches for a single card then returns those card attributes
 * to the single card page
 * @author 160 Zaibatsu
 */
public class Linker extends HttpServlet {

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
        String id = request.getParameter("index");
        Queries searchField = new Queries();
        ResultSet results = searchField.oneCard(id);
        ArrayList<Card> singleCard = searchField.setCards(results);
        Card card = singleCard.get(0);

        request.setAttribute("name", card.getName());
        request.setAttribute("toughness", card.getCardtoughness());
        request.setAttribute("cost", card.getCost());
        request.setAttribute("color", card.getColors());
        request.setAttribute("cmc", card.getCmc());
        request.setAttribute("super_type", card.getSupertypes());
        request.setAttribute("types", card.getCardtypes());
        request.setAttribute("subTypes", card.getCardsubtypes());
        request.setAttribute("text", card.getText());
        request.setAttribute("power", card.getCardPower());
        
         request.getRequestDispatcher("/singleCardPage.jsp").forward(request, response);
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
        } catch (SQLException e) {
            System.out.println("SQL error" + e.getMessage());
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
        } catch (SQLException e) {
            System.out.println("SQL error" + e.getMessage());
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
