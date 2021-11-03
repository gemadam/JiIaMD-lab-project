/*
 * @author Adam Gembala
 * @version 1.0.0
 */
package gembala.adam.cesar.view;

import gembala.adam.cesar.model.CaesarCipherModel;

/**
 * View that asks user for shift input
 * @author Adam Gembala
 * @version 1.0.0
 */
public class CaesarCipherShiftInputView implements ICaesarCipherView {
    
    /**
     * Renders shift input view
     * @param model Model to be rendered
     */
    @Override
    public void render(CaesarCipherModel model) {
        
        System.out.println("Please enter the shift: ");
        
    }
}
