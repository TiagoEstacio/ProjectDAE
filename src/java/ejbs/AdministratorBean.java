/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entities.User;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ITWannaBe
 */
@Stateless
public class AdministratorBean {
    
    @PersistenceContext
    EntityManager em;

    public void createUser(String name, String email, String userName, String password) {
        try {
            //User user = new User(name, email, userName, password);
            //em.persist(user);
        }catch(EJBException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void updateUser(String name, String email, String userName, String password) {
        
    }
    
}
