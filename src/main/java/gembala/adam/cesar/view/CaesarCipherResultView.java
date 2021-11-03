/*
 * @author Adam Gembala
 * @version 1.0.0
 */
package gembala.adam.cesar.view;

import gembala.adam.cesar.model.CaesarCipherModel;

/**
 * Class that displays results to the user
 * @author Adam Gembala
 * @version 1.0.0
 */
public class CaesarCipherResultView implements ICaesarCipherView {
    
    /**
     * Method renders view
     * @param model Model to be rendered
     */
    @Override
    public void render(CaesarCipherModel model) {
        
        String sMessage = "";
        
        sMessage += "Your public text: " + model.getTextBeforeShifting() + '\n';
        sMessage += "Your encryption key: " + model.getShift() + '\n';
        sMessage += "Your private text: " + model.getTextAfterShifting() + "\n\n";
        sMessage += "To decrypt the message please use " + String.valueOf(-model.getShift()) + " as a key";
        
        System.out.println(sMessage);
    }
    
}
