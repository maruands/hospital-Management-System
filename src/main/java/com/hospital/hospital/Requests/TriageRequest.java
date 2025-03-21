package com.hospital.hospital.Requests;

public class TriageRequest {
    private int encounter_id;
    private int patient_id;
    private int temperature;
    private int weight;
    private String bloodPressure;
    private int staff_id;

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public void setEncounter_id(int encounter_id) {
        this.encounter_id = encounter_id;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public int getEncounter_id() {
        return encounter_id;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public int getWeight() {
        return weight;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }
}
