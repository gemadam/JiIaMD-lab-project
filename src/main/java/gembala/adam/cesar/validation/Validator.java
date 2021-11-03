/*
 * @author Adam Gembala
 * @version 1.0.0
 */
package gembala.adam.cesar.validation;

import java.util.Vector;

/**
 * Class of a validator
 * @author Adam Gembala
 */
public class Validator {
    
    
    /**
     * Vector of validator rules
     */
    private final Vector<IValidatorRule> vValidators;
    
    /**
     * Default constructor
     */
    public Validator() {
        this.vValidators = new Vector<IValidatorRule>();
    }
    
    /**
     * Constructor that initializes validator rules
     * @param validators List of validators
     */
    public Validator(IValidatorRule ...validators) {
        this.vValidators = new Vector<IValidatorRule>();
        
        for (int i = 0; i < validators.length; i++)
            this.addValidatorRule(validators[i]);
    }
    
    /**
     * Method adds a validation rule
     * @param rule Validation rule to be added
     */
    public void addValidatorRule(IValidatorRule rule) {
        vValidators.add(rule);
    }
    
    /**
     * Method validates an input according to validation rules
     * @param sUserInput Input to be validated
     * @return Validation result
     * @throws ValidatorException When input is invalid
     */
    public boolean validate(String sUserInput) throws ValidatorException {
        
        for(var i = 0; i < vValidators.size(); i++) {
            var validator = vValidators.get(i);
            
            if(!validator.isValid(sUserInput))
                throw new ValidatorException(validator.getErrorMessage());
        }
        
        return true;
    }
    
}
