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
 * SystemPermissions
 */
@Entity
@Table(name = "System_Permissions")
public class SystemPermissions implements Serializable{

    private static final long serialVersionUID = -3122781689837534352L;

    // PRIMARY KEY
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "permissionsId")
    @SequenceGenerator(name = "permissionsId", sequenceName = "ID_PERMISSIONS")
    public int permissionsId;
    
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

    public SystemPermissions modified(SystemPermissions body){
        this.name = body.getName();
        this.modifiedOn = new Date();
        this.modifiedUser = body.getModifiedUser();
        return this;
    }


    public SystemPermissions() {
    }

    public SystemPermissions(int permissionsId, String name, int state, Date createdOn, String createdUser, Date modifiedOn, String modifiedUser) {
        this.permissionsId = permissionsId;
        this.name = name;
        this.state = state;
        this.createdOn = createdOn;
        this.createdUser = createdUser;
        this.modifiedOn = modifiedOn;
        this.modifiedUser = modifiedUser;
    }

    public int getPermissionsId() {
        return this.permissionsId;
    }

    public void setPermissionsId(int permissionsId) {
        this.permissionsId = permissionsId;
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

    public SystemPermissions permissionsId(int permissionsId) {
        this.permissionsId = permissionsId;
        return this;
    }

    public SystemPermissions name(String name) {
        this.name = name;
        return this;
    }

    public SystemPermissions state(int state) {
        this.state = state;
        return this;
    }

    public SystemPermissions createdOn(Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public SystemPermissions createdUser(String createdUser) {
        this.createdUser = createdUser;
        return this;
    }

    public SystemPermissions modifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
        return this;
    }

    public SystemPermissions modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

}