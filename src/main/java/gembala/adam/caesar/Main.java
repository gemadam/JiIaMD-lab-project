/*
 * @author Adam Gembala
 * @version 1.0.0
 */
package gembala.adam.caesar;

import gembala.adam.cesar.controller.CaesarCipherController;
import gembala.adam.cesar.model.CaesarCipher;

/**
 * Main class of a program
 * @author Adam Gembala
 * @version 1.0.0
 */
public class Main {
    
    /**
     * Main method of a program
     * @param args Parameters passed from command line
     */
    public static void main(String args[]) {
        
        // Initialize and execute controller
        var c = new CaesarCipherController();
        c.execute(args);
    }
}
