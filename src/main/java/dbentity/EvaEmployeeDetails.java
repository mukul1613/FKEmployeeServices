/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbentity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mukul.kumar
 */
@Entity
@Table(name = "eva_employee_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EvaEmployeeDetails.findAll", query = "SELECT e FROM EvaEmployeeDetails e"),
    @NamedQuery(name = "EvaEmployeeDetails.findById", query = "SELECT e FROM EvaEmployeeDetails e WHERE e.id = :id"),
    @NamedQuery(name = "EvaEmployeeDetails.findByEmail", query = "SELECT e FROM EvaEmployeeDetails e WHERE e.email = :email"),
    @NamedQuery(name = "EvaEmployeeDetails.findByFname", query = "SELECT e FROM EvaEmployeeDetails e WHERE e.fname = :fname"),
    @NamedQuery(name = "EvaEmployeeDetails.findByLname", query = "SELECT e FROM EvaEmployeeDetails e WHERE e.lname = :lname"),
    @NamedQuery(name = "EvaEmployeeDetails.findByContact", query = "SELECT e FROM EvaEmployeeDetails e WHERE e.contact = :contact"),
    @NamedQuery(name = "EvaEmployeeDetails.findByDesignation", query = "SELECT e FROM EvaEmployeeDetails e WHERE e.designation = :designation"),
    @NamedQuery(name = "EvaEmployeeDetails.findByManager", query = "SELECT e FROM EvaEmployeeDetails e WHERE e.manager = :manager")})
public class EvaEmployeeDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id")
    private BigInteger id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "email")
    private String email;
    @Size(max = 60)
    @Column(name = "fname")
    private String fname;
    @Size(max = 60)
    @Column(name = "lname")
    private String lname;
    @Size(max = 10)
    @Column(name = "contact")
    private String contact;
    @Size(max = 50)
    @Column(name = "designation")
    private String designation;
    @Size(max = 60)
    @Column(name = "manager")
    private String manager;

    public EvaEmployeeDetails() {
    }

    public EvaEmployeeDetails(String email) {
        this.email = email;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaEmployeeDetails)) {
            return false;
        }
        EvaEmployeeDetails other = (EvaEmployeeDetails) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbentity.EvaEmployeeDetails[ email=" + email + " ]";
    }
    
}
