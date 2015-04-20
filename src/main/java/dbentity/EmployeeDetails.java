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
@Table(name = "employee_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeDetails.findAll", query = "SELECT e FROM EmployeeDetails e"),
    @NamedQuery(name = "EmployeeDetails.findById", query = "SELECT e FROM EmployeeDetails e WHERE e.id = :id"),
    @NamedQuery(name = "EmployeeDetails.findByEmpId", query = "SELECT e FROM EmployeeDetails e WHERE e.empId = :empId"),
    @NamedQuery(name = "EmployeeDetails.findByEmpEmailid", query = "SELECT e FROM EmployeeDetails e WHERE e.empEmailid = :empEmailid"),
    @NamedQuery(name = "EmployeeDetails.findByEmpContact", query = "SELECT e FROM EmployeeDetails e WHERE e.empContact = :empContact"),
    @NamedQuery(name = "EmployeeDetails.findByEmpDesignation", query = "SELECT e FROM EmployeeDetails e WHERE e.empDesignation = :empDesignation"),
    @NamedQuery(name = "EmployeeDetails.findByEmpManager", query = "SELECT e FROM EmployeeDetails e WHERE e.empManager = :empManager"),
    @NamedQuery(name = "EmployeeDetails.findByEmpName", query = "SELECT e FROM EmployeeDetails e WHERE e.empName = :empName")})
public class EmployeeDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "emp_id")
    private int empId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "emp_emailid")
    private String empEmailid;
    @Column(name = "emp_contact")
    private Integer empContact;
    @Size(max = 255)
    @Column(name = "emp_designation")
    private String empDesignation;
    @Size(max = 255)
    @Column(name = "emp_manager")
    private String empManager;
    @Size(max = 255)
    @Column(name = "emp_name")
    private String empName;

    public EmployeeDetails() {
    }

    public EmployeeDetails(Integer id) {
        this.id = id;
    }

    public EmployeeDetails(Integer id, int empId, String empEmailid) {
        this.id = id;
        this.empId = empId;
        this.empEmailid = empEmailid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpEmailid() {
        return empEmailid;
    }

    public void setEmpEmailid(String empEmailid) {
        this.empEmailid = empEmailid;
    }

    public Integer getEmpContact() {
        return empContact;
    }

    public void setEmpContact(Integer empContact) {
        this.empContact = empContact;
    }

    public String getEmpDesignation() {
        return empDesignation;
    }

    public void setEmpDesignation(String empDesignation) {
        this.empDesignation = empDesignation;
    }

    public String getEmpManager() {
        return empManager;
    }

    public void setEmpManager(String empManager) {
        this.empManager = empManager;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
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
        if (!(object instanceof EmployeeDetails)) {
            return false;
        }
        EmployeeDetails other = (EmployeeDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbentity.EmployeeDetails[ id=" + id + " ]";
    }
    
}
