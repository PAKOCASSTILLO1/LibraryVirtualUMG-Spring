package com.library.api.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * SystemUserRol
 */
@Entity
@Table(name = "System_User_Roles")
public class SystemUserRol implements Serializable{

    private static final long serialVersionUID = -5686171692148594109L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "systemUserRolId")
    @SequenceGenerator(name = "systemUserRolId", sequenceName = "ID_USER_ROL")
    public int systemUserRolId;

    @NotNull
    @NotBlank
    public String userId;

    @NotNull
    @NotBlank
    public String rolId;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "FK_SYSTEM_USER", nullable = false, updatable = false)
    public SystemUser systemUser;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "FK_SYSTEM_ROL", nullable = false, updatable = false)
    public SystemRoles systemRol;

    public int state = 1;
    public Date createdOn = new Date();

    @NotNull
    @NotBlank
    public String createdUser;
    
    public Date modifiedOn;
    public String modifiedUser;


    public SystemUserRol() {
    }

    public SystemUserRol(String userId, SystemUser systemUser, String rolId, SystemRoles systemRol, int state, Date createdOn, String createdUser, Date modifiedOn, String modifiedUser) {
        this.userId = userId;
        this.systemUser = systemUser;
        this.rolId = rolId;
        this.systemRol = systemRol;
        this.state = state;
        this.createdOn = createdOn;
        this.createdUser = createdUser;
        this.modifiedOn = modifiedOn;
        this.modifiedUser = modifiedUser;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public SystemUser getSystemUser() {
        return this.systemUser;
    }

    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }

    public String getRolId() {
        return this.rolId;
    }

    public void setRolId(String rolId) {
        this.rolId = rolId;
    }

    public SystemRoles getSystemRol() {
        return this.systemRol;
    }

    public void setSystemRol(SystemRoles systemRol) {
        this.systemRol = systemRol;
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

    public SystemUserRol userId(String userId) {
        this.userId = userId;
        return this;
    }

    public SystemUserRol systemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
        return this;
    }

    public SystemUserRol rolId(String rolId) {
        this.rolId = rolId;
        return this;
    }

    public SystemUserRol systemRol(SystemRoles systemRol) {
        this.systemRol = systemRol;
        return this;
    }

    public SystemUserRol state(int state) {
        this.state = state;
        return this;
    }

    public SystemUserRol createdOn(Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public SystemUserRol createdUser(String createdUser) {
        this.createdUser = createdUser;
        return this;
    }

    public SystemUserRol modifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
        return this;
    }

    public SystemUserRol modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

}