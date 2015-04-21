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
@Table(name = "eva_news")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EvaNews.findAll", query = "SELECT e FROM EvaNews e"),
    @NamedQuery(name = "EvaNews.findByEmailId", query = "SELECT e FROM EvaNews e WHERE e.emailId = :emailId"),
    @NamedQuery(name = "EvaNews.findByNews1", query = "SELECT e FROM EvaNews e WHERE e.news1 = :news1"),
    @NamedQuery(name = "EvaNews.findByNews2", query = "SELECT e FROM EvaNews e WHERE e.news2 = :news2"),
    @NamedQuery(name = "EvaNews.findByNews3", query = "SELECT e FROM EvaNews e WHERE e.news3 = :news3")})
public class EvaNews implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "email_id")
    private String emailId;
    @Size(max = 255)
    @Column(name = "news_1")
    private String news1;
    @Size(max = 255)
    @Column(name = "news_2")
    private String news2;
    @Size(max = 255)
    @Column(name = "news_3")
    private String news3;

    public EvaNews() {
    }

    public EvaNews(String emailId) {
        this.emailId = emailId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getNews1() {
        return news1;
    }

    public void setNews1(String news1) {
        this.news1 = news1;
    }

    public String getNews2() {
        return news2;
    }

    public void setNews2(String news2) {
        this.news2 = news2;
    }

    public String getNews3() {
        return news3;
    }

    public void setNews3(String news3) {
        this.news3 = news3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailId != null ? emailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaNews)) {
            return false;
        }
        EvaNews other = (EvaNews) object;
        if ((this.emailId == null && other.emailId != null) || (this.emailId != null && !this.emailId.equals(other.emailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbentity.EvaNews[ emailId=" + emailId + " ]";
    }
    
}
