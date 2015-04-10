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
public class EVAAPIs implements ApplicationAPI{
    
   private final EmployeeDetailsOperations CustomDetail;

    public EVAAPIs( )throws SQLException,Exception{
        this.CustomDetail = new EmployeeDetailsOperations();//new EmployeeDetailsOperations("mukul","kumar", "Syetems Consultant", "+91-8105555135");
    }
    
   @Override
     public EmployeeDetailsOperations getAppSpecificEmployeeInfo() {
        return CustomDetail;
    }
}
