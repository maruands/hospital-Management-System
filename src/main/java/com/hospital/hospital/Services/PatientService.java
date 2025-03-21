package com.hospital.hospital.Services;

import com.hospital.hospital.Entities.Encounter;
import com.hospital.hospital.Entities.Patient;
import com.hospital.hospital.Entities.Staff;
import com.hospital.hospital.PatientRepository;
import com.hospital.hospital.Repository.EncounterRepository;
import com.hospital.hospital.Repository.StaffRepository;
import com.hospital.hospital.Requests.EncounterRequest;
import com.hospital.hospital.Requests.PatientRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final StaffRepository staffRepository;
    private final EncounterRepository encounterRepository;

    public PatientService(PatientRepository patientRepository, StaffRepository staffRepository, EncounterRepository encounterRepository) {
        this.patientRepository = patientRepository;
        this.staffRepository = staffRepository;
        this.encounterRepository = encounterRepository;
    }

    public ResponseEntity<?> createPatient(PatientRequest request) {

        Patient patient = new Patient();
        patient.setFirstName(request.getFirstName());
        patient.setMiddleName(request.getMiddleName());
        patient.setLastName(request.getLastName());
        patient.setGender(request.getGender());
        patient.setDob(request.getDob());
        patient.setPatientStatus(request.getPatientStatus());
        patient.setPhoneNumber(request.getPhoneNumber());
        patient.setOccupation(request.getOccupation());
        patient.setEmail(request.getEmail());

        Patient savedPatient = patientRepository.save(patient);
        System.out.println("Saved Patient: " + savedPatient);

        return ResponseEntity.ok("success");
    }

    public List<Patient> getPatient(){
        return patientRepository.findAll();
    }

    public ResponseEntity<?> createNewEncounter(EncounterRequest request){
        Encounter encounter = new Encounter();
        Staff staff = staffRepository.findById(request.getAssignDoctor_id()).orElseThrow();
        Patient patient = patientRepository.findById(request.getPatient_id()).orElseThrow();

        encounter.setStaff(staff);
        encounter.setPatient(patient);
        Encounter savedEncounter = encounterRepository.save(encounter);

        return ResponseEntity.ok("successfuly saved : " + savedEncounter);
    }

    public List<Encounter> getNewEncounter() {
        return encounterRepository.findAll();
    }
}
