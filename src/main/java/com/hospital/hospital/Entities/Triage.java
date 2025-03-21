package com.hospital.hospital.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "triage")
public class Triage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "encounter_id", referencedColumnName = "id", nullable = false)
    private Encounter encounter;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "id", nullable = false)
    private Staff staff;

    private int temperature;
    private int weight;
    private String bloodPressure;

    public Triage() {}

    public Integer getId() {
        return id;
    }

    public Encounter getEncounter(){
        return encounter;
    }

    public Patient getPatient() {
        return patient;
    }

    public Staff getStaff(){
        return staff;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getWeight() {
        return weight;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    // setters
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public void setEncounter(Encounter encounter) {
        this.encounter = encounter;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

}
