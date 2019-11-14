package gt.edu.umg.demo.model;


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
 * SystemRoles
 */
@Entity
@Table(name = "System_Roles")
public class SystemRoles implements Serializable{

    private static final long serialVersionUID = -486454107806384353L;

    // PRIMARY KEY
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "roleId")
    @SequenceGenerator(name = "roleId", sequenceName = "ID_ROLE")
    public int roleId;

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

    public SystemRoles modified(SystemRoles body){
        this.name = body.getName();
        this.modifiedOn = new Date();
        this.modifiedUser = body.getModifiedUser();
        return this;
    }


    public SystemRoles() {
    }

    public SystemRoles(int roleId, String name, int state, Date createdOn, String createdUser, Date modifiedOn, String modifiedUser) {
        this.roleId = roleId;
        this.name = name;
        this.state = state;
        this.createdOn = createdOn;
        this.createdUser = createdUser;
        this.modifiedOn = modifiedOn;
        this.modifiedUser = modifiedUser;
    }

    public int getRoleId() {
        return this.roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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

    public SystemRoles roleId(int roleId) {
        this.roleId = roleId;
        return this;
    }

    public SystemRoles name(String name) {
        this.name = name;
        return this;
    }

    public SystemRoles state(int state) {
        this.state = state;
        return this;
    }

    public SystemRoles createdOn(Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public SystemRoles createdUser(String createdUser) {
        this.createdUser = createdUser;
        return this;
    }

    public SystemRoles modifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
        return this;
    }

    public SystemRoles modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

}