package gembala.adam.caesar.view;

import gembala.adam.caesar.model.CaesarCipherModel;

/**
 * View that asks user for text input
 * @author Adam Gembala
 * @version 1.0.0
 */
public class CaesarCipherTextInputView implements ICaesarCipherView {
    
    /**
     * Renders text input view
     * @param model Model to be rendered
     */
    @Override
    public void render(CaesarCipherModel model) {
        
        System.out.println("Please enter the text: ");
        
    }
    
}
