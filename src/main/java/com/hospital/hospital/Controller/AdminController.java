package com.hospital.hospital.Controller;

import com.hospital.hospital.Entities.Staff;
import com.hospital.hospital.Requests.StaffRequest;
import com.hospital.hospital.Services.AdminService;
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
    public ResponseEntity<?> newEncounter(@RequestBody StaffRequest request) {
        return adminService.createNewStaff(request);
    }

    @GetMapping("staffs")
    public List<Staff> getStaffs() {
        return adminService.getStaffs();
    }

    @GetMapping("staff")
    public ResponseEntity<?> getStaff(@RequestParam(required = false) String firstName) {
        return adminService.getStaff(firstName);
    }

    @PutMapping("/staff")
    public ResponseEntity<?> updateStaff(@RequestParam(required = true) String firstName, @RequestBody Staff updatedStaff) {
        return adminService.updateStaff(firstName, updatedStaff);
    }

    @DeleteMapping("/staff")
    public ResponseEntity<?> deleteStaff(@RequestParam(required = true) String firstName) {
        return adminService.deleteStaff(firstName);
    }
}
