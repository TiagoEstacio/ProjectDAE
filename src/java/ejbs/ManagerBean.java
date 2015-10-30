/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entities.Event;
import entities.Manager;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ManagerBean {

    @PersistenceContext
    private EntityManager em;
    
    public void createManager (String name, String email, String userName, String password){
        try {
            Manager m = new Manager (name, email, userName, password);
            em.persist(m);
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }
    
    public List<Manager> getAllManagers() {
        try {
            List<Manager> managers = (List<Manager>) em.createNamedQuery("getAllManagers").getResultList();
            return managers;
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }
 
     public void updateManager (Long id, String name, String email, String userName, String password){
        try {
            Manager mUpdate = em.find(Manager.class, id);
            if (mUpdate == null){
                return;
            }
            mUpdate.setName(name);
            mUpdate.setEmail(email);
            mUpdate.setUserName(userName);
            mUpdate.setPassword(password);
            em.merge(mUpdate);   
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
     }
     
     public void removeManager(Long id){
        try {
            Manager mRemove = em.find(Manager.class, id);
            if (mRemove == null){
                return;
            }
            em.remove(mRemove);
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        } 
     }
     
    public void enrollManagerInEvent(Long idManager, Long idEvent){
        try {
            Manager m = em.find(Manager.class, idManager);
            Event e = em.find(Event.class, idEvent);
        
            e.addManager(m);
            m.addEvent(e);
        
            em.merge(e);
            em.merge(m);
  
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
     }

    public List<Event> getAllEventsOfManager(Manager currentManager) {
        try {
            List<Event> events = currentManager.getEvents();
            return events; 
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }
    
}
