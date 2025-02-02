package com.example.ttb.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class V1GetUserResponse implements Serializable {
    private String customerId;
    private String firstName;
    private String lastName;
    private ZonedDateTime customerDate;
    private Boolean isVip;
    private String statusCode;
    private ZonedDateTime createdOn;
    private ZonedDateTime modifiedOn;
    private String totalSales;
    private String salesRank;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ZonedDateTime getCustomerDate() {
        return customerDate;
    }

    public void setCustomerDate(ZonedDateTime customerDate) {
        this.customerDate = customerDate;
    }

    public Boolean getVip() {
        return isVip;
    }

    public void setVip(Boolean vip) {
        isVip = vip;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public ZonedDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(ZonedDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public ZonedDateTime getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(ZonedDateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(String totalSales) {
        this.totalSales = totalSales;
    }

    public String getSalesRank() {
        return salesRank;
    }

    public void setSalesRank(String salesRank) {
        this.salesRank = salesRank;
    }
}