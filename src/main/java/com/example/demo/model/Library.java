package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "library")
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
        name = "seq",
        sequenceName = "s_library",
        initialValue = 1,
        allocationSize = 1
)
public class Library extends AuditModel{
    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    public Library(String city) {
        this.city = city;
    }

    public Library(String address, String city) {
        this.address = address;
        this.city = city;
    }

    public Library() {
    }

    public Library(String name, String address, String phoneNumber, String city, String state) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
}
