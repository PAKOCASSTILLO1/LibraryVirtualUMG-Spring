package gt.edu.umg.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Editorial
 */
@Entity
public class Editorial implements Serializable{

    private static final long serialVersionUID = -5595553622812006244L;

    // PIMARY KEY
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "editorialId")
    @SequenceGenerator(name = "editorialId", sequenceName = "ID_EDITORIAL")
    public int editorialId;
    
    @NotNull
    @NotBlank
    public String name;

    public int countryId;
    
    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "FK_COUNTRY", nullable = false, updatable = false)
    public Country country;

    public int state = 1;
    public Date createdOn = new Date();

    @NotNull
    @NotBlank
    public String createdUser;
    
    public Date modifiedOn;
    public String modifiedUser;

    public Editorial modified(Editorial body, Country country){
        this.name = body.getName();
        this.countryId = body.getCountryId();
        this.country = country;
        this.modifiedOn = new Date();
        if (body.modifiedUser == null) {
            this.modifiedUser = body.getCreatedUser();
        } else {
            this.modifiedUser = body.getModifiedUser();
        }
        return this;
    }

    public Editorial(@NotNull @NotBlank String name, @NotNull @NotBlank int countryId,@NotNull @NotBlank String createdUser) {
		super();
		this.name = name;
		this.countryId = countryId;
		this.createdUser = createdUser;
    }

    public Editorial() {
    }

    public Editorial(int editorialId, String name, int countryId, Country country, int state, Date createdOn, String createdUser, Date modifiedOn, String modifiedUser) {
        this.editorialId = editorialId;
        this.name = name;
        this.countryId = countryId;
        this.country = country;
        this.state = state;
        this.createdOn = createdOn;
        this.createdUser = createdUser;
        this.modifiedOn = modifiedOn;
        this.modifiedUser = modifiedUser;
    }

    public int getEditorialId() {
        return this.editorialId;
    }

    public void setEditorialId(int editorialId) {
        this.editorialId = editorialId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountryId() {
        return this.countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
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

    public Editorial editorialId(int editorialId) {
        this.editorialId = editorialId;
        return this;
    }

    public Editorial name(String name) {
        this.name = name;
        return this;
    }

    public Editorial countryId(int countryId) {
        this.countryId = countryId;
        return this;
    }

    public Editorial country(Country country) {
        this.country = country;
        return this;
    }

    public Editorial state(int state) {
        this.state = state;
        return this;
    }

    public Editorial createdOn(Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Editorial createdUser(String createdUser) {
        this.createdUser = createdUser;
        return this;
    }

    public Editorial modifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
        return this;
    }

    public Editorial modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

}