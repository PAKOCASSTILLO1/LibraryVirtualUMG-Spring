package gt.edu.umg.demo.model;

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
 * Lenguaje
 */
@Entity
public class Lenguaje implements Serializable{

    private static final long serialVersionUID = -7387045179544684261L;

    // PRIMARY KEY
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "languageId")
    @SequenceGenerator(name = "languageId", sequenceName = "ID_LENGUAJE")
    public int languageId;

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

    public Lenguaje modified(Lenguaje body){
        this.name = body.getName();
        this.modifiedOn = new Date();
        this.modifiedUser = body.getModifiedUser();
        if (body.modifiedUser == null) {
            this.modifiedUser = body.getCreatedUser();
        } else {
            this.modifiedUser = body.getModifiedUser();
        }
        return this;
    }

    public Lenguaje() {
    }

    public Lenguaje(int languageId, String name, int state, Date createdOn, String createdUser, Date modifiedOn, String modifiedUser) {
        this.languageId = languageId;
        this.name = name;
        this.state = state;
        this.createdOn = createdOn;
        this.createdUser = createdUser;
        this.modifiedOn = modifiedOn;
        this.modifiedUser = modifiedUser;
    }

    public int getLanguageId() {
        return this.languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
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

    public Lenguaje languageId(int languageId) {
        this.languageId = languageId;
        return this;
    }

    public Lenguaje name(String name) {
        this.name = name;
        return this;
    }

    public Lenguaje state(int state) {
        this.state = state;
        return this;
    }

    public Lenguaje createdOn(Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Lenguaje createdUser(String createdUser) {
        this.createdUser = createdUser;
        return this;
    }

    public Lenguaje modifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
        return this;
    }

    public Lenguaje modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

}