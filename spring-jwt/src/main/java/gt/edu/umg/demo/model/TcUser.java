package gt.edu.umg.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
// import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
// import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;

@Entity
// @Table(name = "tc_user", uniqueConstraints = {@UniqueConstraint(columnNames = { "username"}),
//     @UniqueConstraint(columnNames = { "email"})})
public class TcUser implements Serializable {

    private static final long serialVersionUID = -7387045179544684821L;


    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "userId")
    @SequenceGenerator(name = "userId", sequenceName = "ID_USER")
    private int userId;

    @NotNull
    private String fullname;

    @NotNull
    private String username;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private byte statusId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    private String photo;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private TcRole tcRole;


    public TcUser() {
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getStatusId() {
        return this.statusId;
    }

    public void setStatusId(byte statusId) {
        this.statusId = statusId;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public TcRole getTcRole() {
        return this.tcRole;
    }

    public void setTcRole(TcRole tcRole) {
        this.tcRole = tcRole;
    }

}