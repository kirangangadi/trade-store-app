package com.db.tradestore.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@MappedSuperclass
public class StatefulEntity implements Serializable {

    private Date createdDate;

    @PrePersist
    private void initializeInsert() {
        Timestamp currentDate = new Timestamp(new Date().getTime());
        this.createdDate = currentDate;
    }

    @Column(name = "CREATED_TS", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
