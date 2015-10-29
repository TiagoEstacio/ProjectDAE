/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class ConfigBean {

    @EJB
    private AdministratorBean admiBean;
    @EJB
    private ResponsibleBean respBean;
    @EJB
    private ParticipantBean partBean;
    @EJB
    private EventBean eventBean;
    @EJB
    private CategoryBean catBean;
    
    
    @PostConstruct
    public void populateDB() {
        
        //TODO
        
    }
}
