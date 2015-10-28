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
public class Responsavel extends User implements Serializable {
   
    
}
