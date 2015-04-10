/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationSpecificClasses;

import data.EmployeeDetailsOperations;

/**
 *
 * @author mukul.kumar
 */
public interface ApplicationAPI {

    public EmployeeDetailsOperations getAppSpecificEmployeeInfo();
    
}
