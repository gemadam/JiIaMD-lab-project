/*
 * @author Adam Gembala
 * @version 1.0.0
 */
package gembala.adam.caesar.controller;

import gembala.adam.caesar.model.CaesarCipherModel;
import gembala.adam.caesar.validation.ValidatorException;
import gembala.adam.caesar.view.CaesarCipherTextInputView;
import gembala.adam.caesar.view.CaesarCipherResultView;
import gembala.adam.caesar.view.CaesarCipherShiftInputView;
import gembala.adam.caesar.view.ICaesarCipherView;
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
     * Method encrypts text with provided key
     * @param sPublicText Text to encrypt
     * @param iShift Encryption key
     * @return Encrypted text
     * @throws ValidatorException Thrown when some of arguments is incorrect
     */
    public String encrypt(String sPublicText, int iShift) throws ValidatorException {
        model.setTextBeforeShifting(sPublicText);
        model.setShift(iShift);
        
        return model.getTextAfterShifting();
    }
    
    /**
     * Method attempts to read command line arguments
     * @param arg Array of arguments
     * @return True if command line arguments are valid
     */
    private boolean tryReadCommandLineArgs(String arg[]) {
        
        if(arg.length < 2)
            return false;
        
        try {
            return model.setState(arg[1], Integer.parseInt(arg[0]));
        }
        catch(NumberFormatException e) {
            return false;
        }
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
