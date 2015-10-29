/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entities.Category;
import entities.Event;
import entities.Participant;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ParticipantBean {

    @PersistenceContext
    private EntityManager em;
    
    public void createParticipant (String name, String email, String userName, String password){
        try {
            Participant p = new Participant (name, email, userName, password);
            em.persist(p);
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }
    
    public List<Participant> getAll() {
        try {
            List<Participant> participants = (List<Participant>) em.createNamedQuery("getAllParticipants").getResultList();
            return participants;
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }
 
     public void updateParticipant (Long id, String name, String email, String userName, String password){
        try {
            Participant pUpdate = em.find(Participant.class, id);
            if (pUpdate == null){
                return;
            }
            pUpdate.setName(name);
            pUpdate.setEmail(email);
            pUpdate.setUserName(userName);
            pUpdate.setPassword(password);
            em.merge(pUpdate);   
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
     }
     
     public void removeParticipant(Long id){
        try {
            Participant pRemove = em.find(Participant.class, id);
            if (pRemove == null){
                return;
            }
            em.remove(pRemove);
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        } 
     }
     
    public void enrollParticipantInEvent(Long idParticipant, Long idEvent){
        try {
            Participant p = em.find(Participant.class, idParticipant);
            Event e = em.find(Event.class, idEvent);
        
            e.addParticipant(p);
            p.addEvent(e);
        
            em.merge(e);
            em.merge(p);
  
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
     }

    public List<Event> getAllEventsOfParticipant(Participant currentParticipant) {
        try {
            List<Event> events = currentParticipant.getEvents();
            return events; 
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }
    
    public void enrollParticipantInCategory(Long idParticipant, Long idCategory){
        try {
            Participant p = em.find(Participant.class, idParticipant);
            Category c = em.find(Category.class, idCategory);
        
            c.addParticipant(p);
            p.addCategory(c);
        
            em.merge(c);
            em.merge(c);
  
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
     }

    public List<Category> getAllCategorysOfParticipant(Participant currentParticipant) {
        try {
            List<Category> categorys = currentParticipant.getCategorys();
            return categorys; 
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }
}
