/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import dbentity.EmployeeDetails;
import entitycontrollers.ControllerFactory;
import entitycontrollers.EmployeeDetailsJpaController;

/**
 *
 * @author mukul.kumar
 */
public class EmployeeDetailsOperations {
   
    private final EmployeeDetailsJpaController mEmployeeDetailsFactory;
    private EmployeeDetails mEmployeeDetailsDBEntity ;

   
    
    public EmployeeDetailsOperations() {
        this.mEmployeeDetailsFactory  = ControllerFactory.getController();
    }
    
     public EmployeeDetails getmEmployeeDetailsDBEntity() {
        return mEmployeeDetailsDBEntity;
    }

    public void setmEmployeeDetailsDBEntity(EmployeeDetails mEmployeeDetailsDBEntity) {
        this.mEmployeeDetailsDBEntity = mEmployeeDetailsDBEntity;
    }
    
    public void createmEmployeeDetailsDBEntity(String mail){
        mEmployeeDetailsDBEntity =  mEmployeeDetailsFactory.findEmployeeDetails(mail);              
    } 
}

 
