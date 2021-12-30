/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package gembala.adam.caesar.servlets;

import gembala.adam.caesar.controller.CaesarCipherController;
import gembala.adam.caesar.model.HistoryRecord;
import gembala.adam.caesar.validation.ValidatorException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adam
 */
@WebServlet(name = "CaesarCipherServlet", urlPatterns = {"/CaesarCipher"})
public class CaesarCipherServlet extends HttpServlet {
    
    CaesarCipherController controller;
    
    /**
     * Default constructor of the servlet.
     */
    public CaesarCipherServlet() {
        controller = new CaesarCipherController();
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
            throws IOException, ServletException {
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
            out.println("ERROR: Please provide text to encrypt as value of 'publicTextInput' parameter. ");
            return;
        }
        else if(sShift == null)
        {
            out.println("ERROR: Please provide encryption key as value of 'shiftInput' parameter. ");
            return;
        }
        
        try {
            var iShift = Integer.parseInt(sShift);
                    
            var sEncryptedText = controller.encrypt(sPublicText, iShift);
                    
            out.println(sEncryptedText);
        }
        catch(ValidatorException ex)
        {
            out.println("ERROR: Validation error. " + ex.getMessage());
        }
        catch(NumberFormatException ex)
        {
            out.println("ERROR: Number format error. Shift has to be a integer number!");
        }
    }
}
