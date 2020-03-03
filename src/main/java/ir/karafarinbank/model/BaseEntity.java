package ir.karafarinbank.model;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_ON", nullable = false)
    private Date createOn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATE_ON", nullable = false)
    private Date updateOn;

    @PrePersist
    private void prePersist() {
        createOn = new Date();
        updateOn = new Date();
    }

    @PreUpdate
    private void preUpdate() {
        updateOn = new Date();
    }



    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public Date getUpdateOn() {
        return updateOn;
    }

    public void setUpdateOn(Date updateOn) {
        this.updateOn = updateOn;
    }
}
