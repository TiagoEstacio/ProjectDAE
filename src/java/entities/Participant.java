/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJBException;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
*listar os meus eventos, para que possa estar a par dos mesmos (exemplo: listar as aulas do participante aluno1@my.ipleiria.pt);

*marcar presença em determinado evento que está a ocorrer (e cuja marcação de presença está aberta), para que fique
registado que estive presente nesse evento (exemplo: marcar presença no evento1: aula T
de DAE de 14.out.2015).
 */
@Entity
@Table(name = "PARTICIPANTS")
@NamedQueries({
    @NamedQuery(
        name="getAllParticipants",
        query="SELECT pa FROM Participant pa ORDER BY pa.id"
    )
})
public class Participant extends User implements Serializable {
    
    @ManyToMany(mappedBy = "participants")
    private List<Event> events;
    
    @ManyToMany(mappedBy = "participants")
    private List<Category> categorys;
    
    public Participant() {
        this.events = new LinkedList<>();
        this.categorys = new LinkedList<>();
    }
    
    public Participant(String name, String email, String userName, String password) {
        super(name, email, userName, password);
        this.events = new LinkedList<>();
        this.categorys = new LinkedList<>();
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Category> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<Category> categorys) {
        this.categorys = categorys;
    }
    
    public void addEvent(Event event){
        try {
            if (!events.contains(event)){
                events.add(event);
            }
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }
    
    public void removeEvent(Event event){
        try {
            if (events.contains(event)){
                events.remove(event);
            }
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }
    
    public int getNumberOfEvents(){
        return this.events.size();
    }
    
    public void addCategory(Category category){
        try {
            if (!categorys.contains(category)){
                categorys.add(category);
            }
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }
    
    public void removeCategory(Category category){
        try {
            if (categorys.contains(category)){
                categorys.remove(category);
            }
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }
    
    public int getNumberOfCategorys(){
        return this.categorys.size();
    }

    @Override
    public String toString() {
        return "entities.Participant[id=" + id + "]: "+ name;
    }
    
}
