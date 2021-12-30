/*
 * @author Adam Gembala
 * @version 1.0.0
 */
package gembala.adam.caesar.validation;

import java.util.ArrayList;
import java.util.List;

/**
 * Class of a validator
 * @author Adam Gembala
 * @version 1.0.0
 */
public class Validator {
    
    
    /**
     * Collection of validator rules
     */
    private final List<IValidatorRule> lstValidators;
    
    /**
     * Default constructor
     */
    public Validator() {
        this.lstValidators = new ArrayList<IValidatorRule>();
    }
    
    /**
     * Constructor that initializes validator rules
     * @param validators List of validators
     */
    public Validator(IValidatorRule ...validators) {
        this.lstValidators = new ArrayList<IValidatorRule>();
        
        for(var v: validators)
            this.addValidatorRule(v);
    }
    
    /**
     * Method adds a validation rule
     * @param rule Validation rule to be added
     */
    public void addValidatorRule(IValidatorRule rule) {
        lstValidators.add(rule);
    }
    
    /**
     * Method validates an input according to validation rules
     * @param sUserInput Input to be validated
     * @return Validation result
     * @throws ValidatorException When input is invalid
     */
    public boolean validate(String sUserInput) throws ValidatorException {
           
        for(var validator: this.lstValidators)
            if(!validator.isValid(sUserInput))
                throw new ValidatorException(validator.getErrorMessage());
        
        return true;
    }
    
}
