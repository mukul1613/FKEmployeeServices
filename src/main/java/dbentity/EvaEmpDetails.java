/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbentity;

import java.io.Serializable;
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
@Table(name = "eva_emp_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EvaEmpDetails.findAll", query = "SELECT e FROM EvaEmpDetails e"),
    @NamedQuery(name = "EvaEmpDetails.findById", query = "SELECT e FROM EvaEmpDetails e WHERE e.id = :id"),
    @NamedQuery(name = "EvaEmpDetails.findByEmail", query = "SELECT e FROM EvaEmpDetails e WHERE e.email = :email"),
    @NamedQuery(name = "EvaEmpDetails.findByFName", query = "SELECT e FROM EvaEmpDetails e WHERE e.fName = :fName"),
    @NamedQuery(name = "EvaEmpDetails.findByLName", query = "SELECT e FROM EvaEmpDetails e WHERE e.lName = :lName"),
    @NamedQuery(name = "EvaEmpDetails.findByDesignation", query = "SELECT e FROM EvaEmpDetails e WHERE e.designation = :designation"),
    @NamedQuery(name = "EvaEmpDetails.findByContact", query = "SELECT e FROM EvaEmpDetails e WHERE e.contact = :contact"),
    @NamedQuery(name = "EvaEmpDetails.findByManager", query = "SELECT e FROM EvaEmpDetails e WHERE e.manager = :manager")})
public class EvaEmpDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "FName")
    private String fName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "LName")
    private String lName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Designation")
    private String designation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Contact")
    private String contact;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Manager")
    private String manager;

    public EvaEmpDetails() {
    }

    public EvaEmpDetails(Long id) {
        this.id = id;
    }

    public EvaEmpDetails(Long id, String email, String fName, String lName, String designation, String contact, String manager) {
        this.id = id;
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.designation = designation;
        this.contact = contact;
        this.manager = manager;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaEmpDetails)) {
            return false;
        }
        EvaEmpDetails other = (EvaEmpDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbentity.EvaEmpDetails[ id=" + id + " ]";
    }
    
}
