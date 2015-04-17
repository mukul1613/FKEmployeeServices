/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import dbentity.EvaEmployeeDetails;
import entitycontrollers.ControllerFactory;
import entitycontrollers.EvaEmployeeDetailsJpaController;

/**
 *
 * @author mukul.kumar
 */
public class EmployeeDetailsOperations {
   
    private final EvaEmployeeDetailsJpaController mEmployeeDetailsFactory;
    private EvaEmployeeDetails mEvaEmployeeDetailsDBEntity ;

   
    
    public EmployeeDetailsOperations() {
        this.mEmployeeDetailsFactory  = ControllerFactory.getController();
    }
    
     public EvaEmployeeDetails getmEvaEmployeeDetailsDBEntity() {
        return mEvaEmployeeDetailsDBEntity;
    }

    public void setmEvaEmployeeDetailsDBEntity(EvaEmployeeDetails mEvaEmployeeDetailsDBEntity) {
        this.mEvaEmployeeDetailsDBEntity = mEvaEmployeeDetailsDBEntity;
    }
    
    public void createmEvaEmployeeDetailsDBEntity(String mail){
        mEvaEmployeeDetailsDBEntity =  mEmployeeDetailsFactory.findEvaEmployeeDetails(mail);              
    } 
}

 
