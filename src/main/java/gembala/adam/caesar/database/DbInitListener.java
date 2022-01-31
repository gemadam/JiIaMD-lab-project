/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gembala.adam.caesar.database;

import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Database listener.
 * @author Adam Gembala
 * @version 1.0.0
 */
@WebListener
public class DbInitListener implements ServletContextListener {

    /**
     * Method called when context is initialized
     * @param sce Servlet context event
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        try {
            // loading the JDBC driver
           Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException cnfe) {
            System.err.println(cnfe.getMessage());
            return;
        }
        
        var myManager = Persistence.createEntityManagerFactory("CaesarCipherWeb").createEntityManager();
        
        sce.getServletContext().setAttribute("entityManager", myManager);
    }
    
    /**
     * Method called when context is destroyed
     * @param sce Servlet context event
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
