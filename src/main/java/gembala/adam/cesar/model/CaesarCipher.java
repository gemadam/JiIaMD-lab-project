/*
 * @author Adam Gembala
 * @version 1.0.0
 */
package gembala.adam.cesar.model;

/**
 * Caesar cipher class 
 * @author Adam Gembala
 * @version 1.0.0
 */
public class CaesarCipher {
    
    /**
     * Method shifts text over provided alphabet. If character is not
     * present in alphabet, method skips it.
     * @param sText Text to be shifted
     * @param iShift Number by which characters will be shifted
     * @param sAlphabet Alphabet over which text will be shifted
     * @return Shifted text
     */
    private String shiftText(String sText, int iShift, String sAlphabet) {
        
        // If shift is negative, prepare the shift for decryption
        if(iShift < 0)
            iShift = (26 - (Math.abs(iShift) % 26));
        
        var arrCharacters = sText.toCharArray();
        for(var i = 0; i < arrCharacters.length; i++) {
            
            var iAlphabetPosition = sAlphabet.indexOf(arrCharacters[i]);
            
            if(iAlphabetPosition < 0)
                continue;
            
            var iNewAlphabetPosition = (iAlphabetPosition + iShift) % sAlphabet.length();
            
            arrCharacters[i] = sAlphabet.charAt(iNewAlphabetPosition);
        }
        return String.valueOf(arrCharacters);
    }
    
    /**
     * Method encodes text using caesar cipher
     * @param sPublicText Text to be encoded
     * @param iShift Shift of the text
     * @return Encrypted text
     */
    public String encode(String sPublicText, int iShift) {
        
        String sPrivateText = sPublicText;
        
        sPrivateText = shiftText(sPrivateText, iShift, "abcdefghijklmnopqrstuvwxyz");
        sPrivateText = shiftText(sPrivateText, iShift, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        sPrivateText = shiftText(sPrivateText, iShift, " _");
        
        return String.valueOf(sPrivateText);
    }
    
    /**
     * Method for obtaining index of the character to which we map current character
     * @param iIndex Index in the alphabet of the current character
     * @param iShift Shift of the text
     * @param iAlphabetLength Number of characters in alphabet
     * @return New index to which we map current index
     */
    private int getCharIndex(int iIndex, int iShift, int iAlphabetLength) {
        
        // We do nothing
        if(iShift == 0)
            return iIndex;
        
        // While encrypting
        if(iShift > 0)
            return (iIndex + iShift) % iAlphabetLength;
        
        // While decrypting
        return iAlphabetLength - (iShift % iAlphabetLength);
    }
}
