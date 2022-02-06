package com.dashboard.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "visit")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer customerId;
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer ibxId;

    @Basic(optional = false)
    @Column(nullable = false)
    private LocalDateTime startTime;
    @Basic(optional = false)
    @Column(nullable = false)
    private LocalDateTime endTime;

    @Basic(optional = false)
    @Column(nullable = false)
    private String purpose;

    public Visit() {
    }

    public Visit(Integer customerId, Integer ibxId, LocalDateTime startTime, LocalDateTime endTime, String purpose) {
        this.customerId = customerId;
        this.ibxId = ibxId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.purpose = purpose;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getIbxId() {
        return ibxId;
    }

    public void setIbxId(Integer ibxId) {
        this.ibxId = ibxId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

}