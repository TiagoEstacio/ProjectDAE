/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import sun.util.calendar.BaseCalendar.Date;

/**
 *
 * @author ITWannaBe
 */
@Entity
public class Evento implements Serializable {
   
    @Id
    private Long id;
    
    @NotNull
    private Categoria categoria;
    
    @NotNull
    private String nome;
    
    //@NotNull
    //private Date data;
    
    @NotNull
    private List<Responsavel> responsaveis;
    
    private List<Participante> participantes;
    

    public Evento() {
        responsaveis = new LinkedList<>();
        participantes = new LinkedList<>();
    }
  
    public Evento(String nome) {
        this.nome = nome;
        
        responsaveis = new LinkedList<>();
        participantes = new LinkedList<>();
    }
    
    
    
    
//GS---------------------------------------------------------------------------      
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
/*
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
*/
    public List<Responsavel> getResponsaveis() {
        return responsaveis;
    }

    public void setResponsaveis(List<Responsavel> responsaveis) {
        this.responsaveis = responsaveis;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }
    
    @Override
    public String toString() {
        return "entities.Evento[ id=" + id + " ]";
    }
    
}
