/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import dbentity.EvaEmpDetails;
import entitycontrollers.ControllerFactory;
import entitycontrollers.EvaEmpDetailsJpaController;

/**
 *
 * @author mukul.kumar
 */
public class EmployeeDetailsOperations {
   
    private final EvaEmpDetailsJpaController mEmployeeDetailsFactory;
    private EvaEmpDetails mEvaEmpDetailsDBEntity ;

   
    
    public EmployeeDetailsOperations() {
        this.mEmployeeDetailsFactory  = ControllerFactory.getController();
    }
    
     public EvaEmpDetails getmEvaEmpDetailsDBEntity() {
        return mEvaEmpDetailsDBEntity;
    }

    public void setmEvaEmpDetailsDBEntity(EvaEmpDetails mEvaEmpDetailsDBEntity) {
        this.mEvaEmpDetailsDBEntity = mEvaEmpDetailsDBEntity;
    }
    
    public void createmEvaEmpDetailsDBEntity(String mail){
        long id = 77002;
        mEvaEmpDetailsDBEntity =  mEmployeeDetailsFactory.findEvaEmpDetails(id);              
    } 
}

 
