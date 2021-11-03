/*
 * @author Adam Gembala
 * @version 1.0.0
 */
package gembala.adam.cesar.validation;

/**
 * Interface of a user input validator   
 * @author Adam Gembala
 * @version 1.0.0
 */
public interface IValidatorRule {
    
    /**
     * Method validates provided input
     * @param sUserInput Input to be validated
     * @return Result of the validation, true - if string is valid
     */
    boolean isValid(String sUserInput);
    
    /**
     * Validator message getter
     * @return Error message of the validator
     */
    String getErrorMessage();
    
}
