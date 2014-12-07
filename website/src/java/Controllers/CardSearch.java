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
 * This class searches for a card and returns an array of all cards that
 * are similar in name to the searched name
 * @author 160 Zaibatsu
 */
public class CardSearch extends HttpServlet {

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
        String url = request.getContextPath();
        String card = request.getParameter("card_name");
        Queries searchField = new Queries();
        ResultSet results = searchField.searchREGEXP(card);
        ArrayList<Card> cardSet = searchField.setCards(results);

        if (!card.isEmpty()) {
            request.setAttribute("set", cardSet);
            searchField.closeData();
            request.getRequestDispatcher("/searchResults.jsp").forward(request, response);
        } else {
            url = url + "/HomePage.jsp";
            searchField.closeData();
            response.sendRedirect(url);
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
        try{
        processRequest(request, response);
        }
        catch(SQLException e){
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
         try{
        processRequest(request, response);
        }
        catch(SQLException e){
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
