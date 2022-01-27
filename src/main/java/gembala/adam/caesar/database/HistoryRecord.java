/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gembala.adam.caesar.database;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity of history record
 * @author Adam Gembala
 */
@Entity
public class HistoryRecord implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoryRecord)) {
            return false;
        }
        HistoryRecord other = (HistoryRecord) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gembala.adam.caesar.database.entities.HistoryRecord[ id=" + id + " ]";
    }

}
