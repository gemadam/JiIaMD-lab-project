package gembala.adam.model.tests;

import gembala.adam.cesar.model.CaesarCipherModel;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Tests of the cipher
 * @author Adam
 * @version 1.0.0
 */
public class CipherTests {
    
    
    /**
     * Test if encryption works correctly
     * @param sPublicText Text to be encrypted
     * @param iShift Shift by which text will be encrypted
     * @param sExpectedResult Result of encryption
     */
    @ParameterizedTest
    @CsvSource({
        "Abc, 1, Bcd",
        "Lorem ipsum dolor sit amet, 76273, Adgtb_xehjb_sdadg_hxi_pbti",
        "The program should perform both encoding and decoding of texts, 928364, Bpm xzwoziu apwctl xmznwzu jwbp mvkwlqvo ivl lmkwlqvo wn bmfba"
    })
    @DisplayName("Simple text encryption should work")
    public void shouldEncryptTheMessage(String sPublicText, int iShift, String sExpectedResult) {
        
        // Prepare
        var myModel = new CaesarCipherModel();
        
        // Act
        myModel.setState(sPublicText, iShift);
        
        // Assert
        assertEquals(myModel.getTextAfterShifting(), sExpectedResult);
    }
    
    
    /**
     * Tests if the decryption works properly
     * @param sPrivateText Text to be decrypted
     * @param iShift Decryption key
     * @param sExpectedResult Result of decryption
     */
    @ParameterizedTest
    @CsvSource({
        "Bcd, -1, Abc",
        "Adgtb_xehjb_sdadg_hxi_pbti, -76273, Lorem ipsum dolor sit amet",
        "Bpm xzwoziu apwctl xmznwzu jwbp mvkwlqvo ivl lmkwlqvo wn bmfba, -928364, The program should perform both encoding and decoding of texts"
    })
    @DisplayName("Simple text decryption should work")
    public void shouldDecryptTheMessage(String sPrivateText, int iShift, String sExpectedResult) {
        
        // Prepare
        var myModel = new CaesarCipherModel();
        
        // Act
        myModel.setState(sPrivateText, iShift);
        
        // Assert
        assertEquals(myModel.getTextAfterShifting(), sExpectedResult);
    }
}
