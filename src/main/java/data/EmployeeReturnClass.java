/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import dbentity.EvaEmployeeDetails;

/**
 *
 * @author mukul.kumar
 */
public class EmployeeReturnClass {
    String id;
    String email;
    String fName;
    String lName;
    String designation;
    String contact;
    String manager;

    public EmployeeReturnClass(String id, String email, String fName, String lName, String designation, String contact, String manager) {
        this.id = id;
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.designation = designation;
        this.contact = contact;
        this.manager = manager;
    }

    public EmployeeReturnClass(EvaEmployeeDetails dbentityObject) {
        this.id = dbentityObject.getId().toString();
        this.email = dbentityObject.getEmail();
        this.fName = dbentityObject.getFname();
        this.lName = dbentityObject.getLname();
        this.designation = dbentityObject.getDesignation();
        this.contact = dbentityObject.getContact();
        this.manager = dbentityObject.getManager();
    }

    
    
    public EmployeeReturnClass() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
        
     
}
