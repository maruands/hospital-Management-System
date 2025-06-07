/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.hospital.hospital.Entities;

/**
 *
 * @author andrew
 */
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity 
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Change to IDENTITY for MySQL
    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private Date dob;
    private String patientStatus;
    private String phoneNumber;
    private String occupation;
    private String email;

    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");


    // Default Constructor
    public Patient() {}

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return (dob != null) ? formatter.format(dob) : null;
    }

    public void setDob(String dob) {
        try {
            this.dob = formatter.parse(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getPatientStatus() {
        return patientStatus;
    }

    public void setPatientStatus(String patientStatus) {
        this.patientStatus = patientStatus;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    // toString() Method for Better Logging
    @Override
    public String toString() {
        return "PatientRequest{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", patientStatus='" + patientStatus + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", occupation='" + occupation + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
