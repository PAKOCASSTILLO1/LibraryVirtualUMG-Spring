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
 * SystemRolesPermission
 */
@Entity
@Table(name = "System_Roles_Permissions")
public class SystemRolesPermission implements Serializable{

    private static final long serialVersionUID = 1670794931424272351L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "systemRolePermissionId")
    @SequenceGenerator(name = "systemRolePermissionId", sequenceName = "ID_ROLE_PERMISSION")
    public int systemRolePermissionId;

    @NotNull
    @NotBlank
    private String rolId;

    @NotNull
    @NotBlank
    private String permissionsId;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "FK_SYSTEM_ROL", nullable = false, updatable = false)
    private SystemRoles systemRol;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "FK_SYSTEM_PERMISSION", nullable = false, updatable = false)
    private SystemPermissions systemPermissions;

    private int state=1;
    private Date createdOn = new Date();

    @NotNull
    @NotBlank
    private String createdUser;
    
    private Date modifiedOn;
    private String modifiedUser;


    public SystemRolesPermission() {
    }

    public SystemRolesPermission(String rolId, SystemRoles systemRol, String permissionsId, SystemPermissions systemPermissions, int state, Date createdOn, String createdUser, Date modifiedOn, String modifiedUser) {
        this.rolId = rolId;
        this.systemRol = systemRol;
        this.permissionsId = permissionsId;
        this.systemPermissions = systemPermissions;
        this.state = state;
        this.createdOn = createdOn;
        this.createdUser = createdUser;
        this.modifiedOn = modifiedOn;
        this.modifiedUser = modifiedUser;
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

    public String getPermissionsId() {
        return this.permissionsId;
    }

    public void setPermissionsId(String permissionsId) {
        this.permissionsId = permissionsId;
    }

    public SystemPermissions getSystemPermissions() {
        return this.systemPermissions;
    }

    public void setSystemPermissions(SystemPermissions systemPermissions) {
        this.systemPermissions = systemPermissions;
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

    public SystemRolesPermission rolId(String rolId) {
        this.rolId = rolId;
        return this;
    }

    public SystemRolesPermission systemRol(SystemRoles systemRol) {
        this.systemRol = systemRol;
        return this;
    }

    public SystemRolesPermission permissionsId(String permissionsId) {
        this.permissionsId = permissionsId;
        return this;
    }

    public SystemRolesPermission systemPermissions(SystemPermissions systemPermissions) {
        this.systemPermissions = systemPermissions;
        return this;
    }

    public SystemRolesPermission state(int state) {
        this.state = state;
        return this;
    }

    public SystemRolesPermission createdOn(Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public SystemRolesPermission createdUser(String createdUser) {
        this.createdUser = createdUser;
        return this;
    }

    public SystemRolesPermission modifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
        return this;
    }

    public SystemRolesPermission modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

}