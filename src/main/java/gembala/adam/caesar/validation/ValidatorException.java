package gembala.adam.caesar.validation;

/*
 * @author Adam Gembala
 * @version 1.0.0
 */

/**
 * Validator exception, thrown when validation errors occured
 * @author Adam Gembala
 * @version 1.0.0
 */
public class ValidatorException extends Exception {
    
    /**
     * Constructor of the exception
     * @param sMessage Error message
     */
    public ValidatorException(String sMessage) {
         super(sMessage);
    }
}
