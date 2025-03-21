package com.hospital.hospital.Entities;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name = "encounters")
public class Encounter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "assignDoctor_id", referencedColumnName = "id", nullable = false)
    private Staff staff; // Reference to Staff entity

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
    private Patient patient; // Reference to Patient entity

    // Constructors
    public Encounter() {}

    // Getters
    public Integer getId() {
        return id;
    }

    public Staff getStaff() {
        return staff;
    }

    public Patient getPatient() {
        return patient;
    }

    // Setters
    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
