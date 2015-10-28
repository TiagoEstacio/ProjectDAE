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

/**
* criar, consultar/listar, atualizar e remover um utilizador (administrador, responsável ou participante), para que possa manter
atualizada a lista de utilizadores da aplicação empresarial;

* criar, consultar/listar, atualizar e remover eventos de calendário (aulas, reuniões, seminários, etc.), para que possa manter
atualizada a lista de eventos onde ocorrerá uma marcação/verificação de presenças;

* criar, consultar/listar, atualizar e remover um utilizador responsável por determinado evento (exemplo: evento1 - aula de DAE T,
quartas-feiras, 18h-20h, sala A.S.2.12, semanas 38:51, 1:2, responsável: ricardo.martinho@ipleiria.pt);
 
 * Administrador/Responsavel
    * criar, consultar/listar, e remover um ou mais utilizadores participantes em determinado
evento (exemplo: remover utilizador participante externo1@email.com do evento1;
adicionar lista de utilizadores participantes via copy/paste dos seus ids ao evento1;
adicionar lista de utilizadores participantes via outra classificação predefinida, como por
exemplo, todos os participantes classificados como inscritos à UC de DAE), para que
possa manter atualizada a lista de participantes de determinado evento;

 */
@Entity
public class Administrador extends User implements Serializable {

    private List<User> users;
    private List<Evento> eventos;
    
    public Administrador() {
        users = new LinkedList<>();
        eventos = new LinkedList<>();
    }

    public Administrador(String name, String email, String userName, String password) {
        super(name, email, userName, password);
        users = new LinkedList<>();
        eventos = new LinkedList<>();

    }
    
    public void addUser(User user) {
        users.add(user);
    }
    
    public void removeUser(User user) {
        users.remove(user);
    }
    
    
//GS---------------------------------------------------------------------------    
// 
//    
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }    
}
