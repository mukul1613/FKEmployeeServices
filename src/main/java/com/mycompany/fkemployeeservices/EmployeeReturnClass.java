/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fkemployeeservices;

import dbentity.EmployeeDetails;
import java.math.BigInteger;
import javax.ws.rs.core.Context;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mukul.kumar
 */

@XmlRootElement
public class EmployeeReturnClass {
    int  emp_id;
    String email;
    String Name;
    String designation;
    BigInteger contact;
    String manager;

    public EmployeeReturnClass(int id, String email, String fName, String lName, String designation, BigInteger contact, String manager) {
        this.emp_id = id;
        this.email = email;
        this.Name = fName;
        this.designation = designation;
        this.contact = contact;
        this.manager = manager;
    }

    
    
    public EmployeeReturnClass(EmployeeDetails dbentityObject) {
        if (dbentityObject != null) {
            this.emp_id = dbentityObject.getEmpId();
            this.email = dbentityObject.getEmpEmailid();
            this.Name = dbentityObject.getEmpName();
            this.designation = dbentityObject.getEmpDesignation();
            this.contact = dbentityObject.getEmpContact();
            this.manager = dbentityObject.getEmpManager();
        } else {
            setDummyValue();
        }
    }

   
    
    public EmployeeReturnClass() {
    }

    public void setDummyValue() {
        this.emp_id = 99999;
        this.email = "NA";
        this.Name = "NA";
        this.designation = "NA";;
        this.contact = new BigInteger("9999999999");
        this.manager =  "NA";         
    }
    public int getId() {
        return emp_id;
    }

    public void setId(int id) {
        this.emp_id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public BigInteger getContact() {
        return contact;
    }

    public void setContact(BigInteger contact) {
        this.contact = contact;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
     
    
    
}
