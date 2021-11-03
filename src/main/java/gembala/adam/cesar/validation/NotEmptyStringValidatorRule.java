/*
 * @author Adam Gembala
 * @version 1.0.0
 */
package gembala.adam.cesar.validation;

/**
 * Validator of empty string
 * @author Adam Gembala
 * @version 1.0.0
 */
public class NotEmptyStringValidatorRule implements IValidatorRule {
    
    /**
     * Method checks if input contains at least one character
     * @param sUserInput Input to be tested
     * @return Validation result
     */
    @Override
    public boolean isValid(String sUserInput) {
        return !sUserInput.isEmpty();
    }
    
    /**
     * Error message getter
     * @return Error message
     */
    @Override
    public String getErrorMessage() {
        return "Text can not be empty";
    }
}
