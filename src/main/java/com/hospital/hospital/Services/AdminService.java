package com.hospital.hospital.Services;

import com.hospital.hospital.Entities.Encounter;
import com.hospital.hospital.Entities.Staff;
import com.hospital.hospital.Repository.EncounterRepository;
import com.hospital.hospital.Repository.StaffRepository;
import com.hospital.hospital.Requests.StaffRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;

@Service
public class AdminService {

    private final StaffRepository staffRepository;
    private final EncounterRepository encounterRepository;

    public AdminService(StaffRepository staffRepository, EncounterRepository encounterRepository) {
        this.staffRepository = staffRepository;
        this.encounterRepository =  encounterRepository;
    }

    public ResponseEntity<?> createNewStaff(StaffRequest request) {
        Staff staff = new Staff();
        staff.setFirstName(request.getFirstName());
        staff.setLastName(request.getLastName());
        staff.setHonorifics(request.getHonorifics());
        staff.setGender(request.getGender());
        staff.setEmail(request.getEmail());
        staff.setPhoneNumber(request.getPhoneNumber());
        staff.setAddress(request.getAddress());

        Staff saveStaff = staffRepository.save(staff);
        return ResponseEntity.ok("success saved Staff : " + saveStaff);
    }

    public List<Staff> getStaffs() {
        return staffRepository.findAll();
    }

    public ResponseEntity<?> getStaff(String firstName) {

        Staff staff = staffRepository.findByFirstName(firstName);

        if (staff != null) {
            return ResponseEntity.ok(staff);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Staff with first name " + firstName + " not found.");
        }

    }

    public ResponseEntity<?> updateStaff(String firstName, Staff updatedStaff) {
        Staff staff = staffRepository.findByFirstName(firstName);

        if (staff != null) {
            staff.setFirstName(updatedStaff.getFirstName());
            staff.setLastName(updatedStaff.getLastName());
            staff.setEmail(updatedStaff.getEmail());
            staff.setGender(updatedStaff.getGender());
            staff.setPhoneNumber(updatedStaff.getPhoneNumber());
            staff.setHonorifics(updatedStaff.getHonorifics());
            staff.setAddress(updatedStaff.getAddress());

            staffRepository.save(staff);
            return ResponseEntity.ok("Successfully updated");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Staff with first name " + firstName + " not found.");
        }
    }

    public ResponseEntity<?> deleteStaff(String firstName) {
        Staff staff = staffRepository.findByFirstName(firstName);

        if (staff != null) {
            Optional<String> encounter = encounterRepository.findByAssignDoctorId(staff.getId());
            if (!encounter.isEmpty()) {
                
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("Cannot delete staff with active encounters.");
            }
            staffRepository.deleteById(staff.getId());
            return ResponseEntity.ok("Successfully deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Staff with first name " + firstName + " not found.");
        }
    }

}
