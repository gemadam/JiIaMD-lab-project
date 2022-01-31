package gembala.adam.caesar.servlets;

import gembala.adam.caesar.controller.CaesarCipherController;
import gembala.adam.caesar.model.HistoryRecord;
import gembala.adam.caesar.repository.HistoryRepository;
import gembala.adam.caesar.validation.ValidatorException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet provides access to application model
 * @author Adam Gembala
 * @version 1.0.0
 */
@WebServlet(name = "CaesarCipherServlet", urlPatterns = {"/CaesarCipher"})
public class CaesarCipherServlet extends HttpServlet {
    
    /**
     * Controller of the servlet
     */
    CaesarCipherController controller;
    
    /**
     * DAL for history records
     */
    private HistoryRepository historyRepo;

    /**
     * Initializer of the servlet
     * @exception ServletException On initialization error
     */  
    @Override
    public void init() throws ServletException {
        historyRepo = new HistoryRepository((EntityManager) getServletContext().getAttribute("entityManager"));
    }
    
    
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
     * Default constructor of the servlet.
     */
    public CaesarCipherServlet() {
        controller = new CaesarCipherController();
    }
    
    /**
     * Handles the HTTP <code>GET</code> method.
     * Redirects to /UserStatistics
     *
     * @param request Income request
     * @param response Outcome response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        response.sendRedirect("/JiIaMD-lab-project/UserStatistics");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request Income request
     * @param response Outcome response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        var numOfBadRequests = getCookie(request.getCookies(), "numOfBadRequests");
        if(numOfBadRequests == null)
            response.addCookie(new Cookie("numOfBadRequests", "0"));
        
        var numOfErrors = getCookie(request.getCookies(), "numOfErrors");
        if(numOfErrors == null)
            response.addCookie(new Cookie("numOfErrors", "0"));
        
        
        response.setContentType("text/plain; charset=ISO-8859-2");
        PrintWriter out = response.getWriter();
        
        String sPublicText = null, sShift = null;
        
        Enumeration enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String name = (String) enumeration.nextElement();
            
            if(name.equalsIgnoreCase("publicTextInput"))
                sPublicText = request.getParameter(name);
            else if(name.equalsIgnoreCase("shiftInput"))
                sShift = request.getParameter(name);
        }
        
        if(sPublicText == null)
        {
            response.sendError(response.SC_BAD_REQUEST, "ERROR: Please provide text to encrypt as value of 'publicTextInput' parameter. ");
            
            try {
                int errors = Integer.parseInt(numOfBadRequests);
                
                response.addCookie(new Cookie("numOfBadRequests", String.valueOf(errors + 1)));
            }
            catch(NumberFormatException e)
            {
                response.addCookie(new Cookie("numOfBadRequests", "1"));
            }
            return;
        }
        else if(sShift == null)
        {
            response.sendError(response.SC_BAD_REQUEST, "ERROR: Please provide encryption key as value of 'shiftInput' parameter. ");
            
            try {
                int errors = Integer.parseInt(numOfBadRequests);
                
                response.addCookie(new Cookie("numOfBadRequests", String.valueOf(errors + 1)));
            }
            catch(NumberFormatException e)
            {
                response.addCookie(new Cookie("numOfBadRequests", "1"));
            }
            return;
        }
        
        try {
            var iShift = Integer.parseInt(sShift);
            
            var sEncryptedText = controller.encrypt(sPublicText, iShift);
                    
            out.println(sEncryptedText);
            
            historyRepo.Create(request.getSession().getId(), sPublicText, sEncryptedText, iShift, -iShift);
        }
        catch(ValidatorException ex)
        {
            out.println("ERROR: Validation error. " + ex.getMessage());
            
            try {
                int errors = Integer.parseInt(numOfErrors);
                
                response.addCookie(new Cookie("numOfErrors", String.valueOf(errors + 1)));
            }
            catch(NumberFormatException e)
            {
                response.addCookie(new Cookie("numOfErrors", "1"));
            }
        }
        catch(NumberFormatException ex)
        {
            out.println("ERROR: Number format error. Shift has to be a integer number!");
            
            try {
                var errors = Integer.parseInt(numOfErrors);
                
                response.addCookie(new Cookie("numOfErrors", String.valueOf(errors + 1)));
            }
            catch(NumberFormatException e)
            {
                response.addCookie(new Cookie("numOfErrors", "1"));
            }
        }
        
        request.getRequestDispatcher("UserStatistics").include(request,response);
    }
}
