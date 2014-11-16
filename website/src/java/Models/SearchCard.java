/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dakota
 */
public class SearchCard extends HttpServlet {
    /**
     * This search the database for one card.
     * @return the card searched for.
     */
    public static Card searchOneCard() {
        //TODO Add actual code.
        return new Card();
    }
}
