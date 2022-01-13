package gembala.adam.caesar.servlets;

import gembala.adam.caesar.model.HistoryRecord;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet that handles user statistics
 * @author Adam Gembala
 * @version 1.0.0
 */
@WebServlet(name = "UserStatistics", urlPatterns = {"/UserStatistics"})
public class UserSessionServlet extends HttpServlet {
    
    
    /**
     * Method searches for cookie value
     * @param cookies Array of all cookies
     * @param cookieName Name of the cookie
     * @return Cookie value of null if not found
     */
    private String getCookie(Cookie[] cookies, String cookieName) {
        String val = null;
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    val = cookie.getValue();
                break;
                }
            }
        }
        
        return val;
    }
   
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
            throws ServletException, IOException
    {    
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write("{");
        
        var session = request.getSession();
        
        String sessionID = session.getId();
        out.write("\"sessionID\": \"" + sessionID + "\",");
        
        var lastVisit = session.getAttribute("LastVisit");
        if(lastVisit != null)
            out.write("\"lastVisit\": \"" + lastVisit.toString() + "\",");
        else
            out.write("\"lastVisit\": \"Never\",");
        
        var numOfBadRequests = getCookie(request.getCookies(), "numOfBadRequests");
        if(numOfBadRequests == null)
            out.write("\"numOfBadRequests\": 0,");
        else 
            out.write("\"numOfBadRequests\": " + numOfBadRequests + ",");
            
        
        var numOfErrors = getCookie(request.getCookies(), "numOfErrors");
        if(numOfErrors == null)
            out.write("\"numOfErrors\": 0,");
        else 
            out.write("\"numOfErrors\": " + numOfErrors + ",");
        
        var history = session.getAttribute("history");
        if(history != null)
        {
            var lstHistory = (ArrayList<HistoryRecord>)history;
            
            out.write("\"history\": [");
            
            for(var i = 0; i < lstHistory.size(); i++)
            {
                var h = lstHistory.get(i);
                
                out.write("{");
                out.write("\"publicText\": \"" + h.getPublicText() + "\",");
                out.write("\"privateText\": \"" + h.getPrivateText() + "\",");
                out.write("\"encryptionKey\": " + h.getEncryptionKey() + ",");
                out.write("\"decryptionKey\": " + h.getDecryptionKey());
                
                if(i < lstHistory.size() - 1)
                    out.write("},");
                else
                    out.write("}");
            }
            
            
            out.write("]");
        }
        else
            out.write("\"history\": []");
            
        out.write("}");
        
        session.setAttribute("LastVisit", LocalDateTime.now());
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
            throws ServletException, IOException 
    {        
        var session = request.getSession();
        
        session.setAttribute("LastVisit", LocalDateTime.now());
    }
}
