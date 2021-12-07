/*
 * @author Adam Gembala
 * @version 1.0.0
 */
package gembala.adam.cesar.model;

import gembala.adam.cesar.validation.EnglishAlphabetValidatorRule;
import gembala.adam.cesar.validation.NotEmptyStringValidatorRule;
import gembala.adam.cesar.validation.Validator;
import gembala.adam.cesar.validation.ValidatorException;

/**
 * Class of cipher model contains the data neccessary to 
 * encrypt text using caesar cipher
 * @author Adam Gembala
 * @version 1.0.0
 */
final public class CaesarCipherModel {
    
    
    /**
     * Validator of the model, stores a generic collection of validation rules
     */
    private final Validator myValidator;
    
    
    /**
    * Caesar cipher object
    */
    private final CaesarCipher cipher;
    
    public CaesarCipherModel() {
        cipher = new CaesarCipher();
        myValidator = new Validator(new NotEmptyStringValidatorRule(), new EnglishAlphabetValidatorRule());
    }
    
    
    /**
    * Text to be encrypted
    */
    private String sTextBeforeShifting;
    
    
    /**
    * Encrypted text
    */
    private String sTextAfterShifting;
    
    
    /**
    * Encryption key
    */
    private int iShift;
    
    
    /**
     * Method changes the state of a model
     * @param sTextBeforeShifting New value of text before shifting
     * @param iShift New value of shift
     * @return True if model state is valid and was changed, false otherwise
     */
    public boolean setState(String sTextBeforeShifting, int iShift) {
        
        try {
            myValidator.validate(sTextBeforeShifting);
        }
        catch(ValidatorException e)
        {
            return false;
        }
        
        this.sTextBeforeShifting = sTextBeforeShifting;
        this.iShift = iShift;
        
        this.sTextAfterShifting = this.cipher.encode(this.sTextBeforeShifting, this.iShift);
        
        return true;
    }
    
    /**
     * Getter of the text before shifting
     * @return Text before shifting
     */
    public String getTextBeforeShifting() {
        return sTextBeforeShifting;
    }
    
    /**
     * Sets the value of a text before shifting
     * @param sNewValue New value to be assigned
     * @throws ValidatorException Exception thrown when new state would be invalid
     */
    public void setTextBeforeShifting(String sNewValue) throws ValidatorException {
        
        myValidator.validate(sNewValue);
        
        sTextBeforeShifting = sNewValue;
        
        sTextAfterShifting = this.cipher.encode(this.sTextBeforeShifting, this.iShift);
    }
   
    /**
     * Getter of the text after shifting
     * @return Text after shifting
     */
    public String getTextAfterShifting() {
        return sTextAfterShifting;
    }
    
    /**
     * Getter of the text after shifting
     * @return Current value of shift
     */
    public int getShift() {
        return iShift;
    }
    
    /**
     * Sets the value of a shift
     * @param iNewValue New value to be assigned
     */
    public void setShift(int iNewValue) {
        iShift = iNewValue;
        
        sTextAfterShifting = this.cipher.encode(this.sTextBeforeShifting, this.iShift);
    }
}
