/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import beans.UserData;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ssome
 */
@Entity
@Table(name = "Users8276723")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String USER_ID;
    private String NAME;
    private Date BIRTHDATE;

    /**
     * Creates a new instance of User
     */
    public User() {

    }

    public User(String id, String name, Date bdate) {
        this.USER_ID = id;
        this.NAME = name;
        this.BIRTHDATE = bdate;
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public Date getBIRTHDATE() {
        return BIRTHDATE;
    }

    public void setUSER_ID(String id) {
        this.USER_ID = id;
    }

    public void setNAME(String name) {
        this.NAME = name;
    }

    public void setBIRTHDATE(Date date) {
        this.BIRTHDATE = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += this.USER_ID.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        return (this.USER_ID.equals(other.USER_ID));
    }

    @Override
    public String toString() {
        return "dbaccess.persistence.User[id=" + USER_ID + "]";
    }

    /**
     *
     * @param userData
     * @return true if this User matches the userData bean
     */
    public boolean matches(UserData userData) {
        if (!"".equals(userData.getId()) && !this.getUSER_ID().trim().equals(userData.getId().trim())) {
            return false;
        } else if (!"".equals(userData.getName()) && !this.getNAME().trim().equals(userData.getName().trim())) {
            return false;
        } else if (!"".equals(userData.getBirthdate())) {
            Date ddate = Date.valueOf(userData.getBirthdate());
            if (!this.getBIRTHDATE().equals(ddate)) {
                return false;
            }
        }
        return true;
    }

}
