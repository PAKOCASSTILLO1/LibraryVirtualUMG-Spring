package gt.edu.umg.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;

@Entity
// @Table(name = "tc_role")
public class TcRole implements Serializable {

    private static final long serialVersionUID = -7387045179544684291L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "roleId")
    @SequenceGenerator(name = "roleId", sequenceName = "ID_ROLE")
    private long roleId;

    @NotNull
    private String roleDesc;

    @NotNull
    private byte statusId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @NotNull
    private String roleCode;


    public long getRoleId() {
        return this.roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleDesc() {
        return this.roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
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

    public String getRoleCode() {
        return this.roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }


}