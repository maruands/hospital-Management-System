/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.hospital.hospital.Controller;

import com.hospital.hospital.Entities.Encounter;
import com.hospital.hospital.Entities.Patient;
import com.hospital.hospital.Requests.EncounterRequest;
import com.hospital.hospital.Requests.PatientRequest;
import com.hospital.hospital.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author andrew
 */
@RestController
@RequestMapping(path = "api/v1/patient")
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping()
    public ResponseEntity<?> createPatient(@RequestBody PatientRequest request){
        return patientService.createPatient(request);
    }

    @GetMapping()
    public List<Patient> getPatients(){
        return patientService.getPatient();
    }

    @PostMapping("newEncounter")
    public ResponseEntity<?> newEncounter(@RequestBody EncounterRequest request){
        return patientService.createNewEncounter(request);
    }

    @GetMapping("newEncounter")
    public List<Encounter> getNewEncounter(){ return patientService.getNewEncounter();}
}
