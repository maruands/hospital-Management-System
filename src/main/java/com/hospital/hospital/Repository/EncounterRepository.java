package com.hospital.hospital.Repository;

import com.hospital.hospital.Entities.Encounter;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EncounterRepository extends JpaRepository<Encounter, Integer> {

    @Query(value = "select e.assign_doctor_id FROM encounters e WHERE e.assign_doctor_id=?1 Limit 1",nativeQuery = true)
    public Optional<String> findByAssignDoctorId(Integer id);
}
