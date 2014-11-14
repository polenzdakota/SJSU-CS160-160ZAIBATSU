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

/**
 *
 * @author cody
 */
public class getCardAttributes extends HttpServlet {

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
        String card = request.getParameter("card");
        request.setAttribute("card_name", card);
        request.setAttribute("card_id", getCardID());
        request.setAttribute("color", getColor());
        request.setAttribute("cost", getCost());
        request.setAttribute("super_type", getSuperTypes());
        request.setAttribute("types", getTypes());
        request.setAttribute("subTypes", getSubTypes());
        request.setAttribute("text", getText());
        request.setAttribute("power", getPower());
        request.setAttribute("toughness", getToughness());
        request.setAttribute("image", getImageURL());
        request.setAttribute("cmc", getCMC());
        request.getRequestDispatcher("/singleCardPage.jsp").forward(request, response);
    }

    public String getCardID() {
        return "00001";
    }

    public String getColor() {
        return "White";
    }

    public String getCMC() {
        return "4";
    }

    public String getCost() {
        return "3W";
    }

    public String getSuperTypes() {
        return "Planeswalker";
    }

    public String getTypes() {
        return "";
    }

    public String getSubTypes() {
        return "Ajani";
    }

    public String getText() {
        return "FUCK";
    }

    public String getPower() {
        return "4";
    }

    public String getToughness() {
        return "0";
    }

    public String getImageURL() {
        return "Images/CardPictures/AjaniSteadfast.jpg";
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
