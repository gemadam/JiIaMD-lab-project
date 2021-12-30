/*
 * @author Adam Gembala
 * @version 1.0.0
 */
package gembala.adam.caesar.view;

import gembala.adam.caesar.model.CaesarCipherModel;

/**
 * Interface of an application view
 * @author Adam Gembala
 * @version 1.0.0
 */
public interface ICaesarCipherView {
    
    /**
     * Method renders view
     * @param model Model to be rendered
     */
    void render(CaesarCipherModel model);
}
