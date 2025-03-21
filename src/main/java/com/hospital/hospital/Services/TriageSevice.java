package com.hospital.hospital.Services;

import com.hospital.hospital.Entities.Encounter;
import com.hospital.hospital.Entities.Patient;
import com.hospital.hospital.Entities.Staff;
import com.hospital.hospital.Entities.Triage;
import com.hospital.hospital.PatientRepository;
import com.hospital.hospital.Repository.EncounterRepository;
import com.hospital.hospital.Repository.StaffRepository;
import com.hospital.hospital.Repository.TriageRepository;
import com.hospital.hospital.Requests.TriageRequest;
import org.springframework.http.ResponseEntity;

public class TriageSevice {

    private final PatientRepository patientRepository;
    private final StaffRepository staffRepository;
    private final EncounterRepository encounterRepository;
    private final TriageRepository triageRepository;

    public TriageSevice(PatientRepository patientRepository, StaffRepository staffRepository, EncounterRepository encounterRepository, TriageRepository triageRepository) {
        this.patientRepository = patientRepository;
        this.staffRepository = staffRepository;
        this.encounterRepository = encounterRepository;
        this.triageRepository = triageRepository;
    }

    public ResponseEntity<?> createTriage(TriageRequest request){
        Triage triage = new Triage();
        Staff staff = staffRepository.findById(request.getStaff_id()).orElseThrow();
        Patient patient = patientRepository.findById(request.getPatient_id()).orElseThrow();
        Encounter encounter = encounterRepository.findById(request.getEncounter_id()).orElseThrow();

        triage.setPatient(patient);
        triage.setStaff(staff);
        triage.setEncounter(encounter);
        triage.setTemperature(request.getTemperature());
        triage.setWeight(request.getWeight());
        triage.setBloodPressure(request.getBloodPressure());

        Triage saveTriage = triageRepository.save(triage);

        return ResponseEntity.ok("successfully saved : " + saveTriage);
    }
}
