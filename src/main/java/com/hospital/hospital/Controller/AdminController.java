package com.hospital.hospital.Controller;

import com.hospital.hospital.Entities.Patient;
import com.hospital.hospital.Entities.Staff;
import com.hospital.hospital.Requests.EncounterRequest;
import com.hospital.hospital.Requests.StaffRequest;
import com.hospital.hospital.Services.AdminService;
import com.hospital.hospital.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("staff")
    public ResponseEntity<?> newEncounter(@RequestBody StaffRequest request){
        return adminService.createNewStaff(request);
    }

    @GetMapping("staffs")
    public List<Staff> getStaffs(){
        return adminService.getStaff();
    }
}
