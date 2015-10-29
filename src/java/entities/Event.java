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
@Table(name = "EVENTS")
@NamedQueries({
    @NamedQuery(
        name="getAllEvents",
        query="SELECT ev FROM Event ev ORDER BY ev.id"
    )
})
public class Event implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;
    
    private String description;
    
    @ManyToMany(mappedBy = "events")
    private List<Category> categorys;
   
    @NotNull
    private String startDate;
    
    @NotNull
    private String finishDate;
    
    @ManyToMany
    @JoinTable(name = "EVENTS_RESPONSIBLES",
            joinColumns
            = @JoinColumn(name = "EVENT_ID", referencedColumnName = "ID_EVENT"),
            inverseJoinColumns
            = @JoinColumn(name = "RESPONSIBLES_ID", referencedColumnName = "ID_RESPONSIBLES"))
    private List<Responsible> responsibles;
    
    @ManyToMany
    @JoinTable(name = "EVENTS_PARTICIPANTS",
            joinColumns
            = @JoinColumn(name = "EVENT_ID", referencedColumnName = "ID_EVENT"),
            inverseJoinColumns
            = @JoinColumn(name = "PARTICIPANTS_ID", referencedColumnName = "ID_PARTICIPANTS"))
    private List<Participant> participants;
    
    public Event() {
        this.categorys = new LinkedList<>();
        this.responsibles = new LinkedList<>();
        this.participants = new LinkedList<>();
    }

    public Event(String name,String startDate, String finishDate) {
        this.name = name;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.categorys = new LinkedList<>();
        this.responsibles = new LinkedList<>();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Category> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<Category> categorys) {
        this.categorys = categorys;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public List<Responsible> getResponsibles() {
        return responsibles;
    }

    public void setResponsibles(List<Responsible> responsibles) {
        this.responsibles = responsibles;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
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
    
    public void addResponsible(Responsible responsible){
        try {
            if (!responsibles.contains(responsible)){
                responsibles.add(responsible);
            }
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }
    
    public void removeResponsible(Responsible responsible){
        try {
            if (responsibles.contains(responsible)){
                responsibles.remove(responsible);
            }
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }
    
    public int getNumberOfResponsibles(){
        return this.responsibles.size();
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
        return "entities.Event[id=" + id + "]: "+ name;
    }
    
}
