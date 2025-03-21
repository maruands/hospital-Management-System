package com.hospital.hospital.Requests;

import jakarta.persistence.Entity;

import java.util.Date;

public class EncounterRequest {
    private int assignDoctor_id;
    private int patient_id;
    private Date encounterDateTime;
    private String status;

    public int getAssignDoctor_id(){
        return assignDoctor_id;
    }

    public void setAssignDoctor_id(int assignDoctor_id){
        this.assignDoctor_id = assignDoctor_id;
    }

    public Date getEncounterDateTime(){
        return encounterDateTime;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public void setEncounterDateTime(Date encounterDateTime){
        this.encounterDateTime = encounterDateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
