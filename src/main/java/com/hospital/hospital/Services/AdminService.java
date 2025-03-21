package com.hospital.hospital.Services;

import com.hospital.hospital.Entities.Staff;
import com.hospital.hospital.Repository.StaffRepository;
import com.hospital.hospital.Requests.StaffRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final StaffRepository staffRepository;

    public AdminService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public ResponseEntity<?> createNewStaff(StaffRequest request){
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

    public List<Staff> getStaff() {
        return staffRepository.findAll();
    }
}
