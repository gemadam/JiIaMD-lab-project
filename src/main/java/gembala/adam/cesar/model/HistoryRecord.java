/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gembala.adam.cesar.model;

import java.util.Date;

/**
 * Class stores information about encryption/decryption operation
 * @author Adam Gembala
 * @version 1.0.0
 */
public class HistoryRecord
{    
    /**
     * Text that was encrypted
     */
    String publicText;
    
    /**
     * Text encrypted
     */
    String privateText;
    
    /**
     * Encryption key
     */
    int enKey;
    
    /**
     * Decryption key
     */
    int deKey;
    
    /**
     * Constructor of the history record
     * @param publicText Initial value of public text
     * @param privateText Initial value of private text
     * @param enKey Initial value of encryption key
     * @param deKey Initial value of decryption key
     */
    public HistoryRecord(String publicText, String privateText, int enKey, int deKey)
    {
        this.publicText = publicText;
        this.privateText = privateText;
        this.enKey = enKey;
        this.deKey = deKey;
    }
    
    /**
     * Getter of the public text
     * @return Public text
     */
    public String getPublicText()
    {
        return publicText;
    }
    
    /**
     * Setter of the public text
     * @param val New value
     */
    public void setPublicText(String val)
    {
        publicText = val;
    }
    
    /**
     * Getter of the private text
     * @return Private text
     */
    public String getPrivateText()
    {
        return privateText;
    }
    
    /**
     * Setter of the private text
     * @param val New value
     */
    public void setPrivateText(String val)
    {
        privateText = val;
    }
    
    /**
     * Getter of the encryption key
     * @return Encryption key
     */
    public int getEncryptionKey()
    {
        return enKey;
    }
    
    /**
     * Setter of the encryption key
     * @param val New value
     */
    public void setEncryptionKey(int val)
    {
        enKey = val;
    }
    
    /**
     * Getter of the decryption key
     * @return Decryption key
     */
    public int getDecryptionKey()
    {
        return deKey;
    }
    
    /**
     * Setter of the decryption key
     * @param val New value
     */
    public void setDecryptionKey(int val)
    {
        deKey = val;
    }
}