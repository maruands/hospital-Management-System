package com.hospital.hospital.Repository;

import com.hospital.hospital.Entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff,Integer> {
    
    Staff findByFirstName(String firstName);
}
