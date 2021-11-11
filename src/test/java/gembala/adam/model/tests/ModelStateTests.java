package gembala.adam.model.tests;

import gembala.adam.cesar.model.CaesarCipherModel;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Tests if model state operations work
 * @author Adam Gembala
 * @version 1.0.0
 */
public class ModelStateTests {
    
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
