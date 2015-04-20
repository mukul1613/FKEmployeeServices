/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import dbentity.EmployeeDetails;

/**
 *
 * @author mukul.kumar
 */
public class EmployeeReturnClass {
    int  id;
    String email;
    String Name;
    String designation;
    int contact;
    String manager;

    public EmployeeReturnClass(int id, String email, String fName, String lName, String designation, int contact, String manager) {
        this.id = id;
        this.email = email;
        this.Name = fName;
        this.designation = designation;
        this.contact = contact;
        this.manager = manager;
    }

    public EmployeeReturnClass(EmployeeDetails dbentityObject) {
        if (dbentityObject != null) {
            this.id = dbentityObject.getId();
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
        this.id = 0;
        this.email = "NA";
        this.Name = "NA";
        this.designation = "NA";;
        this.contact = 0;
        this.manager =  "NA";         
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
     
    
    
}
