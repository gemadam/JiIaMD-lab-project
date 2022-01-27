/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gembala.adam.caesar.repository;

import gembala.adam.caesar.model.HistoryRecord;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * Repository of history record
 * @author Adam Gembala
 */
public class HistoryRepository {
    
    EntityManager manager;
    
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
            manager.close();
        }
    }
    
    /**
     * Method gets all history records from the database
     * @return List of history records
     */
    public List<HistoryRecord> Read() {
        manager.getTransaction().begin();
        try {
            Query query = manager.createQuery("SELECT p FROM Person p");
            return query.getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace();
            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }
        
        return null;
    }
}
