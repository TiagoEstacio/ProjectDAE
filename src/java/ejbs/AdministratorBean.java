/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entities.Administrator;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class AdministratorBean {

    @PersistenceContext
    private EntityManager em;
    
    public void createAdministrator (String name, String email, String userName, String password){
        try {
            Administrator admin = new Administrator (name, email, userName, password);
            em.persist(admin);
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }
}