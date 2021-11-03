/*
 * @author Adam Gembala
 * @version 1.0.0
 */
package gembala.adam.cesar.controller;

import gembala.adam.cesar.model.CaesarCipherModel;
import gembala.adam.cesar.view.CaesarCipherTextInputView;
import gembala.adam.cesar.view.CaesarCipherResultView;
import gembala.adam.cesar.view.CaesarCipherShiftInputView;
import gembala.adam.cesar.view.ICaesarCipherView;
import java.util.Scanner;

/**
 * Controller of an Caesar cipher application
 * @author Adam Gembala
 * @version 1.0.0
 */
public class CaesarCipherController {
    
    /**
     * Model of the caesar cipher
     */
    private final CaesarCipherModel model;
    
    
    /**
     * View of the caesar cipher
     */
    private ICaesarCipherView view;
    
    /**
     * Default constructor of a controller
     */
    public CaesarCipherController() {
        model = new CaesarCipherModel();
        view = new CaesarCipherResultView();
    }
    
    /**
     * Method attempts to read command line arguments
     * @param arg Array of arguments
     * @return True if command line arguments are valid
     */
    private boolean tryReadCommandLineArgs(String arg[]) {
        
        if(arg.length < 2)
            return false;
        
        return model.setState(arg[1], Integer.parseInt(arg[0]));
    }
    
    /**
     * Method executes controller
     * @param args Arguments passed by user
     */
    public void execute(String args[]) {
        
        // We attempt to read command line arguments
        if(!tryReadCommandLineArgs(args))
        {
            Scanner scanner = new Scanner(System.in);
        
            // If we couldn't parse command line arguments
            view = new CaesarCipherTextInputView();
            
            String sText = "";
            int iShift = 0;
            
            // Until user provide valid text
            do
            {
                view.render(model);
                
                sText = scanner.nextLine();
                
            } while(!model.setState(sText, iShift));
            
            view = new CaesarCipherShiftInputView();
            
            // Unitl user provide valid shift
            for(boolean bIsOk = false; !bIsOk; bIsOk = model.setState(sText, iShift))
            {
                try {
                    
                    view.render(model);
                    iShift = Integer.parseInt(scanner.next());
                }
                catch(NumberFormatException e)
                { }
            }
        }
        
        // Display results
        view = new CaesarCipherResultView();
        view.render(model);
    }
}
