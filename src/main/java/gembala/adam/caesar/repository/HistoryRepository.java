/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gembala.adam.caesar.repository;

import gembala.adam.caesar.database.HistoryRecord;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * Repository of history record
 * @author Adam Gembala
 */
public class HistoryRepository {
    
    /**
     * Entity manager
     */
    EntityManager manager;
    
    /**
     * Constructor of the repository
     * @param em Entity manager
     */
    public HistoryRepository(EntityManager em) {
        manager = em;
    }
    
    
    
    /**
     * Method inserts object to the database
     * @param record Object to be added
     */
    public void Create(HistoryRecord record) {
        manager.getTransaction().begin();
        try {
            manager.persist(record);
            manager.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            manager.getTransaction().rollback();
        } finally {
            manager.getTransaction().commit();
        }
    }
    
    
    /**
     * Method inserts object to the database
     * @param sessionId New record session id
     * @param sPublicText New record public text
     * @param sPrivateText New record private text
     * @param iEncyptionKey New record encryption key
     * @param iDecryptionKey  New record decryption key
     */
    public void Create(String sessionId, String sPublicText, String sPrivateText, int iEncyptionKey, int iDecryptionKey) {
        
        var record = new HistoryRecord();
        record.setSessionId(sessionId);
        record.setPublicText(sPublicText);
        record.setPrivateText(sPrivateText);
        record.setEncryptionKey(iEncyptionKey);
        record.setDecryptionKey(iDecryptionKey);
        
        
        manager.getTransaction().begin();
        try {
            manager.persist(record);
            manager.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            manager.getTransaction().rollback();
        }
    }
    
    /**
     * Method gets all history records from the database
     * @return List of history records
     */
    public List<HistoryRecord> Read() {
        manager.getTransaction().begin();
        
        List<HistoryRecord> lstRecords = new ArrayList<HistoryRecord>();
        try {
            Query query = manager.createQuery("SELECT r FROM HISTORYRECROD r");
            lstRecords = query.getResultList();
            manager.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            manager.getTransaction().rollback();
        }
        
        return lstRecords;
    }
    
    /**
     * Method gets all history records from the database
     * @param sessionId Id of the session
     * @return List of history records
     */
    public List<HistoryRecord> Read(String sessionId) {
        manager.getTransaction().begin();
        
        List<HistoryRecord> lstRecords = new ArrayList<HistoryRecord>();
        try {
            Query query = manager.createQuery("SELECT r FROM HistoryRecord r WHERE r.sessionID=:sessionId");
            query.setParameter("sessionId", sessionId);
            
            lstRecords = query.getResultList();
            manager.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            manager.getTransaction().rollback();
        }
        
        return lstRecords;
    }
}
