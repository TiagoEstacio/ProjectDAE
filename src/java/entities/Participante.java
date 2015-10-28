/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
*listar os meus eventos, para que possa estar a par dos mesmos (exemplo: listar as aulas do participante aluno1@my.ipleiria.pt);

*marcar presença em determinado evento que está a ocorrer (e cuja marcação de presença está aberta), para que fique
registado que estive presente nesse evento (exemplo: marcar presença no evento1: aula T
de DAE de 14.out.2015).
 */
@Entity
public class Participante extends User implements Serializable {
 
}
