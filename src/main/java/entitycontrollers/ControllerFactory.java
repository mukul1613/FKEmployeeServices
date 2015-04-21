/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitycontrollers;

import javax.persistence.Persistence;

 

/**
 *
 * @author mukul.kumar
 */
public class ControllerFactory {

    /**
     * this is an abstract factory design as this hides the creation logic for various controllers
     * @return the controller factory for employee details
     */
   public static EmployeeDetailsJpaController getEmployeeDetailsController() {
        return new EmployeeDetailsJpaController(Persistence.createEntityManagerFactory("com.mycompany_FKEmployeeServices_war_1.0-SNAPSHOTPU"));
    }
   
   public static EvaNewsJpaController getEvaNewsJpaController(){
       return new EvaNewsJpaController(Persistence.createEntityManagerFactory("com.mycompany_FKEmployeeServices_war_1.0-SNAPSHOTPU"));
   }
   
   public static EvaNotificationsJpaController getevaEvaNotificationsJpaController(){
       return new EvaNotificationsJpaController(Persistence.createEntityManagerFactory("com.mycompany_FKEmployeeServices_war_1.0-SNAPSHOTPU"));
   }
   
}
