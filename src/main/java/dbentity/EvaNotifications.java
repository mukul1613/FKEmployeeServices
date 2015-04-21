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
@Table(name = "eva_notifications")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EvaNotifications.findAll", query = "SELECT e FROM EvaNotifications e"),
    @NamedQuery(name = "EvaNotifications.findByEmail", query = "SELECT e FROM EvaNotifications e WHERE e.email = :email"),
    @NamedQuery(name = "EvaNotifications.findByNotification1", query = "SELECT e FROM EvaNotifications e WHERE e.notification1 = :notification1"),
    @NamedQuery(name = "EvaNotifications.findByNotification2", query = "SELECT e FROM EvaNotifications e WHERE e.notification2 = :notification2"),
    @NamedQuery(name = "EvaNotifications.findByNotification3", query = "SELECT e FROM EvaNotifications e WHERE e.notification3 = :notification3")})
public class EvaNotifications implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "notification_1")
    private String notification1;
    @Size(max = 255)
    @Column(name = "notification_2")
    private String notification2;
    @Size(max = 255)
    @Column(name = "notification_3")
    private String notification3;

    public EvaNotifications() {
    }

    public EvaNotifications(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotification1() {
        return notification1;
    }

    public void setNotification1(String notification1) {
        this.notification1 = notification1;
    }

    public String getNotification2() {
        return notification2;
    }

    public void setNotification2(String notification2) {
        this.notification2 = notification2;
    }

    public String getNotification3() {
        return notification3;
    }

    public void setNotification3(String notification3) {
        this.notification3 = notification3;
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
        if (!(object instanceof EvaNotifications)) {
            return false;
        }
        EvaNotifications other = (EvaNotifications) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbentity.EvaNotifications[ email=" + email + " ]";
    }
    
}
