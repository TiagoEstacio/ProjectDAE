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
*listar os meus eventos, para que possa estar a par dos mesmos (exemplo: listar as aulas do responsável
ricardo.martinho@ipleiria.pt);

*ABRIR e FECHAR a marcação de presenças em determinado evento do qual sou o responsável, para que possa disponibilizar a marcação
de presenças aos participantes desse evento (exemplo: abrir a marcação de presenças do
evento1: aula T de DAE de 14.out.2015);
*marcar ou remover a presença de determinado participante em determinado evento do qual sou o responsável, para que a
lista de presenças desse evento fique atualizada (exemplo: marcar ou remover a presença
previamente marcada do aluno1@my.ipleiria.pt no evento1: aula T de DAE de 14.out.2015) ;
 */
@Entity
@Table(name = "RESPONSIBLES")
@NamedQueries({
    @NamedQuery(
        name="getAllResponsibles",
        query="SELECT re FROM Responsible re ORDER BY re.id"
    )
})
public class Responsible extends User implements Serializable {
    
    @ManyToMany(mappedBy = "responsibles")
    private List<Event> events;

    public Responsible() {
        this.events = new LinkedList<>();
    }

    public Responsible(String name, String email, String userName, String password) {
        super(name, email, userName, password);
        this.events = new LinkedList<>();
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
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

    @Override
    public String toString() {
        return "entities.Resposible[id=" + id + "]: "+ name;
    }
    
}