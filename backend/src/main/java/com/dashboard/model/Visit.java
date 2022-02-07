package com.dashboard.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "visit")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(optional = false)
    private Customer customer;
    @NotNull
    @ManyToOne(optional = false)
    private IBX ibx;

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

    public Visit(Customer customer, IBX ibx, LocalDateTime startTime, LocalDateTime endTime, String purpose) {
        this.customer = customer;
        this.ibx = ibx;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public IBX getIbx() {
        return ibx;
    }

    public void setIbx(IBX ibx) {
        this.ibx = ibx;
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
