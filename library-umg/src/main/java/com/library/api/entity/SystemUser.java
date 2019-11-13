package com.library.api.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * SystemUser
 */
@Entity
@Table(name = "System_User")
public class SystemUser implements Serializable{

    private static final long serialVersionUID = -3253557449238037488L;

    // PRIMARY KEY
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "userId")
    @SequenceGenerator(name = "userId", sequenceName = "ID_USER", allocationSize = 1)
    public int userId;

    @NotNull
    @NotBlank
    public String name;

    @NotNull
    @NotBlank
    public String password;

    @NotNull
    @NotBlank
    public String email;

    @NotNull
    @NotBlank
    public String telephone;

    public int state = 1;
    public Date createdOn = new Date();

    @NotNull
    @NotBlank
    public String createdUser;
    
    public Date modifiedOn;
    public String modifiedUser;

    public SystemUser modified(SystemUser body){
        this.name = body.getName();
        this.password = body.getPassword();
        this.email = body.getEmail();
        this.telephone = body.getTelephone();
        this.modifiedOn = new Date();
        if (body.modifiedUser == null) {
            this.modifiedUser = body.getCreatedUser();
        } else {
            this.modifiedUser = body.getModifiedUser();
        }
        return this;
    }


    public SystemUser() {
    }

    public SystemUser(int userId, String name, String password, String email, String telephone, int state, Date createdOn, String createdUser, Date modifiedOn, String modifiedUser) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.telephone = telephone;
        this.state = state;
        this.createdOn = createdOn;
        this.createdUser = createdUser;
        this.modifiedOn = modifiedOn;
        this.modifiedUser = modifiedUser;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedUser() {
        return this.createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getModifiedOn() {
        return this.modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getModifiedUser() {
        return this.modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public SystemUser userId(int userId) {
        this.userId = userId;
        return this;
    }

    public SystemUser name(String name) {
        this.name = name;
        return this;
    }

    public SystemUser password(String password) {
        this.password = password;
        return this;
    }

    public SystemUser email(String email) {
        this.email = email;
        return this;
    }

    public SystemUser telephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public SystemUser state(int state) {
        this.state = state;
        return this;
    }

    public SystemUser createdOn(Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public SystemUser createdUser(String createdUser) {
        this.createdUser = createdUser;
        return this;
    }

    public SystemUser modifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
        return this;
    }

    public SystemUser modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

}