/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package gembala.adam.model.tests;

import gembala.adam.cesar.model.CaesarCipherModel;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Tests if model state operations work
 * @author Adam
 * @version 1.0.0
 */
public class ModelStateTests {
    
    /**
     * Checks whether getter of public text works
     * @param sPublicText Public text to be tested
     */
    @ParameterizedTest
    @CsvSource({
        "ABCDEFGHIJKLMNOPRSTQUVWXZ",
        "abcdefghijklmnoprstquvwxz",
        "Completely valid input"
    })
    @DisplayName("Getter should return public text")
    public void shouldReturnPublicText(String sPublicText) {
        
        // Prepare
        var myModel = new CaesarCipherModel();
        
        // Act
        myModel.setState(sPublicText, 0);
        
        // Assert
        assertEquals(myModel.getTextBeforeShifting(), sPublicText);
    }
    
    
    /**
     * Checks whether getter of shift works
     * @param iShift Shift to be checked
     */
    @ParameterizedTest
    @CsvSource({
        "-10000",
        "0",
        "199992"
    })
    @DisplayName("Getter should return shift")
    public void shouldReturnShift(int iShift) {
        
        // Prepare
        var myModel = new CaesarCipherModel();
        
        // Act
        myModel.setState("A valid text", iShift);
        
        // Assert
        assertEquals(myModel.getShift(), iShift);
    }
    
    
    /**
     * Checks if setter of public text works
     * @param sPublicText Public text to be tested
     */
    @ParameterizedTest
    @CsvSource({
        "ABCDEFGHIJKLMNOPRSTQUVWXZ",
        "abcdefghijklmnoprstquvwxz",
        "Completely valid input"
    })
    @DisplayName("Setter should set public text")
    public void shouldSetPublicText(String sPublicText) {
        
        // Prepare
        var myModel = new CaesarCipherModel();
        myModel.setState("Some dummy text", 0);
        
        // Act
        myModel.setTextBeforeShifting(sPublicText);
        
        // Assert
        assertEquals(myModel.getTextBeforeShifting(), sPublicText);
    }
    
    
    /**
     * Checks whether setter of shift works
     * @param iShift Shift to be set
     */
    @ParameterizedTest
    @CsvSource({
        "-10000",
        "0",
        "199992"
    })
    @DisplayName("Setter should set shift")
    public void shouldSetShift(int iShift) {
        
        // Prepare
        var myModel = new CaesarCipherModel();
        myModel.setState("A valid text", iShift - 3);
        
        // Act
        myModel.setShift(iShift);
        
        // Assert
        assertEquals(myModel.getShift(), iShift);
    }
    
    
    /**
     * Checks whether setter of state works properly
     * @param sPublicText Public text to be set
     * @param iShift Shift to be set
     */
    @ParameterizedTest
    @CsvSource({
        "ABCDEFGHIJKLMNOPRSTQUVWXZ, 1",
        "abcdefghijklmnoprstquvwxz, 1",
        "Completely valid input, 0",
        "Completely valid input, -1",
        "Completely valid input, -10202022",
        "Completely valid input, 895598374"
    })
    @DisplayName("Should change the state when valid parameters were supplied")
    public void shouldChangeTheState(String sPublicText, int iShift) {
        
        // Prepare
        var myModel = new CaesarCipherModel();
        
        // Act
        myModel.setState(sPublicText, iShift);
        
        // Assert
        assertAll("PublicText Shift",
            () -> assertEquals(myModel.getTextBeforeShifting(), sPublicText),
            () -> assertEquals(myModel.getShift(), iShift)
        );
    }
}
