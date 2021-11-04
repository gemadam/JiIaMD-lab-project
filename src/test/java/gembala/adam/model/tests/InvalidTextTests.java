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
 * Tests that examine behavior of model when invalid input was provided
 * @author Adam
 * @version 1.0.0
 */
public class InvalidTextTests {
    
    /**
     * Checks if model validates the input
     * @param sPublicText Text to be set
     * @param bExpectedResult Expected result of setState execution
     */
    @ParameterizedTest
    @CsvSource({
        "'ABCDEFGHIJKLMNOPRSTQUVWXZ...', false",
        "'ABCDEFGHIJKLMNOPRSTQUVWXZ', true",
        "abcdefghijklmnoprstquvwxz1, false",
        "abcdefghijklmnoprstquvwxz, true",
        "Completely valid inputź, false",
        "Completely valid input, true"
    })
    @DisplayName("State setter should validate input")
    public void shouldValidateText(String sPublicText, boolean bExpectedResult) {
        
        // Prepare
        var myModel = new CaesarCipherModel();
        
        // Act
        var bResult = myModel.setState(sPublicText, 0);
        
        // Assert
        assertEquals(bResult, bExpectedResult);
    }
}
