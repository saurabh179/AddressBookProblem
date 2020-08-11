package com.base;

import java.util.Objects;

public class PersonInfo {

    private String firstName;
    private String lastName;
    private String address;
    private String cityName;
    private String stateName;
    private String zipCode;
    private String phoneNumber;
    private String fullName;

    public PersonInfo(){

    }


    public PersonInfo(String firstName, String lastName, String address, String cityName,
                      String stateName, String zipCode, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.cityName = cityName;
        this.stateName = stateName;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String firstName, String lastName) {
        this.fullName = firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "{ " + "Name='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + cityName + '\'' +
                ", state='" + stateName + '\'' +
                ", zip Code='" + zipCode + '\'' +
                ", Phone Number='" + phoneNumber + '\''+" }"+"\n" ;
    }

}
