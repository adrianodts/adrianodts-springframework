package com.adrianodts.springframework.javapersistenceapi.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    // @Column(name = "c_address_line_1")
    private String addressLineOne;

    // @Column(name = "c_address_line_2")
    private String addressLineTwo;

    // @Column(name = "c_city")
    private String city;

    // @Column(name = "c_state")
    private String state;

    // @Column(name = "c_zip_code")
    private String zipCode;

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    
}

