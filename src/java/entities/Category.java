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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "CATEGORYS")
@NamedQueries({
    @NamedQuery(
        name="getAllCategorys",
        query="SELECT ca FROM Category ca ORDER BY ca.id"
    )
})
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    private String name;
    
    @ManyToMany
    @JoinTable(name = "CATEGORY_EVENTS",
            joinColumns
            = @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID_CATEGORY"),
            inverseJoinColumns
            = @JoinColumn(name = "EVENTS_ID", referencedColumnName = "ID_EVENTS"))
    private List<Event> events;
    
    @ManyToMany
    @JoinTable(name = "CATEGORY_PARTICIPANTS",
            joinColumns
            = @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID_CATEGORY"),
            inverseJoinColumns
            = @JoinColumn(name = "PARTICIPANTS_ID", referencedColumnName = "ID_PARTICIPANTS"))
    private List<Participant> participants;
    
    public Category() {
        this.events = new LinkedList<>();
        this.participants = new LinkedList<>();
    }

    public Category(String name) {
        this.name = name;
        this.events = new LinkedList<>();
        this.participants = new LinkedList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
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
    
    public void addParticipant(Participant participant){
        try {
            if (!participants.contains(participant)){
                participants.add(participant);
            }
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }
    
    public void removeParticipant(Participant participant){
        try {
            if (participants.contains(participant)){
                participants.remove(participant);
            }
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }
    
    public int getNumberOfParticipants(){
        return this.participants.size();
    }
    
    @Override
    public String toString() {
        return "entities.Category[id=" + id + "]: "+ name;
    }
}
