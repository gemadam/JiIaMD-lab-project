package gembala.adam.cesar.validation;

/*
 * @author Adam Gembala
 * @version 1.0.0
 */

/**
 * Validator that checks if input contains characters from english alphabet
 * @author Adam Gembala
 * @version 1.0.0
 */
public class EnglishAlphabetValidatorRule implements IValidatorRule {
    
    /**
     * Method checks if input contains english alphabet letters
     * @param sUserInput Input to be checked
     * @return Validation result
     */
    @Override
    public boolean isValid(String sUserInput) {
        return sUserInput.matches("[A-Za-z\\s_]+");
    }
    
    /**
     * Error message getter
     * @return Error message
     */
    @Override
    public String getErrorMessage() {
        return "Text can only contain small and capital letters, space or '_'";
    }
    
}
