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
 * Author
 */
@Entity
public class Author implements Serializable{

    private static final long serialVersionUID = 209942840836782009L;

    // PRIMARY KEY
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "authorId")
    @SequenceGenerator(name = "authorId", sequenceName = "ID_AUTHOR")
    public int authorId;
    
    @NotNull
    @NotBlank
    public String name;

    public int countryId;
    
    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "FK_CONTRY", nullable = false, updatable = false)    
    public Country country;

    public int state = 1;
    public Date createdOn = new Date();
    
    @NotNull
    @NotBlank
    public String createdUser;

    public Date modifiedOn;
    public String modifiedUser;

    public Author modified(Author body, Country country){
        this.name = body.getName();
        this.countryId = body.getCountryId();
        this.country = country;
        this.modifiedOn = new Date();
        if (body.modifiedUser == null) {
            this.modifiedUser = body.getCreatedUser();
        } else {
            this.modifiedUser = body.modifiedUser;
        }
        return this;
    }

    public Author(@NotNull @NotBlank String name, @NotNull @NotBlank int countryId,@NotNull @NotBlank String createdUser) {
		super();
		this.name = name;
		this.countryId = countryId;
		this.createdUser = createdUser;
    }


    public Author() {
    }

    public Author(int authorId, String name, int countryId, Country country, int state, Date createdOn, String createdUser, Date modifiedOn, String modifiedUser) {
        this.authorId = authorId;
        this.name = name;
        this.countryId = countryId;
        this.country = country;
        this.state = state;
        this.createdOn = createdOn;
        this.createdUser = createdUser;
        this.modifiedOn = modifiedOn;
        this.modifiedUser = modifiedUser;
    }

    public int getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
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

    public Author authorId(int authorId) {
        this.authorId = authorId;
        return this;
    }

    public Author name(String name) {
        this.name = name;
        return this;
    }

    public Author countryId(int countryId) {
        this.countryId = countryId;
        return this;
    }

    public Author country(Country country) {
        this.country = country;
        return this;
    }

    public Author state(int state) {
        this.state = state;
        return this;
    }

    public Author createdOn(Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Author createdUser(String createdUser) {
        this.createdUser = createdUser;
        return this;
    }

    public Author modifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
        return this;
    }

    public Author modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

}