/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import dbentity.EmployeeDetails;
import dbentity.EvaNews;
import dbentity.EvaNotifications;
import entitycontrollers.ControllerFactory;
import entitycontrollers.EmployeeDetailsJpaController;
import entitycontrollers.EvaNewsJpaController;
import entitycontrollers.EvaNotificationsJpaController;

/**
 *
 * @author mukul.kumar
 */
public class EmployeeDetailsOperations {
   
    private final EmployeeDetailsJpaController mEmployeeDetailsFactory;
    private EvaNewsJpaController mEvaNewsJpaController;
    private EvaNotificationsJpaController mEvaNotificationsJpaController;
    
    private EmployeeDetails mEmployeeDetailsDBEntity ;
    private EvaNews mEvaNewsDBEntity;
    private EvaNotifications mEvaNotificationsDBEntity;
    
    
    
    public EvaNewsJpaController getmEvaNewsJpaController() {
        return mEvaNewsJpaController;
    }    
    
    public EvaNotificationsJpaController getmEvaNotificationsJpaController() {
        return mEvaNotificationsJpaController;
    }
    
    public void setmEvaNewsJpaController(EvaNewsJpaController mEvaNewsJpaController) {
        this.mEvaNewsJpaController = mEvaNewsJpaController;
    }    

    public void setmEvaNotificationsJpaController(EvaNotificationsJpaController mEvaNotificationsJpaController) {
        this.mEvaNotificationsJpaController = mEvaNotificationsJpaController;
    }
       
    public EmployeeDetailsOperations() {
        this.mEmployeeDetailsFactory  = ControllerFactory.getEmployeeDetailsController();
    }
    
     public EmployeeDetails getmEmployeeDetailsDBEntity() {
        return mEmployeeDetailsDBEntity;
    }

    public void setmEmployeeDetailsDBEntity(EmployeeDetails mEmployeeDetailsDBEntity) {
        this.mEmployeeDetailsDBEntity = mEmployeeDetailsDBEntity;
    }
    
    public void createEmployeeDetailsDBEntity(String mail){
        mEmployeeDetailsDBEntity =  mEmployeeDetailsFactory.findEmployeeDetails(mail);              
    } 
    
    public void createEvaNewsJpaController(String mail){
        mEvaNewsDBEntity = mEvaNewsJpaController.findEvaNews(mail);
    }  
    
    public void createEvaNotificationsDBEntity(String mail){
        mEvaNotificationsDBEntity = mEvaNotificationsJpaController.findEvaNotifications(mail);
    }
    
    
}

 
