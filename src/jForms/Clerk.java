/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jForms;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author lutfijamaluddin
 */
@Entity
@Table(name = "CLERK", catalog = "", schema = "LUDWIG")
@NamedQueries({
    @NamedQuery(name = "Clerk.findAll", query = "SELECT c FROM Clerk c")
    , @NamedQuery(name = "Clerk.findByPassword", query = "SELECT c FROM Clerk c WHERE c.password = :password")
    , @NamedQuery(name = "Clerk.findByUsername", query = "SELECT c FROM Clerk c WHERE c.username = :username")
    , @NamedQuery(name = "Clerk.findByName", query = "SELECT c FROM Clerk c WHERE c.name = :name")
    , @NamedQuery(name = "Clerk.findByGender", query = "SELECT c FROM Clerk c WHERE c.gender = :gender")
    , @NamedQuery(name = "Clerk.findByEmail", query = "SELECT c FROM Clerk c WHERE c.email = :email")
    , @NamedQuery(name = "Clerk.findByContactnumber", query = "SELECT c FROM Clerk c WHERE c.contactnumber = :contactnumber")
    , @NamedQuery(name = "Clerk.findById", query = "SELECT c FROM Clerk c WHERE c.id = :id")})
public class Clerk implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "NAME")
    private String name;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "CONTACTNUMBER")
    private Boolean contactnumber;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;

    public Clerk() {
    }

    public Clerk(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        changeSupport.firePropertyChange("password", oldPassword, password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        String oldUsername = this.username;
        this.username = username;
        changeSupport.firePropertyChange("username", oldUsername, username);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        String oldGender = this.gender;
        this.gender = gender;
        changeSupport.firePropertyChange("gender", oldGender, gender);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public Boolean getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(Boolean contactnumber) {
        Boolean oldContactnumber = this.contactnumber;
        this.contactnumber = contactnumber;
        changeSupport.firePropertyChange("contactnumber", oldContactnumber, contactnumber);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
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
        if (!(object instanceof Clerk)) {
            return false;
        }
        Clerk other = (Clerk) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jForms.Clerk[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
