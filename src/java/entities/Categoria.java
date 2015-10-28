/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ITWannaBe
 */
@Entity
public class Categoria {

    //Comentario HD
    //outro
    
    @Id
    private int id;
    
    @NotNull
    private String nome;
    
    private List<Evento> events;

    public Categoria() {
        events = new LinkedList<>();
    }

    public Categoria(int id, String nome) {
        this.id = id;
        this.nome = nome;
        events = new LinkedList<>();
    }
}
