package com.library.api.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Country
 */
@Entity
public class Country implements Serializable{

    private static final long serialVersionUID = -6155967583049152377L;

    // PRIMARY KEY
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "countryId")
    @SequenceGenerator(name = "countryId", sequenceName = "ID_COUNTRY")
    public int countryId;

    @NotNull
    @NotBlank
    public String name;
    
    public int state = 1;
    public Date createdOn = new Date();
    
    @NotNull
    @NotBlank
    public String createdUser;
    
    public Date modifiedOn;
    public String modifiedUser;

    public Country modified(Country body){
        this.name = body.getName();
        this.modifiedOn = new Date();
        if (body.getModifiedUser()==null) {
            this.modifiedUser = body.getCreatedUser();
        } else {
            this.modifiedUser = body.getModifiedUser();
        }
        return this;
    }


    public Country() {
    }

    public Country(int countryId, String name, int state, Date createdOn, String createdUser, Date modifiedOn, String modifiedUser) {
        this.countryId = countryId;
        this.name = name;
        this.state = state;
        this.createdOn = createdOn;
        this.createdUser = createdUser;
        this.modifiedOn = modifiedOn;
        this.modifiedUser = modifiedUser;
    }

    public int getCountryId() {
        return this.countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Country countryId(int countryId) {
        this.countryId = countryId;
        return this;
    }

    public Country name(String name) {
        this.name = name;
        return this;
    }

    public Country state(int state) {
        this.state = state;
        return this;
    }

    public Country createdOn(Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Country createdUser(String createdUser) {
        this.createdUser = createdUser;
        return this;
    }

    public Country modifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
        return this;
    }

    public Country modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

}