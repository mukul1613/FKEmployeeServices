/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import dbentity.EvaEmpDetails;

/**
 *
 * @author mukul.kumar
 */
public class EmployeeReturnClass {
    long id;
    String email;
    String fName;
    String lName;
    String designation;
    String contact;
    String maneger;

    public EmployeeReturnClass(long id, String email, String fName, String lName, String designation, String contact, String maneger) {
        this.id = id;
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.designation = designation;
        this.contact = contact;
        this.maneger = maneger;
    }

    public EmployeeReturnClass(EvaEmpDetails dbentityObject) {
        this.id = dbentityObject.getId();
        this.email = dbentityObject.getEmail();
        this.fName = dbentityObject.getFName();
        this.lName = dbentityObject.getLName();
        this.designation = dbentityObject.getDesignation();
        this.contact = dbentityObject.getContact();
        this.maneger = dbentityObject.getManager();
    }

    
    
    public EmployeeReturnClass() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getManeger() {
        return maneger;
    }

    public void setManeger(String maneger) {
        this.maneger = maneger;
    }
        
     
}
