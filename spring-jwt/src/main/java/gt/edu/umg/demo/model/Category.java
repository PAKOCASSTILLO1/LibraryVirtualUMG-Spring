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
 * Category
 */
@Entity
public class Category implements Serializable{

    private static final long serialVersionUID = -7408805966076393067L;

    // PRIMARY KEY
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "categoryId")
    @SequenceGenerator(name = "categoryId", sequenceName = "ID_CATEGORY")
    public int categoryId;
    
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

    public Category modified(Category body){
        this.name = body.getName();
        this.modifiedOn = new Date();
        if (body.getModifiedUser()==null) {
            this.modifiedUser = body.getCreatedUser();
        } else {
            this.modifiedUser = body.getModifiedUser();
        }
        return this;
    }

    public Category() {
    }

    public Category(int categoryId, String name, int state, Date createdOn, String createdUser, Date modifiedOn, String modifiedUser) {
        this.categoryId = categoryId;
        this.name = name;
        this.state = state;
        this.createdOn = createdOn;
        this.createdUser = createdUser;
        this.modifiedOn = modifiedOn;
        this.modifiedUser = modifiedUser;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    public Category categoryId(int categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public Category name(String name) {
        this.name = name;
        return this;
    }

    public Category state(int state) {
        this.state = state;
        return this;
    }

    public Category createdOn(Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Category createdUser(String createdUser) {
        this.createdUser = createdUser;
        return this;
    }

    public Category modifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
        return this;
    }

    public Category modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

}