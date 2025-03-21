package com.hospital.hospital.Repository;

import com.hospital.hospital.Entities.Encounter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EncounterRepository extends JpaRepository<Encounter, Integer> {
}
