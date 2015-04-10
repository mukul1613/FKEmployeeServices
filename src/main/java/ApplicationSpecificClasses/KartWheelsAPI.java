/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationSpecificClasses;

import data.EmployeeDetailsOperations;
import java.sql.SQLException;

/**
 *
 * @author mukul.kumar
 */
public class KartWheelsAPI implements ApplicationAPI{
    private  EmployeeDetailsOperations CustomDetail;

    public KartWheelsAPI() throws SQLException,Exception{
        
    }
    
    /**
     *
     * @return
     */
    @Override
     public EmployeeDetailsOperations getAppSpecificEmployeeInfo() {
         this.CustomDetail =  new EmployeeDetailsOperations();
        return CustomDetail;
    }
}
